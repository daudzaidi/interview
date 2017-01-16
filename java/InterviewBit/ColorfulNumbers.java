package InterviewBit;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shyamsunderpandita on 08/01/17.
 * For Given Number N find if its COLORFUL number or not

 Return 0/1

 COLORFUL number:

 A number can be broken into different contiguous sub-subsequence parts.
 Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
 Example:

 N = 23
 2 3 23
 2 -> 2
 3 -> 3
 23 -> 6
 this number is a COLORFUL number since product of every digit of a sub-sequence are different.

 */
public class ColorfulNumbers {
    public int colorful(int a) {
        int result = 1;
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = a;
        List<Integer> digits = new ArrayList<>();
        while(n>0){
            int digit = n%10;
            digits.add(digit);
            n = n/10;
        }

        for(int i = 0 ; i < digits.size() ; i++){
            int product = 1;
            for(int j = i ; j < digits.size() ; j++ ){

                if(i == j){
                    product = product * digits.get(i);
                }
                else{
                    product = product * digits.get(j);
                }

                if(map.containsKey(product)){
                    return 0;
                }
                else{

                    map.put(product,1);
                }
            }
        }
        return result;
    }

    public static void main(String... args){
        ColorfulNumbers c = new ColorfulNumbers();
        System.out.println(c.colorful(23));
        System.out.println(c.colorful(3245));
        System.out.println(c.colorful(20));
        System.out.println(c.colorful(1));
        System.out.println(c.colorful(100));
        System.out.println(c.colorful(67));
    }
}
