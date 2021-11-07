public class App {
    public static void main(String[] args) throws Exception {
        int arrayint[] = new int[] {12,3,4,6,10,2,5,7,8};

        quicksort(arrayint);

    }

    public static void quicksort(int a[]){
        int ResultadoArrayint[];
        ResultadoArrayint = doPartition(a, 0, a.length-1);
        for(int cadena :ResultadoArrayint) {
            System.out.print(cadena+" ");
        }

    }


    public static int[] doPartition(int a[],int start, int end){
        if (a==null){
            System.out.println("el arreglo no puede estar vacio");
            return null;
        }

        if (start>= end) return a;
        int middle = start + (end - start) / 2;
        int pivote = a[middle];
        System.out.println("pivote "+pivote);
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
