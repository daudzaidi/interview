package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shyamsunderpandita on 18/11/16.
 */
public class Factorization {
    public static ArrayList<Integer> allFactors(int a) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        output.add(1);
        int limit = (int) Math.sqrt(a);
        for(int i = 2 ; i <= limit ; i++){
            if(a%i == 0){
                output.add(i);
                if(a/i != i){
                    output.add(a/i);
                }
            }

        }
        if(a!=1){
            output.add(a);
        }

        Collections.sort(output);
        return output;
    }

    public static void main(String... args){
        int a = 79629;
        System.out.println(allFactors(a));
    }
}
