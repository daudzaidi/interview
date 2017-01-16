package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by shyamsunderpandita on 15/01/17.
 */
public class CoinChangeProblem {
    public int coinchange2(ArrayList<Integer> coins, int money) {
        if(!validateData(coins,money)){
            return 0;
        }
        long[] table = new long[money+1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<coins.size(); i++)
            for (int j=coins.get(i); j<=money; j++)
                table[j] += table[j-coins.get(i)];

        return (int)(table[money] % 1000007);
    }

    private static boolean validateData(ArrayList<Integer> arr, int total) {
        if(arr == null)
            return false;
        if(total < 0 || total > Integer.MAX_VALUE)
            return false;
        for(int i = 0 ;i < arr.size() ; i++){
            if(arr.get(i) < 0)
                return false;
        }
        return true;
    }



    public static void main(String... args){
        CoinChangeProblem c = new CoinChangeProblem();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(5);
        a.add(3);
        a.add(6);

        System.out.println(c.coinchange2(a,10));
    }
}
