import java.util.ArrayList;
import java.util.List;


import java.util.Arrays;
import java.util.Random;
public class App {
    public static void main(String[] args) throws Exception {
        // int arrayint[] = new int[] {12,3,4,6,10,2,5,7,8};

        
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
        quicksort(arregloReducido);

        }
    

    public static void quicksort(int a[]){
        int ResultadoArrayint[];
        ResultadoArrayint = doPartition(a, 0, a.length-1);
        // for(int cadena :ResultadoArrayint) {
        //     System.out.print(cadena+" ");
        // }

    }


    public static int[] doPartition(int a[],int start, int end){
        if (a==null){
            System.out.println("el arreglo no puede estar vacio");
            return null;
        }

        if (start>= end) return a;
        int middle = start + (end - start) / 2;
        int pivote = a[middle];
        // System.out.println("pivote "+pivote);
        int i = start;
        int j = end;

        while (i <= j){
            while (a[i]<pivote) i++;
            while (a[j]>pivote) j--;

            if (i<=j){
                int x=a[i];
                a[i]=a[j];
                a[j]=x;
                i++;
                j--;
            }
        }

        if (start < j) doPartition(a, start, j);
        if (i < end) doPartition(a, i, end);
        return a;

    }
    }


}
