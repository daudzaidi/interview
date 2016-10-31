package Hackerrank.CrackingTheCodingInterview;

import java.util.Scanner;

/**
 * Created by shalvi on 05/10/16.
 */
public class RecursionDavisStaircase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(waysToReachStaircase(n));
        }
    }

    public static int waysToReachStaircase(int n){
        if (n < 0)
            return 0;
        return recursive(n);
    }

    public static int recursive(int n){
        if(n <=1)
            return 1;

        int[] paths = {1,1,2};
        for(int i = 3 ; i<=n ; i++){
            int count = paths[2]+paths[1]+paths[0];
            paths[0]=paths[1];
            paths[1]=paths[2];
            paths[2]=count;
        }
        return paths[2];
    }
}
