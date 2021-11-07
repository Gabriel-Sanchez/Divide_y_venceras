public class App {
    public static void main(String[] args) throws Exception {
        int arrayint[] = new int[] {3,4,6,10,2,5,7,8,12};
        int ResultadoArrayint[];


        for(int cadena :arrayint) {
            System.out.print(cadena+" ");
          }
        
        ResultadoArrayint = mergesort(arrayint);
        System.out.println("");

        System.out.println("ordenado");


        for(int cadena :ResultadoArrayint) {
            System.out.print(cadena+" ");
        }

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
