package InterviewBit;

/**
 * Created by shyamsunderpandita on 18/11/16.
 */
public class isIntegerPalindrome {

    public static boolean isPalindrome(int a) {
        if(a < 0){
            return false;
        }
        int res = 0;
        int c = 0;
        int k = a;

        //get length of int
        while(k/10 >0){
            k = k/10;
            c++;
        }

        k = a;
        while(c>=0){
            res = res+((k%10) * ((int)Math.pow(10,c)));
            c--;
            k = k/10;
        }

        if(res == a ){
            return true;
        }

        return false;
    }

    public static void main(String... args){
        System.out.println(isPalindrome(14744741));
    }

}
