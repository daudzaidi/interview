package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by shyamsunderpandita on 16/11/16.
 */
public class LargestNumberFromArray {
    public static String largestNumber(final List<Integer> a) {

        if(a == null || a.size() == 0){
            return null;
        }

        int len = a.size();
        if(len == 1){
            String res = a.get(0)+"";
            return res;
        }



        Collections.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                StringBuilder b = new StringBuilder();
                b.append(o1);
                b.append(o2);

                StringBuilder b2 = new StringBuilder();
                b2.append(o2);
                b2.append(o1);

                return b2.toString().compareTo(b.toString());
            }
        });
        StringBuilder res = new StringBuilder();
        int k = 0;
        while(k <a.size() - 1){
            if(a.get(k) != 0)
                break;

            k++;
        }

        while(k < a.size()){
            res.append(a.get(k));
            k++;
        }
        return res.toString();
    }
    public static void main(String... args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
       // list.add(3);
        //list.add(2);

        System.out.println(largestNumber(list));
    }
}
