package Amazon.Tagged;

/**
 * Created by shyamsunderpandita on 21/10/16.
 */
public class SpiralMatrix {

    // O(N square) solution
    public static int findKthElement(int[][] arr, int k){
        int rows = arr.length;
        int cols = arr[0].length;

        if(rows == 0 && cols ==0)
            return 0;

        if (k > rows*cols)
            return 0;
        int direction = 0;
        int c = 1;
        for(int i = 0 ; i< rows ;i++){
            if(direction == 1){
                for(int j = cols-1 ; j >=0 ; j--){
                    if(c == k)
                        return arr[i][j];

                    c++;
                }

                direction = 0;
            }
            else{
                for(int j = 0 ; j< cols ; j++){
                    if(c == k)
                        return arr[i][j];

                    c++;
                }

                direction =1;
            }
        }

        return 0;
    }

    public static void main(String... args){
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};

        System.out.println("Kth Element is  -> "+SpiralMatrix.findKthElement(a,4));
        System.out.println("Kth Element is  -> "+SpiralMatrix.findKthElement(a,1));
        System.out.println("Kth Element is  -> "+SpiralMatrix.findKthElement(a,41));
        System.out.println("Kth Element is  -> "+SpiralMatrix.findKthElement(a,12));
        System.out.println("Kth Element is  -> "+SpiralMatrix.findKthElement(a,0));
    }
}
