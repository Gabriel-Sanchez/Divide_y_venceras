import java.util.ArrayList;
import java.util.List;


import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // int[] arrayint = new int[] {2, 5, 8, 12, 16,23,38,56,72,91};
        System.out.println();

        //contenido

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

        //fin contenido

        //fin main
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
            searchBinary(arregloReducido,0 );
        }
        //-----------------------------------------------------------------------------


        public static int searchBinary(int A[], int x){
            if(A==null || A.length == 0){
                System.out.println("Error: el arreglo esta vacio");
                return -1;
            }
            return searchBinary(A,0,A.length-1, x);
        }
    
        public static int searchBinary(int A[], int start , int end , int x){
            if (start > end || start < 0 || end >= A.length ){
                // System.out.println("Error: indice fuera del rango");
                return -1;
            }
    
            if (start == end ){
                if(A[start]==x) return start;
                else return -1;
            }else{
                int m = start + (end -start )/2;
                if (x==A[m]) return m;
                else if (x<A[m]) return searchBinary(A,start,m-1, x);
                else return searchBinary(A,m+1,end,x);
            }
    
        }
    
            //---------------------------------------
        @Override
        public String toString() {
            return "Datos [N=" + N + "]";
        }
        }

}
