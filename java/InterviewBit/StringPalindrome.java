package InterviewBit;

import java.util.Stack;

/**
 * Created by shyamsunderpandita on 24/11/16.
 */
public class StringPalindrome {
    public static int isPalindrome(String a) {
        String finalString = getAlphanumericString(a);
        finalString = finalString.toLowerCase();
        System.out.println(finalString);
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < finalString.length(); i++){
            stack.push(finalString.charAt(i));
        }

        int c = 0;
        while(!stack.isEmpty()){
            if(stack.pop()!=finalString.charAt(c++)){
                return 0;
            }

        }

        return 1;
    }

    public static String getAlphanumericString(String a){
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < a.length(); i++){
            if(isAlphanumeric(a.charAt(i))){
                builder.append(a.charAt(i));
            }
        }

        return builder.toString();
    }
    public static boolean isAlphanumeric(char c) {

        if (c < 0x30 || (c >= 0x3a && c <= 0x40) || (c > 0x5a && c <= 0x60) || c > 0x7a){
            return false;
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

    public static void main(String... args){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
