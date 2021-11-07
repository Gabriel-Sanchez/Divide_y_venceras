import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;
import java.util.Random;

public class App {
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
        
        public void algoritmo() {


            // for (int i = 0; i < arregloReducido.length; i++) {
            //     System.out.print(i+"-");
            // }

            Arrays.sort(datosPrueba, 0, N);
        }

        //-----------------------------------------------------------------------------
        public void insercionDirecta(){
            int A[] = arregloReducido;
            int p, j;
            int aux;
            for (p = 1; p < A.length; p++){ // desde el segundo elemento hasta
                      aux = A[p];           // el final, guardamos el elemento y
                      j = p - 1;            // empezamos a comprobar con el anterior
                      while ((j >= 0) && (aux < A[j])){ // mientras queden posiciones y el                                
                                                        // valor de aux sea menor que los
                                     A[j + 1] = A[j];   // de la izquierda, se desplaza a
                                     j--;               // la derecha
                      }
                      A[j + 1] = aux;       // colocamos aux en su sitio
            }
        }

        //-------------------------------------------------------
        public  void quicksort() {
            
            quicksort(arregloReducido, 0, N);

        }



        public  void quicksort(int A[], int izq, int der) {

            int pivote=A[izq]; // tomamos primer elemento como pivote
            int i=izq;         // i realiza la búsqueda de izquierda a derecha
            int j=der;         // j realiza la búsqueda de derecha a izquierda
            int aux;
           
            while(i < j){                          // mientras no se crucen las búsquedas                                   
               while(A[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
               while(A[j] > pivote) j--;           // busca elemento menor que pivote
               if (i < j) {                        // si no se han cruzado                      
                   aux= A[i];                      // los intercambia
                   A[i]=A[j];
                   A[j]=aux;
               }
             }
             
             A[izq]=A[j];      // se coloca el pivote en su lugar de forma que tendremos                                    
             A[j]=pivote;      // los menores a su izquierda y los mayores a su derecha
             
             if(izq < j-1)
                quicksort(A,izq,j-1);          // ordenamos subarray izquierdo
             if(j+1 < der)
                quicksort(A,j+1,der);          // ordenamos subarray derecho
             
        }

        //seleccion --------------------------------------------------------------------------------
        public void seleccion() {
            int A[] = arregloReducido;
            int i, j, menor, pos, tmp;
            for (i = 0; i < A.length - 1; i++) {      // tomamos como menor el primero
                  menor = A[i];                       // de los elementos que quedan por ordenar                    
                  pos = i;                            // y guardamos su posición
                  for (j = i + 1; j < A.length; j++){ // buscamos en el resto
                        if (A[j] < menor) {           // del array algún elemento
                            menor = A[j];             // menor que el actual
                            pos = j;
                        }
                  }
                  if (pos != i){                      // si hay alguno menor se intercambia                         
                      tmp = A[i];
                      A[i] = A[pos];
                      A[pos] = tmp;
                  }
            }
  }


  public void burbuja() {

    int[] A = arregloReducido;
    int i, j, aux;
    for (i = 0; i < A.length - 1; i++) {
        for (j = 0; j < A.length - i - 1; j++) {
            if (A[j + 1] < A[j]) {
                aux = A[j + 1];
                A[j + 1] = A[j];
                A[j] = aux;
            }
        }
    }
}
    
        @Override
        public String toString() {
            return "Datos [N=" + N + "]";
        }
        }
    
    public static void main(String[] args) {
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
                //  datos.algoritmo();
                // datos.insercionDirecta();
                 datos.seleccion(); 
                // datos.burbuja();

                long t2 = System.nanoTime();
                nn=(t2 - t0);
            }
            list.add(N+" "+nn);
            System.out.println(N+" "+nn);

        }

        guardar(list);

    }

    public static void guardar(List<String> list){
        try {
            PrintWriter writer = new PrintWriter("ms.txt", "UTF-8");
            for(String cadena :list) {
                writer.println(cadena);
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
