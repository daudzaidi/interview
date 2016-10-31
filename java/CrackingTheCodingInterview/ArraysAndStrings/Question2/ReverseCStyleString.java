package CrackingTheCodingInterview.ArraysAndStrings.Question2;

import BehavioralDP.ChainOfResponsibility.Chain;

import java.util.Stack;

/**
 * Created by shalvi on 24/04/16.
 */
public class ReverseCStyleString {

    public static String reverseStringUsingStack(String str){
        if(str == null)
            return null;

        Stack<Character> stack = new Stack<Character>();

        for(int i =0 ;i< str.length();i++){
            stack.push(str.charAt(i));
        }


        StringBuilder result = new StringBuilder();
        result.append('\0');
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        String res = result.toString();
        return res;

    }


    public static void main(String... args){

        System.out.println("Revered string : "+ ReverseCStyleString.reverseStringUsingStack("Shalvi"));
    }
}
