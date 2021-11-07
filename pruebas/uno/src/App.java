import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        String list2[] = { "5099023", "10049849", "27268133", "59154985", "124892599", "342082804", "729927088", "1546868027", "4161772150", "8817641280", "18540020616", "49852784330" };

// int o = 0;
// for (String string : list1) {

//     System.out.println(string+"\n"+list2[o]+"\n");
//     o++;
// }


        // System.out.println(list); // prints "[1, 2, 3]"
        // System.out.println(list1); // prints "[1, 2, 3]"
        for (int i = 0; i < 500; i++) {
            int N = 100;
            Datos datos = new Datos(N);
            datos.algoritmo();
        }
    
        int[] tamanos = {100, 200, 500, 1000, 2000, 5000, 10000, 20000, 50000,100000,200000,500000};
        int casos = 1000;
        long nn = 0;
        int o= 0;
        for (int N : tamanos) {
            long t0 = System.nanoTime();
            for (int i = 0; i < casos; i++) {
                Datos datos = new Datos(N);
                datos.algoritmo();
                long t2 = System.nanoTime();
                nn=(t2 - t0);
            }
            // System.out.printf("%d:%d%n", N, nn);
            System.out.println(N+"\n"+nn+"\n"+list2[o]+"\n");
            o++;
            list.add(N+" "+nn+"\n");

        }
        // System.out.printf("%d:%d%n", N, (t2 - t0));


        // long nnn = 0;

        // System.out.printf("%d:%d%n", N, nnn);

        // list.add(N+" "+(t2 - t0)+"\n");
        // nnn = nnn + (t2 - t0);

        // System.out.println(list);
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


    // public class Logger { 
    //     public static void log(String message) throws IOException { 
    //         PrintWriter out = new PrintWriter(new FileWriter("output.txt"), true); 
    //         out.write(message); 
    //         out.close(); } 
    //     }




    // public static void main(String[] args) {
    //     for (int i = 0; i < 500; i++) {
    //     int N = 100;
    //     Datos datos = new Datos(N);
    //     datos.algoritmo();
    //     }
    //     int[] tamanos = {100, 200, 500, 1000, 2000, 5000, 10000};
    //     int casos = 1000;
    //     for (int N : tamanos) {
    //     long t0 = System.currentTimeMillis();
    //     for (int i = 0; i < casos; i++) {
    //     Datos datos = new Datos(N);
    //     datos.algoritmo();
    //     long t2 = System.currentTimeMillis();
    //     System.out.printf("N= %6d: %,5dms%n", N, (t2 - t0));
    //     }
    //     }
    // }



    

}