package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by shyamsunderpandita on 14/01/17.
 */
public class Highestproduct {
    public int maxp3(ArrayList<Integer> a) {
        int res = 0;
        int max = 0;
        if(a.size() >= 3){
            Collections.sort(a, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });

            res = a.get(0) * a.get(1) * a.get(2);
            max = res;

            res = a.get(a.size()-1) * a.get(a.size()-2)*a.get(0);
            max = Math.max(max,res);

        }

        return max;
    }

    public static void main(String... args){
        Highestproduct h = new Highestproduct();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(-1);
        a.add(3);
        a.add(100);
        a.add(-70);
        a.add(-50);
        System.out.println(h.maxp3(a));
    }
}
