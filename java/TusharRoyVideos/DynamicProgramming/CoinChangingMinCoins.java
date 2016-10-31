package TusharRoyVideos.DynamicProgramming;

import java.util.ArrayList;

/**
 * Created by shalvi on 10/08/16.
 */
public class CoinChangingMinCoins {

    public void getMinCoins (int[] coins, int total){
        if(!validateData(coins,total)){
            return;
        }

        int[] T1 = new int[total+1];
        int[] T2 = new int[total+1];
        T1[0] = 0;
        for(int i = 1 ; i<=total ;i++){
            T1[i] =  Integer.MAX_VALUE-2;
        }

        for(int i = 0 ; i<=total ;i++){
            T2[i] =  -1;
        }

        for(int j = 0 ; j< coins.length ;j++){
            for(int i = 1 ;i<=total;i++){
                if(i >= coins[j]){
                    int min = Math.min(T1[i],1+T1[i-coins[j]]);
                    if(min!=T1[i]){
                        T2[i] = j;
                        T1[i] = min;
                    }
                }
            }
        }

        System.out.println("Minimum number of coins required are = "+T1[total]);
        ArrayList<Integer> result = traceback(T1,T2,coins,total);
        display(result);
    }

    private void display(ArrayList<Integer> result) {
        System.out.print("The coins are : ");
        for(Integer res : result){
            System.out.print  (res+" ");
        }
    }

    private ArrayList<Integer> traceback(int[] T1, int[] T2, int[] coins, int total) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = total;
        while(i>0){

            if(T1[i] != Integer.MAX_VALUE-2){
                result.add(coins[T2[i]]);
                i = i - coins[T2[i]];
            }
        }
        return result;
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
        CoinChangingMinCoins problem = new CoinChangingMinCoins();
        int[] coins ={7,2,3,6};
        int total = 13;
        problem.getMinCoins(coins,total);
    }
}
