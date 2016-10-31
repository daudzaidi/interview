package Hackerrank.CrackingTheCodingInterview;

import java.util.Scanner;

/**
 * Created by shalvi on 29/09/16.
 */
public class Fibonacci {
    public static long fibonacci(int n) {
        // Complete the function.
        long f1 = 0;
        long f2 = 1;
        long fib = 0;
        if(n == 0){
            return f1;
        }

        if(n == 1){
            return f2;
        }

        int num = 2;
        while(num!=n+1){
            fib = f1 + f2;
            f1 = f2;
            f2 = fib;
            num++;
        }
        return fib;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
