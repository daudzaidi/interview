package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shyamsunderpandita on 16/01/17.
 */
public class BuySellStockII {

    public int maxProfit(final List<Integer> a) {
        if (a!=null && a.size() > 0){
            return maxProfit(a,0,0);
        }
        return 0;
    }

    private int maxProfit(final List<Integer> a, int maxIndex,int profit){
        if(maxIndex >= a.size()-1){
            return 0;
        }

        int min = a.get(maxIndex);
        int index = maxIndex;
        for(int i = index+1 ; i < a.size() ; i++){
            min = Math.min(min,a.get(i));
            int p  = a.get(i)-min;
            if(p > profit){
                maxIndex = i;
                profit = p;
            }
        }

        return profit + maxProfit(a,maxIndex+1,0);
    }

    public int maxProfitEFFICIENT(final List<Integer> a) {
        if (a!=null && a.size() > 0){

            int profit = 0 ;
            for(int i = 0 ; i < a.size()-1; i++){
                int diff = a.get(i+1)-a.get(i);
                if(diff>0){
                    profit+=diff;
                }
            }

            return profit;
        }
        return 0;
    }


    public static void main(String... args){
        final List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(3);
        a.add(5);
        a.add(4);
        a.add(5);
        BuySellStockII b = new BuySellStockII();
        System.out.println(b.maxProfitEFFICIENT(a));
    }
}
