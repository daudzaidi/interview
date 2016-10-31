package Amazon.Tagged;

/**
 * Created by shyamsunderpandita on 19/10/16.
 */
public class WildcardPatternMatching {
    public static boolean patternMatches(String text, String pattern){
        if(text == null || pattern == null)
            return false;

        int textLen = text.length();
        int patLen = pattern.length();

        char[] t = text.toCharArray();
        char[] p = pattern.toCharArray();

        boolean[][] T = new boolean[textLen+1][patLen+1];

        T[0][0] = true;

        for(int i = 1 ; i<= textLen ;i++){
            T[i][0] = false;
        }

        T[0][1] = (p[0] == '*') ? true : false;

        boolean isFirst = T[0][1] == true ? true : false;
        for(int j = 2 ; j<=patLen ; j++){
            if(p[j-1] == '*' && isFirst)
                T[0][j] = true;
            else{
                T[0][j] = false;
                isFirst = false;
            }
        }


        for(int i = 1 ; i<=textLen ; i++){
            for(int j = 1 ; j <=patLen ; j++){
                if(p[j-1] == t[i-1] || p[j-1] == '?')
                    T[i][j] = T[i-1][j-1];
                else if(p[j-1] == '*')
                    T[i][j] = T[i-1][j] || T[i][j-1];
                else
                    T[i][j] = false;
            }
        }

        return T[textLen][patLen];
    }

    public static void main (String... args){
        System.out.println("Does Pattern match ? "+WildcardPatternMatching.patternMatches("xaylmz","x?y*z"));
        System.out.println("Does Pattern match ? "+WildcardPatternMatching.patternMatches("baaabab","*****ba*****ab"));
        System.out.println("Does Pattern match ? "+WildcardPatternMatching.patternMatches("baaabab","baaa?ab"));
        System.out.println("Does Pattern match ? "+WildcardPatternMatching.patternMatches("baaabab","ba*a?"));
        System.out.println("Does Pattern match ? "+WildcardPatternMatching.patternMatches("baaabab","a*ab"));
    }
}
