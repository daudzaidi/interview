package Amazon.HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by shyamsunderpandita on 15/12/16.
 */
public class AkashAndGCD {

    public static int gcd (int x, int y){
        int divisor = (x < y) ? x : y;
        int dividend = (x > y) ? x : y;

        int remainder = dividend % divisor;

        while(remainder!=0){
            dividend = divisor;
            divisor = remainder;
            remainder = dividend % divisor;
        }

        return divisor;
    }

    public static int customFunction(int x){
        int result = 0;
        for(int i = 1 ; i <=x ; i++){
            result+=gcd(i,x);
        }

        return result;
    }

    public static void main(String args[] ) throws Exception {

        //Scanner
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(s.readLine()); // size of array
        int [] arr = new int[N];
        String numbers = s.readLine();
        String[] num = numbers.split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(num[i]);
        }

        int Q = Integer.parseInt(s.readLine()); // number of queries

        for (int i = 0 ; i < Q ; i++){
            String query = s.readLine();
            String[] values = query.split(" ");
            int x = Integer.parseInt(values[1]);
            int y = Integer.parseInt(values[2]);
            if(values[0].equals("C")){
                int larger = (x > y) ? x : y;
                int smaller = (x < y) ? x : y;
                int result = 0;
                for(int j = smaller-1 ; j <larger ; j++){
                    result+=customFunction(arr[j]);
                }
                double m = Math.pow(10,9)+7;
                result = result % ((int)m);
                System.out.println(result);
            }
            else{
                arr[x-1] = y;
            }
        }


    }
}
