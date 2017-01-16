package InterviewBit;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by shyamsunderpandita on 06/01/17.
 */
public class RedundantBraces {
    public int braces(String str) {
        int N = str.length();
        Stack<Character> Stk= new Stack<Character>();


        for(int i = 0; i < N; ++i) {

            if(str.charAt(i) == ')') {

                int cnt = 0;

                while(Stk.peek() != '(') {
                    Stk.pop();
                    cnt++;
                }

                Stk.pop();
                if(cnt < 2)
                    return 1;
            }

            else {
                Stk.push(str.charAt(i));
            }

        }

        boolean is = true;

        while(Stk.size()>0) {

            if(Stk.peek() == '(' || Stk.peek() == ')') {
                is = false;
                break;
            }
            Stk.pop();
        }

        if(!is)
        {
            return 1;
        }
        return 0;
    }

    public static void main(String... args){
        RedundantBraces b = new RedundantBraces();
        System.out.println(b.braces("((a+b))"));
    }
}
