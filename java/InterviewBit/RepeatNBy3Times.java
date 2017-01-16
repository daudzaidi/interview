package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shyamsunderpandita on 21/11/16.
 */
public class RepeatNBy3Times {
    public static int repeatedNumber(final List<Integer> a) {

        int len = a.size();
        if(len == 1){
            return a.get(0).intValue();
        }
        int n = len/3;

        Collections.sort(a);

        for(int i = 0 ; i<len-1 ; i++){

            if(a.get(i).intValue() != a.get(i+1).intValue()){
                continue;
            }
            else{
                int count = 1;
                while(i < len-1 && (a.get(i).intValue() == a.get(i+1).intValue())){
                    count++;
                    i++;
                }

                if(count > n){
                    return a.get(i-1);
                }
            }
        }

        return -1;
    }

    public static void main (String... args){
        List<Integer> l1 = new ArrayList<>();
        l1.add(1000441);
/*        l1.add(1000441);
        l1.add(1000994);*/


        System.out.println(repeatedNumber(l1));
    }
}
