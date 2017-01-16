package InterviewBit;

/**
 * Created by shyamsunderpandita on 28/11/16.
 */
public class LongestPalindrome {
    public String longestPalindrome(String a) {
        if(a == null || a.isEmpty() || a.length() == 1){
            return a;
        }

        String longestPalindrome = null;
        int maxLength = 0;

        int length = a.length();
        for(int i = 0 ; i <= length ; i++){
            for(int j = i ; j <= length ; j++){
                String sub = a.substring(i,j);
                if(sub.length()>maxLength &&isPalindrome(sub)){
                    maxLength = sub.length();
                    longestPalindrome = sub;
                }
            }
        }

        return longestPalindrome;
    }

    public boolean isPalindrome(String str){
        if(str.length() == 1){
            return true;
        }

        int mid = str.length()/2;
        int j = str.length()-1;

        for(int i=0; i < mid ; i++){
            if(str.charAt(i)!=str.charAt(j--)){
                return false;
            }
        }

        return true;
    }

    public static void main(String... args){
        LongestPalindrome problem = new LongestPalindrome();
        System.out.println(problem.longestPalindrome("aaaabaaa"));
    }
}
