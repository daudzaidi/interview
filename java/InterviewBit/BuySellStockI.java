package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shyamsunderpandita on 15/01/17.
 */
public class BuySellStockI {
    public int maxProfit(final List<Integer> a) {
        int profit = 0 ;
        if(a!=null && a.size() > 0){

            int s = a.size();
            int min = a.get(0);

            for(int i = 1 ; i < s ; i++){
                profit = Math.max(profit,a.get(i)-min);
                min = Math.min(min,a.get(i));
            }

        }
        return profit;
    }

    public static void main(String... args){
        final List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        BuySellStockI b = new BuySellStockI();
        System.out.println(b.maxProfit(a));
    }
}
