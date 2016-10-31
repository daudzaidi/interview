package Hackerrank.ThirtyDayCode;

import java.util.Scanner;

/**
 * Created by shyamsunderpandita on 25/10/16.
 */
public class Bitwise {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            printMaxValue(n,k);
            if(((k-1)|k) >= n && k%2==0){
                System.out.println(k-2);
            }else{
                System.out.println(k-1);
            }
        }
    }

    public static void printMaxValue(int n , int k){
        int max = 0 ;
        for(int i = 1 ; i<n ; i++){
            for(int j = i+1 ; j<n ; j++){
                int res = i & j;
                if(res > max && res < k)
                    max = res;
            }
        }

        System.out.println(max);
    }
}
