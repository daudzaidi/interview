package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shyamsunderpandita on 17/11/16.
 */
public class FindFirstMissingInteger {
    public static int firstMissingPositive(ArrayList<Integer> a) {
        if(a == null || a.size() == 0){
            return 1;
        }

        int len = a.size();

        Collections.sort(a);

        int k = 0 ;
        while(k < len){
            if (a.get(k) > 0){
                break;
            }
            k++;
        }

        if(k == len){
            return 1;
        }

        int c = 1;
        while( k < len){
            if(a.get(k)!=c){
                return c;
            }
            c++;
            k++;
        }

        return c;
    }

    public static void main(String... args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        // list.add(3);
        //list.add(2);

        System.out.println(firstMissingPositive(list));
    }
}
