package Amazon.Tagged;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by shyamsunderpandita on 18/10/16.
 */
public class MatchSpecificPattern {

    //assuming small characters only a-z
    public static void matchPattern(String[] dict, String pattern){

        for(int i = 0 ; i< dict.length; i++){
            String str = dict[i];
            int patternNum = getPatternNum(str);
            int matchPattern = getPatternNum(pattern);
            if(patternNum == matchPattern){
                System.out.println(str);
            }
        }

    }

    public static int getPatternNum(String str){
        int[] pat = new int[str.length()];
        Map<Character,Integer> map = new HashMap<>();
        int c = 0;
        for(int j = 0 ; j< str.length();j++){
            if(map.containsKey(str.charAt(j))){
                pat[j] = map.get(str.charAt(j));
            }
            else{
                pat[j] = c;
                map.put(str.charAt(j),c);
                c++;
            }
        }
        int patternNum = 0 ;
        for(int k = 0 ; k<pat.length ; k++){
            int p = (int) Math.pow(10,pat.length-1-k);
            patternNum+=pat[k]*(p);
        }
        return patternNum;
    }

    public static void main(String... args){
        MatchSpecificPattern.matchPattern(new String[]{"abb", "abc", "xyz", "xyy"},"fot");
    }
}
