package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 11/01/17.
 * The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2
 There might be multiple gray code sequences possible for a given n.
 Return any such sequence.
 */
public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        if(n==0){
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }

        ArrayList<Integer> result = grayCode(n-1);
        int numToAdd = 1<<(n-1);

        for(int i=result.size()-1; i>=0; i--){
            result.add(numToAdd+result.get(i));
        }

        return result;
    }
    public static void main(String... args){
        GrayCode c = new GrayCode();
       /* System.out.println(c.grayCode(1));
        System.out.println(c.grayCode(2));*/
        System.out.println(c.grayCode(3));
       /* System.out.println(c.grayCode(4));
        System.out.println(c.grayCode(5));
        System.out.println(c.grayCode(6));*/
    }
}
