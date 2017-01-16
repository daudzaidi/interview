package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shyamsunderpandita on 19/11/16.
 */
public class XorDuplicateArray {
    public static int repeatedNumber(final List<Integer> a) {

        int res = 0 ;
        int len = a.size();
        for(int i = 1 ; i <= len-1 ; i++){
            res = res ^ i;
        }

        int dup = 0;
        for(int i = 0 ; i<len ; i++ ){
            dup = dup ^ a.get(i);
        }


        return dup ^ res;
    }

    public static void main (String... args){
        List<Integer> l1 = new ArrayList<>();
        l1.add(3);
        l1.add(2);
        l1.add(1);
        l1.add(2);

        System.out.println(repeatedNumber(l1));
    }
}
