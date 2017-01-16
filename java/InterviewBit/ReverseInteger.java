package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 18/11/16.
 */
public class ReverseInteger {
    public static int reverse(int A) {
        // use long to monitor Stack Overflow
        long result = 0;
        while (A != 0) {
            result = result * 10 + (A % 10);
            A = A / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) result;
        }

    }

    public static void main(String... args){
       // System.out.println(reverse(-1234567891));
       // System.out.println(reverse(-1146467285));
        System.out.println(reverse(-81328070));
        ArrayList<Integer> a = new ArrayList<>();

    }
}
