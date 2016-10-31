package Hackerrank.CrackingTheCodingInterview;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by shalvi on 04/10/16.
 */
public class ConnectedCellInAGrid {

    static int [][] visited ;

    public static int getBiggestRegion(int[][] matrix) {
        int rows = matrix.length;
        int cols = 0;
        if(rows >=1)
            cols = matrix[0].length;  // assuming rows >= 1
        visited = new int[rows][cols];
        int max = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(visited[i][j] == 0) max = Math.max(max, dfs(matrix, rows-1,cols-1, i, j));
            }
        }
        return max;
    }

    public static int dfs(int[][]matrix, int rows, int cols, int i, int j){
        if(i>rows || j > cols || i <0 || j<0){
            return 0;
        }
        if(visited[i][j] == 1)
            return 0;

        visited[i][j] = 1;
        if(matrix[i][j] == 0){
            return 0;
        }
        else{
            return 1 + dfs(matrix,rows,cols,i-1,j-1) + dfs(matrix,rows,cols,i-1,j) + dfs(matrix,rows,cols,i-1,j+1)
                    + dfs(matrix,rows,cols,i,j-1) + dfs(matrix,rows,cols,i,j+1) + dfs(matrix,rows,cols,i+1,j-1) +
                    dfs(matrix,rows,cols,i+1,j) + dfs(matrix,rows,cols,i+1,j+1) ;
        }


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }
}



