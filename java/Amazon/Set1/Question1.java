package Amazon.Set1;

import java.util.Stack;

/**
 * Created by shalvi on 27/06/16.
 */
public class Question1 {

    public static boolean isBalanced(String expr){
        if(expr == null) return false;

        Stack<Character> stack = new Stack();
        stack.push(expr.charAt(0));
        int count = 1;
        int length = expr.length();
        while(count!=length){
            char pop = stack.peek();

            if(closing(pop,expr.charAt(count))==true){
                stack.pop();
            }
            else{
                stack.push(expr.charAt(count));
                count++;
                continue;
            }

            count++;
            if(stack.isEmpty() && count!=length){
                stack.push(expr.charAt(count));
                count++;
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }

    private static boolean closing(char o, char c) {
        if((o == '[' && c == ']') || (o == '{' && c == '}') || (o == '(' && c == ')'))
            return true;
        else if((c == '[' && o == ']') || (c == '{' && o == '}') || (c == '(' && o == ')'))
            return true;
        return false;
    }

    public static void main(String... args){
        System.out.println("expression balanced : [()]{[{()()}]} ===> "+ isBalanced("[()]{[{()()}]}") );
        System.out.println("expression balanced : [(()){{} ===> "+ isBalanced("[(()){{}") );
    }
}
