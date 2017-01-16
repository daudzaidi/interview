package InterviewBit;

import java.util.HashMap;

/**
 * Created by shyamsunderpandita on 18/11/16.
 */
public class ExcelTitleToNumber {
    public static int titleToNumber(String a) {

        int number = 0;

        for (int i = 0; i < a.length(); i++) {
            number = number * 26 + (a.charAt(i) - ('A' - 1));
        }
        return number;

    }

    public static void main(String... args){
        System.out.println(titleToNumber("AAA"));
    }
}
