package Amazon.Tagged;

/**
 * Created by shyamsunderpandita on 20/10/16.
 */
public class MaxSumInConfiguration {

    public static int maxSum(int[]arr, int n){

        int maxSum = 0 ;

        for(int i = 0 ; i<n ; i++){
            int sum = 0 ;
            for(int k = 0 ; k < n ; k++){
                sum+=arr[k]*k;
                maxSum=Math.max(sum,maxSum);
            }

            for(int j = n-1 ; j > 0 ;j--){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }

        return maxSum;
    }

    public static void main(String... args){
        int[]a = {8,3,1,2};
        System.out.println("MAX SUM IS = "+MaxSumInConfiguration.maxSum(a,a.length));
    }

}
