package TusharRoyVideos.DynamicProgramming;

/**
 * Created by shalvi on 11/08/16.
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLongestIncreasingSeq(int[] arr, int n){
        int[] T = new int[n];
        for(int i = 0 ;i<n ;i++){
            T[i] = 1;
        }

        for(int i = 1 ; i<n ;i++){
            int max = T[i];
            for(int j = 0 ; j< i ;j++){
                if(arr[j] < arr[i]){
                    if(max < T[i]+1){
                        T[i] = T[j]+1;
                    }
                }
            }
        }


        int maxIndex = n-1;
        for(int i = 0 ; i< n; i++){
            if(T[i] > T[maxIndex])
                maxIndex = i;
        }
        traceback(T,arr,maxIndex);
        return T[maxIndex];
    }

    private void traceback(int[] T, int[] arr, int n) {
        int len = 0;
        System.out.print("The sequence includes following elements : { ");
        for(int i = n;i>=0 ;i--){
            System.out.print(arr[i]+"  ");
            len++;
            int j = i;
            while(len<=T[n]&&i>0 && T[i-1]!=T[j]-1){
                i = i-1;
            }
        }
        System.out.print("}.  ");
    }

    public static void main(String... args){
        LongestIncreasingSubsequence problem = new LongestIncreasingSubsequence();
        int[] arr = {3,4,-1,0,6,2,3};
        System.out.println("The length of the longest increasing sequence is = "+problem.lengthOfLongestIncreasingSeq(arr,7));
        int arr2[] = {23,10,22,5,33,8,9,21,50,41,60,80,99, 22,23,24,25,26,27};
        System.out.println("The length of the longest increasing sequence is = "+problem.lengthOfLongestIncreasingSeq(arr2,arr2.length));

    }
}
