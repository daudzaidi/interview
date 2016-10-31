package Amazon.Tagged;

import java.util.HashMap;

/**
 * Created by shyamsunderpandita on 26/10/16.
 */
public class LargestSubarrayWith0Sum {

    public static int findMaxLenSimple(int[] arr){
        int maxLen = 0 ;

        for(int i = 0 ; i < arr.length; i++){
            int currSum = arr[i] ;
            for(int j = i+1 ; j < arr.length ; j++){
                currSum+=arr[j];
                if(currSum == 0)
                    maxLen=Math.max(maxLen,j+1-i);
            }
        }

        return maxLen;
    }

    public static int findMaxlenHashing(int[]arr){
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        int sum = 0;      // Initialize sum of elements
        int max_len = 0;  // Initialize result

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++)
        {
            // Add current element to sum
            sum += arr[i];

            if (arr[i] == 0 && max_len == 0)
                max_len = 1;

            if (sum == 0)
                max_len = i+1;

            // Look this sum in hash table
            Integer prev_i = hM.get(sum);

            // If this sum is seen before, then update max_len
            // if required
            if (prev_i != null)
                max_len = Math.max(max_len, i-prev_i);
            else  // Else put this sum in hash table
                hM.put(sum, i);
        }

        return max_len;
    }

    public static void main(String... args){
        int[] a = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Maximum Length of Subarray Wih Sum 0 = "+findMaxLenSimple(a));
        System.out.println("Maximum Length of Subarray Wih Sum 0 = "+findMaxlenHashing(a));
    }
}
