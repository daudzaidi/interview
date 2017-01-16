package InterviewBit;

import java.util.Stack;
import java.util.stream.Collector;

/**
 * Created by shyamsunderpandita on 18/11/16.
 */
public class ExcelNumberToTitle {


    public static String numberToTitle(int a) {

        StringBuilder sb = new StringBuilder();
        while (a-- > 0) {
            sb.append((char)('A' + (a % 26)));
            a /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String... args){
        System.out.println(numberToTitle(943566));
    }
}
