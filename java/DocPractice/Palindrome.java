package DocPractice;

/**
 * Created by shalvi on 22/05/16.
 */
// Check Palindrome

import java.util.Stack;

/**
 ASSUMPTIONS:
 String Data Type
 Using extra DS stacks for iterative way
 Not using extra space for recursive way
 Cases :
 abccba - even numbered
 null
 a
 1234321- odd numbered
 **/

public class Palindrome {
    public boolean checkPlaindromeIterative(String str){
        if(str == null)
            return false;

        // add all elements to stack (O(n))
        Stack stack = new Stack();
        for(int i =0 ;i< str.length(); i++){
            stack.push(str.charAt(i));
        }

//comparing elements of stack with str (O(n))

        for (int i =0 ;i< str.length();i++){
          /*  if(stack.pop() = =str.charAt(i))
                return false;*/
        }

        return true;
    }

    public boolean checkPalindromeWithoutSpace(String str){

        if(str == null)
            return false;
        // get the middle of the string(O(1))- in case of string
        System.out.println("String: "+str);
        int len = str.length();
        int mid = (int) Math.floor(len/2);
        System.out.println("String Middle Point at index : "+mid+" which is = "+str.charAt(mid));
        int i =0;
        while(i<mid){
            int j = len - 1 - i;
            System.out.println("str["+i+"] = "+str.charAt(i)+"   and   str["+j+"] = "+str.charAt(j));
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
        }

        return true;
    }


    public static void main(String[] args){
        Palindrome palindrome = new Palindrome();
        boolean res = palindrome.checkPalindromeWithoutSpace("abccba");
        if(res){
            System.out.println("It is a palindrome");
        }
        else{
            System.out.println("It is not a palindrome");
        }

        res = palindrome.checkPalindromeWithoutSpace("1234321");
        if(res){
            System.out.println("It is a palindrome");
        }
        else{
            System.out.println("It is not a palindrome");
        }

        res = palindrome.checkPalindromeWithoutSpace("a");
        if(res){
            System.out.println("It is a palindrome");
        }
        else{
            System.out.println("It is not a palindrome");
        }

        res = palindrome.checkPalindromeWithoutSpace("null");
        if(res){
            System.out.println("It is a palindrome");
        }
        else{
            System.out.println("It is not a palindrome");
        }

        res = palindrome.checkPalindromeWithoutSpace("shalvi");
        if(res){
            System.out.println("It is a palindrome");
        }
        else{
            System.out.println("It is not a palindrome");
        }
    }

}

