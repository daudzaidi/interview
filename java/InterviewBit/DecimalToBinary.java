package InterviewBit;

import java.util.Stack;

/**
 * Created by shyamsunderpandita on 18/11/16.
 */
public class DecimalToBinary {
    public static String findDigitsInBinary(int a) {
        StringBuilder binary = new StringBuilder();
        if(a == 0){
            binary.append("0");
        }

        if(a == 1){
            binary.append("1");
        }

        Stack<Integer> stack = new Stack<Integer>();
        if(a > 1){
            while(a/2 >=1){
                stack.push(a%2);
                a = a/2;
            }

                stack.push(a);


            while(!stack.isEmpty()){
                binary.append(stack.pop()+"");
            }
        }
        return binary.toString();
    }

    public static void main(String... args){
        int a = 10;
        System.out.println(findDigitsInBinary(a));
    }
}
