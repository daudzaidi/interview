package Amazon.Tagged;

/**
 * Created by shyamsunderpandita on 19/10/16.
 */
public class MaxSquareBinaryMatrix {

    public static int maxSquareArea (int[][]mat){
        System.out.println("GIVEN MATRIX =>");
        print(mat);
        int rows = mat.length;
        int cols = mat[0].length;

        if(rows == 0 && cols == 0)
            return 0;

        int[][]dp = new int[rows][cols];
        int max = mat[0][0];
        for(int i = 0 ; i<rows;i++){
            for(int j = 0 ; j<cols ; j++){
                if(i == 0 || j ==0){
                    dp[i][j] = mat[i][j];
                }
                else{
                    dp[i][j] = (mat[i][j]==0) ? 0 : 1+ min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1]);
                }

                max = Math.max(dp[i][j],max);
            }
        }
        System.out.println();
        System.out.println("DP MATRIX =>");
        print(dp);
        return max*max;
    }

    private static void print(int[][] dp) {
        for(int i = 0 ; i<dp.length ; i++){
            for(int j = 0 ; j<dp[0].length ; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int min(int a, int b, int c){
        int smaller = (a > b) ? b : a;
        return (smaller < c ) ? smaller : c;
    }


    public static void main(String... args) {
        int[][] a = {
                {1, 0, 0, 1, 1, 1},
                {1, 0, 1, 1, 0, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1},};

        System.out.println("Maximum Area of Square is = "+MaxSquareBinaryMatrix.maxSquareArea(a));
        int[][] b = {
                {0, 0, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1},};

        System.out.println("Maximum Area of Square is = "+MaxSquareBinaryMatrix.maxSquareArea(b));

    }
}
