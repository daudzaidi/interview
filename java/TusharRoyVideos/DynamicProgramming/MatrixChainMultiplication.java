package TusharRoyVideos.DynamicProgramming;

import DesignQuestions.ImageSystem.InterfaceType;

/**
 * Created by shalvi on 06/08/16.
 */
public class MatrixChainMultiplication {

    public int findMinCost(int[] p, int n){
        int[][] T = new int[n][n];
        for(int i = 1; i< n ;i++){
            T[i][i] =0;
        }

        int L,cost,i,j,k;

        for (i = 1; i < n; i++)
            T[i][i] = 0;

        // L is chain length.
        for (L=2; L<n; L++)
        {
            for (i=1; i<n-L+1; i++)
            {
                j = i+L-1;
                T[i][j] = Integer.MAX_VALUE;
                for (k=i; k<=j-1; k++)
                {
                    // q = cost/scalar multiplications
                    cost = T[i][k] + T[k+1][j] + p[i-1]*p[k]*p[j];
                    if (cost < T[i][j])
                        T[i][j] = cost;
                }
            }
        }

        System.out.println("Min Cost is = "+T[1][n-1]);
        return T[1][n-1];
    }

    public static void main(String... args){
        MatrixChainMultiplication problem = new MatrixChainMultiplication();
        int[] p = {2,3,6,4,5};
        problem.findMinCost(p,5);
    }
}
