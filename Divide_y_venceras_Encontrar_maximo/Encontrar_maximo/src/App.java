public class App {
    public static void main(String[] args) throws Exception {
        int[] arrayint = new int[] {34,6,500,-6,-66,7,48,65,33,65,501,102,0};
        System.out.println(findMax (arrayint, 0, arrayint.length-1));
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