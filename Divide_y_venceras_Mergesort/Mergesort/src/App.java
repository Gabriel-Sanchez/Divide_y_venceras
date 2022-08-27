import java.util.ArrayList;
import java.util.List;


import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int arrayint[] = new int[] {3,4,6,10,2,5,7,8,12};
        int ResultadoArrayint[];


        for(int cadena :arrayint) {
            System.out.print(cadena+" ");
          }
        
        // ResultadoArrayint = mergesort(arrayint);
        System.out.println("");

        System.out.println("ordenado");


        // for(int cadena :ResultadoArrayint) {
        //     System.out.print(cadena+" ");
        // }





        //inicio

        List<String> list = new ArrayList<String>();

        for (int i = 0; i < 500; i++) {
            int N = 100;
            Datos datos = new Datos(N);
            datos.algoritmo();
        }
    
        int[] tamanos = {100, 200, 300, 400, 500, 600, 700, 800, 1000, 2000, 5000, 10000, 20000, 50000};
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
        //fin




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
        mergesort(arregloReducido);
    }




    
public static int[] mergesort(int a[]){
    if (a == null){
        System.out.println("el arreglo no puede estar vacio");
        return null;
    }
    return mergesort(a,0,a.length-1);
}

public static int[] mergesort(int a[], int start,int end){

    if (start == end) return new int[]{a[start]};
    
    int middle = (start+end)/2;
    int[] m1 = mergesort(a,start,middle);
    int[] m2 = mergesort(a,middle+1,end);
    int m[] = merge(m1,m2);
    return m;
}


public static int[] merge(int a[], int b[]){
    if (a==null || b==null ){
        System.out.println("el arreglo no puede estar vacio");
        return null;
    }

    int m[]= new int[a.length+b.length];
    int k = 0;
    int i = 0;
    int j = 0;

    while(i<a.length && j<b.length)
    {
        if(a[i]<b[j]){
            m[k]=a[i];
            i++;
        }else{
            m[k]=b[j];
            j++;
        }
        k++;
    }

    while(i<a.length){
        m[k]=a[i];
        i++;
        k++;
    }
    while(j<b.length){
        m[k]=b[j];
        j++;
        k++;
    }
    return m;
}
}

}
