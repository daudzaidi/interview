package EulerProject;

/**
 * Created by shalvi on 18/05/16.
 */
public class SumOfEvenFibonacciNumbers {
    //sum of all even numbered fibonacci series less than 4,000,000
    public static int sum (){
        int a = 0;
        int b = 2;
        int sum = 0;
        int res = 2;
        while (sum < 4000000){
            sum +=res;
            res = 4 * b + a;
            a = b;
            b = res;
            /*System.out.println("a = "+a);
            System.out.println("b = "+b);
            System.out.println("third = "+third);
            System.out.println("sum = "+sum);*/
        }
     return sum;
    }

    //correct
    public static long sum2(){

        long fib3 = 2;
        long fib6 = 0;
        long result = 2;
        long summed = 0;

        while (result < 4000000) {
            summed += result;

            result = 4*fib3 + fib6;
            fib6 = fib3;
            fib3 = result;
        }
        return summed;
    }
    public static void main(String... args){
        System.out.println("The sum of even numbered fibonacci series less than 4000000 is : "+ SumOfEvenFibonacciNumbers.sum2());
        System.out.println("The sum of even numbered fibonacci series less than 4000000 is : "+ SumOfEvenFibonacciNumbers.sum());
    }
}
