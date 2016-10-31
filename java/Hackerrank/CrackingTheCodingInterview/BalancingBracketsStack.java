package Hackerrank.CrackingTheCodingInterview;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by shalvi on 29/09/16.
 * 5
 }][}}(}][))]
 [](){()}
 ()
 ({}([][]))[]()
 {)[](}]}]}))}(())(

 OUTPUT :
 NO
 YES
 YES
 YES
 NO
 */
public class BalancingBracketsStack {
    public static boolean isBalanced(String expression) {
        if(expression == null){
            return true;
        }

        int len = expression.length();
        Stack<Character> stack = new Stack<Character>();
        boolean isBalanced = true;
        for(int i = 0 ;i<len ;i++){
            Character ch = expression.charAt(i);
            if(isOpenBracket(ch))
                stack.push(ch);
            else{
                if(stack.isEmpty()){
                    isBalanced = false;
                    break;
                }
                else{
                    Character top = stack.pop();
                    if(!areBracketsCompatible(top,ch)){
                        isBalanced = false;
                        break;
                    }

                }
            }
        }

        return (isBalanced && stack.empty()) ? true : false;
    }

    public static boolean areBracketsCompatible(Character a, Character b){
        if((a == '}' && b == '{') ||(a == '{' && b=='}')){
            return true;
        }

        if((a == ']' && b == '[') ||(a == '[' && b==']')){
            return true;
        }

        if((a == ')' && b == '(') ||(a == '(' && b==')')){
            return true;
        }

        return false;
    }

    public static boolean isOpenBracket(Character a){
        if(a == '[' || a== '{' || a=='(')
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            boolean answer = isBalanced(expression);
            if(answer)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
