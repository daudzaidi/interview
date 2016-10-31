package DocPractice;

/**
 * Created by shalvi on 25/05/16.
 */
public class rotateMatrix90deg {
    int [][] arr = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
    };

    int [][] arr2 = {
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,20},
            {21,22,23,24,25}
    };

    //solution with extra space
        public int[][] rotateSpace(int[][] matrix) {
            if(matrix == null || matrix.length==0)
                return null ;

            int m = matrix.length;

            int[][] result = new int[m][m];

            for(int i=0; i<m; i++){
                for(int j=0; j<m; j++){
                    result[j][m-1-i] = matrix[i][j];
                }
            }

            return result;
        }


    //In place solution
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            System.out.println("INT ---> "+n/2);
            System.out.println("DOUBLE ---> "+(double)(n/2));
            System.out.println("INT Ceil---> "+Math.ceil(n/2));
            System.out.println("DOUBLE Ceil---> "+Math.ceil((double)(n/2)));
            System.out.println("DOUBLE Ceil with dot---> "+Math.ceil((double)(n/2.0)));
            System.out.println(Math.ceil(23.46));
            System.out.println(Math.floor(23.46));
            System.out.println(Math.ceil(n/2));
            for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][i];
                matrix[n-1-i][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }

    public void display(int[][]arr){
        for(int i =0 ;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String... args){
        rotateMatrix90deg r = new rotateMatrix90deg();
       // r.rotateMatrix(4);
        r.display(r.arr2);
        /*System.out.println("AFTER ROTATION :");
        r.rotate(r.arr);
        r.display(r.arr);*/

        System.out.println("AFTER ROTATION with solution using extra space:");
        //int[][] res = r.rotateSpace(r.arr2);
        r.rotate(r.arr2);
        r.display(r.arr2);
    }
}
