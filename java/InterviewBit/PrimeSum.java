package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 18/11/16.
 */
public class PrimeSum {
    public static ArrayList<Integer> primesum(int a) {

        ArrayList<Integer> output = new ArrayList<Integer>();
        if(a ==2){
            return output;
        }

        for(int i = 2 ; i < a ; i++){
            if(isPrime(i) == 1 && isPrime(a-i) == 1){
                output.add(i);
                output.add(a-i);
                break;
            }
        }

        return output;
    }

    public static int isPrime(int a){
        if(a == 1 || a == 0){
            return 0;
        }

        if(a == 2){
            return 1;
        }

        int isPrime = 1;
        int limit = (int)Math.sqrt(a);

        for(int i = 2 ; i<= limit ; i++){
            if(a % i ==0 ){
                isPrime = 0;
                break;
            }
        }

        return isPrime;
    }

    public static void main(String... args){
        System.out.println(primesum(0));
    }
}
