
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[] arrayint = new int[] {2, 5, 8, 12, 16,23,38,56,72,91};
        System.out.println(searchBinary(arrayint, 91));

        
    }


    public static int searchBinary(int A[], int x){
        if(A==null || A.length == 0){
            System.out.println("Error: el arreglo esta vacio");
            return -1;
        }
        return searchBinary(A,0,A.length-1, x);
    }

    public static int searchBinary(int A[], int start , int end , int x){
        if (start > end || start < 0 || end >= A.length ){
            System.out.println("Error: indice fuera del rango");
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
}
