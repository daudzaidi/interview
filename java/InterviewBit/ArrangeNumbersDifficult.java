package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shyamsunderpandita on 18/11/16.
 */
public class ArrangeNumbersDifficult {
    public static void arrange(ArrayList<Integer> a) {
        int len = a.size();
        for(int i = 0 ; i < len ; i++){
            int res = a.get(i)+((a.get(a.get(i))%len)*len);
            a.set(i,res);
        }

        for(int i = 0 ; i < len ; i++){
            a.set(i,a.get(i)/len);
        }
    }

    public static void main(String... args){
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(3);
        l1.add(2);
        l1.add(0);
        l1.add(1);

        arrange(l1);
        System.out.println(l1);
    }
}
