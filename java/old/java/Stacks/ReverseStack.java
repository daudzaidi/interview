package old.java.Stacks;

import java.util.Stack;

/**
 * Created by pandita on 8/20/2015.
 */
public class ReverseStack {

    public static String reverseStack(String string){
        Stack<Character> stack = new Stack<Character>();
        StringBuilder reversed = new StringBuilder();

        for(int i =0;i<string.length();i++){
            stack.push(string.charAt(i));
        }

        while(!stack.isEmpty()){
            reversed.append(stack.pop());
        }
    return reversed.toString();
    }

    public static void main(String args[]){
        String rev = reverseStack("SHALVI");
        System.out.println(rev);
    }
}
