package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 05/01/17.
 */
public class DifferentBitsPairwiseSum {
    public int cntBits(ArrayList<Integer> A) {
        int sum = 0;
            if(A!=null){
            int size = A.size();
            int [][] memo = new int[size][size];
            for(int i = 0 ; i < size ; i++){
                for(int j = 0 ; j < size ; j++){
                    if(A.get(i) == A.get(j)){
                        sum = sum+0;
                    }
                    else if(memo[i][j] != 0) {
                        sum = sum + memo[i][j];
                    }
                    else{
                        memo[i][j] = getDiffBits(A.get(i), A.get(j));
                        sum = sum+memo[i][j];
                    }
                }
            }
        }
        return sum % ((int)Math.pow(10,9)+7);
    }

    public int getDiffBits(int A , int B){
        int cnt = 0;
        for(int i = 0 ; i<32 ; i++ ){
            if(((1 << i & A ) ^ (1 << i & B)) !=0){
                cnt++;
            }
        }
        return cnt;
    }

    public int cntBitsEfficient(ArrayList<Integer> A) {
        int ans = 0;  // Initialize result
        if(A!=null){
            int n = A.size();
            // traverse over all bits
            for (int i = 0; i < 32; i++)
            {
                // count number of elements with i'th bit set
                int count = 0;
                for (int j = 0; j < n; j++)
                    if ( (A.get(j) & (1 << i)) != 0)
                        count++;

                // Add "count * (n - count) * 2" to the answer
                ans += (count * (n - count) * 2);
            }
        }
        return ans % ((int)Math.pow(10,9)+7);
    }

    public static void main(String... args){
        DifferentBitsPairwiseSum problem = new DifferentBitsPairwiseSum();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        System.out.println(problem.cntBits(list));

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1);
        list1.add(1);
        System.out.println(problem.cntBits(list1));
    }
}
