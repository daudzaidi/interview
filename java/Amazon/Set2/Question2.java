package Amazon.Set2;

/**
 * Created by shalvi on 30/06/16.
 */
public class Question2 {

    public static int giveZeroIndex(int[] arr){
        int curr_zero_index = -1;
        int prev_zero_index = -1;
        int prev_prev_zero_index = -1;
        int maxIndex = 0;

        int max = 0;

        for(int i =0 ;i< arr.length;i++){
            if(arr[i] == 0){
                curr_zero_index = i;
                if(max < curr_zero_index-prev_prev_zero_index){
                    maxIndex = prev_zero_index;
                    max = Math.max(max,curr_zero_index-prev_prev_zero_index);
                }

                prev_prev_zero_index = prev_zero_index;
                prev_zero_index = curr_zero_index;
            }

        }
        int n = arr.length;
        if(n - prev_prev_zero_index >= max){
            maxIndex = prev_zero_index;
        }
        return maxIndex;
    }

    public static void main(String... args){
        int arr[]={1,0,1,1,0,1,0,1,1,1,0,1};
        int index = giveZeroIndex(arr);
        System.out.println("The zero index which gives max 1s is ===>"+index);
    }
}
