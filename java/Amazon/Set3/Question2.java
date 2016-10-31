package Amazon.Set3;

import java.util.*;

/**
 * Created by shalvi on 01/07/16.
 */
public class Question2 {

    static Map<Integer,Character> encodings = new TreeMap<>();

    public static int findStrings(String input){
        int output = 0;

        if(input.length()<=1){
            if(encodings.containsKey(input)){
                output++;
                System.out.println(encodings.get(input));
            }
            return output;
        }

        Map<Integer,String> listInput = new HashMap<>();

        for(int i = 0; i<=input.length();i++){
            for(int j = i+1 ;j<=input.length();j++){
                String in = input.substring(i,j);
                if(!listInput.containsKey(Integer.parseInt(in))){
                    StringBuilder builder = new StringBuilder();
                    for(int k =0 ; k< in.length();k++){
                        int key = Integer.parseInt(String.valueOf(in.charAt(k)));
                        if(encodings.containsKey(key)) {
                            builder.append(encodings.get(key));
                        }
                    }
                    listInput.put(Integer.parseInt(in),builder.toString());
                }
            }

        }

    return output;
    }


    static int countDecodingDP(String digits, int n)
    {
        int count[] = new int [n+1]; // A table to store results of subproblems
        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i <= n; i++)
        {
            count[i] = 0;

            // If the last digit is not 0, then last digit must add to
            // the number of words
            if (digits.charAt(i-1) > '0')
                count[i] = count[i-1];

            // If second last digit is smaller than 2 and last digit is
            // smaller than 7, then last two digits form a valid character
            if (digits.charAt(i-2) < '2' || (digits.charAt(i-2) == '2' && digits.charAt(i-1) < '7') )
                count[i] += count[i-2];
        }
        return count[n];
    }


    public static void main(String... args){
        int ascii = 97;
        for(int i =0; i<26;i++){
            int r = ascii+i;
            char c = (char)r;
            encodings.put(i,c);
        }

        //System.out.println("The number of such Strings are ===>" +findStrings("1104"));
        System.out.println("The number of such Strings are ===>" +countDecodingDP("1104",4));

    }
}
