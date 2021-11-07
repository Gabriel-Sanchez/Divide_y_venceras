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
        }
        
        public void algoritmo() {
            Arrays.sort(datosPrueba, 0, N);
        }

        public void insercionDirecta(){
            int A[] = datosPrueba;
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
        int casos = 100;
        long nn = 0;
        for (int N : tamanos) {
            long t0 = System.nanoTime();
            for (int i = 0; i < casos; i++) {
                Datos datos = new Datos(N);
                // datos.algoritmo();
                datos.insercionDirecta();
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
