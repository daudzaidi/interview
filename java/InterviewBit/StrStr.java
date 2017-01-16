package InterviewBit;

/**
 * Created by shyamsunderpandita on 25/11/16.
 */
public class StrStr {
    public static int strStr(final String haystack, final String needle) {
        if(haystack == null || needle == null){
            return -1;
        }

        int hayTracker = 0;
        int needleTracker = 0;
        int needleLen = needle.length();
        int hayLen = haystack.length();

        while(hayTracker < hayLen){
            int temp = hayTracker;
            while(needleTracker < needleLen && hayTracker < hayLen && needle.charAt(needleTracker) == haystack.charAt(hayTracker)){
                needleTracker ++;
                hayTracker++;
            }

            if(needleTracker == needleLen){
                return temp;
            }
            else{
                needleTracker = 0;
                hayTracker = temp+1;
            }
        }

        return -1;
    }

    public static void main(String... args){
        System.out.println(strStr("Hello World" , "lo"));
    }
}
