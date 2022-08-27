import java.util.ArrayList;
import java.util.List;


import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arrayint = new int[] {34,6,500,-6,-66,7,48,65,33,65,501,102,0};
        // System.out.println(findMax (arrayint, 0, arrayint.length-1));



        
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < 500; i++) {
            int N = 100;
            Datos datos = new Datos(N);
            datos.algoritmo();
        }
    
        int[] tamanos = {100, 200, 300, 400, 500, 600, 700, 800, 1000};
        int casos = 1000;
        long nn = 0;
        for (int N : tamanos) {
            long t0 = System.nanoTime();
            for (int i = 0; i < casos; i++) {
                Datos datos = new Datos(N);
  
                datos.algoritmo();

                long t2 = System.nanoTime();
                nn=(t2 - t0);
            }
            list.add(N+" "+nn);
            System.out.println(N+" "+nn);

        }


    }

    
    public static class Datos {
        public static final int MAX = 1000000;
        private static final Random RANDOM;
        private static final int[] datosAleatorios;
        private static final int[] datosPrueba;
     
        private final int N;
        private final int[] arregloReducido;

        static {
            RANDOM = new Random();
            datosAleatorios = new int[MAX];
            for (int i = 0; i < MAX; i++)
                datosAleatorios[i] = RANDOM.nextInt();
            datosPrueba = new int[MAX];
        }
        
        public Datos(int N) {
            this.N = N;
            int n0 = RANDOM.nextInt(MAX - N);
            System.arraycopy(datosAleatorios, n0, datosPrueba, 0, N);
            this.arregloReducido = Arrays.copyOfRange(datosPrueba, 0, N);
        }
        

        public void algoritmo(){
            findMax (arregloReducido, 0, arregloReducido.length-1);
        }

public static int findMax (int[] vector, int i, int j){  
    int med, max_left, max_right; 
    if (i==j)
        return vector[i]; 
    else 
        med = (i + j) / 2;
        max_left = findMax (vector, i, med); 
        max_right = findMax (vector, med+1,j );  
    
    if (max_left > max_right)  
        return max_left;
    else 
        return max_right;
    }
}
}