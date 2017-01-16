package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shyamsunderpandita on 14/01/17.
 */
public class MajorityElement {
    public int majorityElement(final List<Integer> a) {
        int res = 0;
        int size = a.size();
        if(size > 0 ){
            int majority = (int)Math.floor(size/2);
            Collections.sort(a);
            int count = majority;

            res = 0;

            for(int i = 0 ; i < size ; i++){
                int k = a.get(i);
                int c = 0;
                while(i+1 < size && k == a.get(i+1)){
                    c++;
                    i++;
                }

                if(c >= count){
                    count = c;
                    res = k;
                }
            }
        }
        return res;
    }

    public static void main(String... args){
        final List<Integer> a = new ArrayList<>();

        a.add(2);
        a.add(1);
        a.add(2);
        MajorityElement e = new MajorityElement();
        System.out.println(e.majorityElement(a));
    }
}
