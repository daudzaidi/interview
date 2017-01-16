package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shyamsunderpandita on 14/01/17.
 */
public class CandyDistribution {
    public int candy(ArrayList<Integer> ratings) {
        int res = 0;

        if(ratings.size() > 0) {
            ArrayList<Integer> count = new ArrayList<>();
            count.add(1);
            for (int i = 1; i < ratings.size(); i++) {
                if(ratings.get(i) > ratings.get(i-1)){
                   count.add(count.get(i-1)+1);
                }
                else{
                    count.add(1);
                }
            }

            for(int i = 0 ; i < count.size() ; i++){
                res = res + count.get(i);
            }
        }
        return res;
    }

    public int candyeff(ArrayList<Integer> ratings) {
        if(ratings == null || ratings.size() == 0)
            return 0;

        // System.out.println(ratings);
        int[] candies = new int[ratings.size()];
        candies[0] =  1;

        for(int i = 1; i < ratings.size(); i++){
            if(ratings.get(i) > ratings.get(i - 1))
                candies[i] = candies[i-1] + 1;
            else{
                candies[i] = 1;
            }
        }

        int result = candies[ratings.size() - 1];
        // System.out.println("Result : " + result);
        for(int i = ratings.size()-2; i >= 0; i--){
            int cur = 1;
            if(ratings.get(i) > ratings.get(i + 1))
                cur = candies[i+1] + 1;
            result += Math.max(cur, candies[i]);
            candies[i] = cur;
        }


        return result;
    }

    public static void main(String... args){
        CandyDistribution c = new CandyDistribution();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(2);
        System.out.println(c.candy(a));

        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        b.add(3);
        b.add(4);
        b.add(5);
        System.out.println(c.candy(b));
    }
}
