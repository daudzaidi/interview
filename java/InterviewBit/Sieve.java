package InterviewBit;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by shyamsunderpandita on 18/11/16.
 */
public class Sieve {
    public static ArrayList<Integer> sieve(int a) {

        ArrayList<Integer> output = new ArrayList<Integer>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i = 2 ; i <=a ;i++){
            if(map.containsKey(i)){
                continue;
            }

            if(isPrime(i) == 1){
                output.add(i);
            }
            else{
                map.put(i,1);
                int j = 2;
                while(j*i <=a){
                    map.put(j*i,1);
                    j++;
                }
            }
        }
        return output;
    }

    public static int isPrime(int a){
        int isPrime = 1;
        if(a == 1){
            isPrime = 0;
            return isPrime;
        }

        if(a == 2){
            return isPrime;
        }

        int limit = (int) Math.sqrt(a);
        for(int i = 2 ; i <= limit; i++){
            if(a % i == 0){
                isPrime = 0 ;
                break;
            }
        }
        return isPrime;
    }

    public static void main(String... args){
        int a = 10;
        System.out.println(sieve(a));
    }
}
