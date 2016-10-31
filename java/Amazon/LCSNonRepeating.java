package Amazon;

/**
 * Created by shalvi on 27/09/16.
 */
public class LCSNonRepeating {

    static Integer[] S = new Integer[256];

    public static int findLCS (String input){
        for(int i = 0 ; i< S.length ;i++){
            S[i] = -1;
        }

        int maximum_l = 1;
        int current_l = 1;
        S[input.charAt(0)] = 0; // stores last occurrence of a particular character

        for(int i = 1; i< input.length() ;i++){
            if(S[input.charAt(i)] == -1){
                current_l++;
            }
            else{
                maximum_l = Math.max(maximum_l,current_l);
                current_l = i - S[input.charAt(i)];
            }
            S[input.charAt(i)] = i;
        }

        maximum_l = Math.max(maximum_l,current_l);
        return maximum_l;

    }

    public static void main(String... args){
        String input1 = "abcabcbb";
        String input2 = "bbbbb";
        String input3 = "pwwkew";

        System.out.println("Length of Longest Common Substring with non repeating character for input "+input1 +" is : "+findLCS(input1));
        System.out.println("Length of Longest Common Substring with non repeating character for input "+input2 +" is : "+findLCS(input2));
        System.out.println("Length of Longest Common Substring with non repeating character for input "+input3 +" is : "+findLCS(input3));
    }
}
