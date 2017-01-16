package InterviewBit;

/**
 * Created by shyamsunderpandita on 16/01/17.
 */
public class DecodingDigits {

    public int numDecodings(String a) {
        return numDecodings(a,a.length());
    }

    private int numDecodings(String a, int n) {
        if(n == 0 || n == 1){
            return 1;
        }

        int count = 0;
        if(a.charAt(n-1) > '0'){
            count = count + numDecodings(a,n-1);
        }

        if(a.charAt(n-2) <= '2' && a.charAt(n-2) > '0' && a.charAt(n-1) <'7'){
            count = count + numDecodings(a,n-2);
        }
        return count;
    }



    private int numDecodingsDP(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0')
            return 0;
        if(s.length()==1)
            return 1;

        int[] dp = new int[s.length()];
        dp[0]=1;
        if(Integer.parseInt(s.substring(0,2))>26){
            if(s.charAt(1)!='0'){
                dp[1]=1;
            }else{
                dp[1]=0;
            }
        }else{
            if(s.charAt(1)!='0'){
                dp[1]=2;
            }else{
                dp[1]=1;
            }
        }

        for(int i=2; i<s.length(); i++){
            if(s.charAt(i)!='0'){
                dp[i]+=dp[i-1];
            }

            int val = Integer.parseInt(s.substring(i-1, i+1));
            if(val<=26 && val >=10){
                dp[i]+=dp[i-2];
            }
        }

        return dp[s.length()-1];
    }


    public static void main(String... args){
        DecodingDigits d = new DecodingDigits();
        /*System.out.println(d.numDecodings("12623"));
        System.out.println(d.numDecodings("12"));
        System.out.println(d.numDecodings("1244552345"));*/
        System.out.println(d.numDecodingsDP("12623"));
        System.out.println(d.numDecodingsDP("12"));
        System.out.println(d.numDecodingsDP("1244552345"));
        System.out.println(d.numDecodingsDP("12445523450"));
        System.out.println(d.numDecodingsDP("0"));
        System.out.println(d.numDecodingsDP("10"));

    }
}
