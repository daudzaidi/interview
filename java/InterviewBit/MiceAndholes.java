package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shyamsunderpandita on 14/01/17.
 */
public class MiceAndholes {
    public int mice(ArrayList<Integer> a, ArrayList<Integer> b) {

        Collections.sort(a);
        Collections.sort(b);

        int min = 0;
        if(a.size() == b.size()){
            for(int i = 0 ; i < a.size() ; i++){
                int m  = Math.abs(a.get(i) - b.get(i));
                min = Math.max(min,m);
            }
        }

        return min;
    }

    public static void main(String... args){
        MiceAndholes m = new MiceAndholes();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(-4);
        a.add(2);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(4);
        b.add(0);
        b.add(5);
        System.out.println(m.mice(a,b));
    }
}
