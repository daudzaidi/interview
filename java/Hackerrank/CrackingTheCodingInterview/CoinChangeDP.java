package Hackerrank.CrackingTheCodingInterview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by shalvi on 29/09/16.
 */
public class CoinChangeDP {

    public static long makeChange(int[] coins, int money) {
        if(!validateData(coins,money)){
            return 0;
        }
        long T[][] = new long[coins.length+1][money+1];
        for(int i = 0 ; i<= coins.length ; i++){
            T[i][0] = 1;
        }

        for(int i = 1 ; i<=coins.length ;i++){
            for(int j = 1 ; j<=money ; j++){
                if(coins[i-1] > j){
                    T[i][j] = T[i-1][j];
                }
                else{
                    T[i][j] = T[i-1][j] + T[i][j-coins[i-1]];
                }
            }
        }
        return T[coins.length][money];
    }


    private static boolean validateData(int[] arr, int total) {
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChange(coins, n));
    }
}
