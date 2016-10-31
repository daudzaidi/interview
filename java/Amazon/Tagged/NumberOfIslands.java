package Amazon.Tagged;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shyamsunderpandita on 21/10/16.
 */
public class NumberOfIslands {

    public static boolean[][] mat;
    public static int islands (int[][]A){

        int rows = A.length;
        int cols = A[0].length;


        mat = new boolean[rows][cols];
        for(int i = 0 ; i<rows; i++){
            for(int j = 0 ; j<cols ; j++)
                mat[i][j] = false;
        }

        int count = 0 ;
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j< cols ; j++){

                if(A[i][j] == 1 && mat[i][j] == false){
                    int isIsland = checkIsland(A,i,j);
                    if (isIsland!=-1)
                        count++;
                }

            }

        }
        return count;
    }

    public static int []rowIndex = {-1,-1,-1,0,0,1,1,1};
    public static int []colIndex = {-1,0,1,-1,1,-1,0,1};

    private static int checkIsland(int[][] a, int i, int j) {

        if(i >= a.length || j >=a[0].length || i < 0 || j <0)
            return -1;

        if(mat[i][j] == true)
            return -1;

        mat[i][j] = true;

        if(a[i][j] == 0)
            return -1;

        int[] index = new int[8];
        index[0] = checkIsland(a,i-1,j-1);
        index[1] = checkIsland(a,i-1,j);
        index[2] = checkIsland(a,i-1,j+1);
        index[3] = checkIsland(a,i,j-1);
        index[4] = checkIsland(a,i,j+1);
        index[5] = checkIsland(a,i+1,j-1);
        index[6] = checkIsland(a,i+1,j);
        index[7] = checkIsland(a,i+1,j+1);

        for(int k = 0 ; k<8 ; k++){
            if(index[k] != -1){
                checkIsland(a,i+rowIndex[k],j+colIndex[k]);
            }
        }

        return 1;
    }

    public static void main(String... args){
        int a [][]= {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        System.out.println("COUNT = "+NumberOfIslands.islands(a));

        int b [][]= {
                {1, 1, 0},
                {0, 0, 1},
                {1, 0, 1}
        };

        System.out.println("COUNT = "+NumberOfIslands.islands(b));
    }
}

class Index{
    int i;
    int j;
    public Index(int i , int j){
        this.i = i ;
        this.j = j ;
    }
}