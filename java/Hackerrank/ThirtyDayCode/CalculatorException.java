package Hackerrank.ThirtyDayCode;

import java.util.Scanner;

/**
 * Created by shalvi on 13/10/16.
 */
public class CalculatorException {

    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        int T=in.nextInt();
        while(T-->0)
        {
            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try
            {
                int ans=myCalculator.power(n,p);
                System.out.println(ans);

            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }

    }
}

//Write your code here
class Calculator {
    public int power(int n, int p) throws Exception {

        if(n < 0 || p < 0){
            throw new Exception("n and p should be non-negative");
        }
        else{
            return powerRecursive(n,p);
        }

    }

    public int powerRecursive(int n , int p){
        if(p == 0){
            return 1;
        }

        if(p == 1)
            return n;

        return n*(powerRecursive(n,p-1));
    }
}

class CustomException extends Exception{
    public CustomException(String message){
        super(message);
    }
}
