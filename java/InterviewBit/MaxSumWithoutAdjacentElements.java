package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 16/01/17.
 */
public class MaxSumWithoutAdjacentElements {



    //2 * N Grid

    public int adjacent(ArrayList<ArrayList<Integer>> a) {

        if(a!=null && a.size() == 2){
            int size = a.get(0).size();
            if(size == 0){
                return 0;
            }

            int[]dp = new int[size];
            dp[0] = Math.max(a.get(0).get(0),a.get(1).get(0));

            if(size == 1){
                return dp[0];
            }

            dp[1] = Math.max(a.get(0).get(1),a.get(1).get(1));
            dp[1] = Math.max(dp[0],dp[1]);

            for(int i = 2 ; i < size ; i++){
                dp[i] = Math.max(a.get(0).get(i),a.get(1).get(i));
                dp[i] = dp[i] +dp[i-2];
                dp[i] = Math.max(dp[i-1],dp[i]);
            }

            return dp[size-1];
        }
        return 0;
    }


    public static void main(String... args){
        MaxSumWithoutAdjacentElements m = new MaxSumWithoutAdjacentElements();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        ArrayList<Integer> row2 = new ArrayList<>();

        row1.add(1);
        row1.add(2);
        row1.add(3);
        row1.add(4);

        row2.add(2);
        row2.add(3);
        row2.add(4);
        row2.add(5);

        a.add(row1);
        a.add(row2);

        System.out.println(m.adjacent(a));
    }
}
