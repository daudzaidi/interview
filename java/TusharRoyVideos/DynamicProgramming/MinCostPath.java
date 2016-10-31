package TusharRoyVideos.DynamicProgramming;

import java.util.ArrayList;

/**
 * Created by shalvi on 13/08/16.
 */
public class MinCostPath {

    public int findMinCost(int[][]arr,int m,int n){
        int[][]T = new int[m][n];
        for(int i = 0 ;i<m ;i++){
            for(int j = 0 ;j<n;j++){
                if(i == 0 && j==0) {
                    T[i][j]=arr[i][j];
                }
                else if(i == 0){
                    T[i][j] = arr[i][j] + T[i][j-1];
                }
                else if(j == 0){
                    T[i][j] = arr[i][j] + T[i-1][j];
                }
                else{
                    T[i][j] = arr[i][j] + Math.min(T[i-1][j],T[i][j-1]);
                }

            }
        }
        traceback(T,arr,m-1,n-1);
        return T[m-1][n-1];
    }

    private void traceback(int[][] T, int[][] arr, int m, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        while(m > 0 && n > 0){
            result.add(arr[m][n]);
            if( T[m-1][n] < T[m][n-1] ){
                m = m-1;
            }
            else{
                n = n-1;
            }
        }
        if(m != 0 || n!=0){
            result.add(arr[m][n]);
        }

        result.add(arr[0][0]);
        display(result);
    }

    private void display(ArrayList<Integer> result) {
        for(Integer res : result){
            System.out.println(res);
        }
    }

    public static void main(String... args){
        MinCostPath problem = new MinCostPath();
        int[][]arr = {{1,3,5,8},{4,2,1,7},{4,3,2,3}};
        System.out.println("Min cost path is = "+problem.findMinCost(arr,3,4));
    }
}
