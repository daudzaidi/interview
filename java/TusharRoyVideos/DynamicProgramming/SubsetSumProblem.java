package TusharRoyVideos.DynamicProgramming;

import java.util.ArrayList;

/**
 * Given a set of non negative numbers and a total, we need to find if there exists a subset in the set
 * such that the total subset elements equlas the total given
 * e.g. Total = 11 , Subset = {2,3,7,8,10}
 * output : {3,8}
 */
public class SubsetSumProblem {

    public void findSubsetEqualTototal(int[] arr, int total){
        if(!validateData(arr,total)){
            return;
        }

        boolean[][] T = new boolean[arr.length][total+1];

        for(int i = 0 ; i< arr.length ; i++){
            T[i][0] = true;
        }

        for(int i = 0 ; i< arr.length ; i++){
            for(int j =1 ;j <=total; j++){
                if(i == 0){
                    if(j == arr[i])
                        T[i][j] = true;
                    else
                        T[i][j] = false;

                    continue;
                }

                if(j < arr[i])
                    T[i][j] = T[i-1][j];
                else
                    T[i][j] = T[i-1][j] || T[i-1][j-arr[i]];
            }
        }

        System.out.println("The subset equal to total exists = "+T[arr.length -1][total]);
        if(T[arr.length -1][total]){
            traceBack(T,arr,total);
        }
        else{
            System.out.println("No subset found");
        }
    }

    private void traceBack(boolean[][] T, int[] arr, int total) {
        int m = arr.length -1;
        int n = total;
        ArrayList<Integer> result = new ArrayList<>();
        while(m>0 && n>0){
            if(T[m-1][n] == true){
                m = m-1;
            }
            else{
                result.add(arr[m]);
                n = n - arr[m];
                m = m-1;
            }
        }
        display(result);
    }

    private void display(ArrayList<Integer> result) {
        System.out.print("The subset is { ");
        for(Integer res : result){
            System.out.print(res+" , ");
        }
        System.out.print(" }");
    }

    private boolean validateData(int[] arr, int total) {
        if(arr == null)
            return false;
        if(total < 0 || total > Integer.MAX_VALUE)
            return false;
        for(int i = 0 ;i < arr.length ; i++){
            if(arr[i] < 0)
                return false;
        }
        return true;
    }

    public static void main(String... args){
        int[] arr = {10,1,2,7,6,1,5};
        int total = 8;

        SubsetSumProblem problem = new SubsetSumProblem();
        problem.findSubsetEqualTototal(arr,total);
    }
}
