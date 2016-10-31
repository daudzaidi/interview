package Amazon.Tagged;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shyamsunderpandita on 26/10/16.
 */
public class LargestArrayWithEqual01 {

    public static int findSubarray(int[] arr){
        int maxLen = 0 ;
        int start = 0 ;
        int end = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            int curr_sum = (arr[i] == 0) ? -1 : 1 ;
            for(int j = i+1 ; j < arr.length ; j++){
                curr_sum+=(arr[j] == 0) ? -1 : 1;
                if(curr_sum == 0 && maxLen < j+1-i){
                    maxLen = j+1-i;
                    start = i;
                }
            }
        }
        end = start+maxLen-1;
        System.out.println("Starting index = "+start+"   Ending Index = "+end);
        return maxLen;
    }

    public static void main(String... args){
        int[] a = {1, 0 , 1, 1, 1 , 0, 0};
        System.out.println("Maximum Length of Subarray Wih Sum 0 = "+findSubarray(a));

    }
}
