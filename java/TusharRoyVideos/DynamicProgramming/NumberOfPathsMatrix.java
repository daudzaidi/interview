package TusharRoyVideos.DynamicProgramming;

/**
 * Created by shalvi on 12/08/16.
 */
public class NumberOfPathsMatrix {
    int numberOfPathsRec (int n , int m){
        if(m==1 || n==1)
            return 1;
        return numberOfPathsRec(m-1,n) + numberOfPathsRec(m,n-1);
    }

    int numberOfPathsRecWith01 (int[][]arr, int n , int m){
        if(arr[m-1][n-1] ==0)
            return 0;
        if((m==1 || n==1) && arr[m-1][n]!=0 && arr[m][n-1]!=0)
            return 1;
        return numberOfPathsRecWith01(arr,m-1,n) + numberOfPathsRecWith01(arr,m,n-1);
    }

    int numberOfPathsDP(int n, int m){
        int[][]T = new int[n][m];
        for(int i = 0 ;i<n ;i++){
            T[i][0] =1;
        }
        for(int j = 0 ;j<m ;j++){
            T[0][j] =1;
        }

        for(int i = 1 ;i<n ;i++){
            for(int j = 1 ; j<m ;j++){
                T[i][j] = T[i-1][j] + T[i][j-1];
            }
        }
        return T[n-1][m-1];
    }

    public static void main(String... args){
        NumberOfPathsMatrix problem = new NumberOfPathsMatrix();
        System.out.println("Number of ways to reach from 0,0 to n-1,n-1 Recursive = "+problem.numberOfPathsRec(3,3));
        System.out.println("Number of ways to reach from 0,0 to n-1,n-1 DP = "+problem.numberOfPathsDP(3,3));
        int[][]arr = {{1,1},{0,1}};
        System.out.println("Number of ways to reach from 0,0 to n-1,n-1 Recursive = "+problem.numberOfPathsRecWith01(arr,2,2));
        int[][]arr2 = {{1,1,1},{0,0,0},{1,1,1}};
        System.out.println("Number of ways to reach from 0,0 to n-1,n-1 Recursive = "+problem.numberOfPathsRecWith01(arr2,3,3));
    }
}
