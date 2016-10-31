package Hackerrank.CrackingTheCodingInterview;

import java.util.Scanner;

/**
 * Created by shalvi on 05/10/16.
 */
public class PrimalityTimeComplexity {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            boolean isPrime = checkPrime(n);
            if(isPrime)
                System.out.println("Prime");
            else
                System.out.println("Not prime");
        }
    }

    public static boolean checkPrime(int n){
        if(n == 0 || n ==1)
            return false;
        double size = Math.sqrt(n);
        for(int i = 2 ; i<=size;i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
