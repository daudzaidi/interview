package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by shyamsunderpandita on 16/11/16.
 */
public class WaveNumber {
    public static ArrayList<Integer> wave(ArrayList<Integer> a) {

        Collections.sort(a);

        for(int i = 0 ; i< a.size() ; i++){
            if(i+1 < a.size()){
                int temp = a.get(i);
                a.set(i,a.get(i+1));
                a.set(i+1,temp);
                i++;
            }

        }

        return a;
    }

    public static void main(String... args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(3);
        list.add(2);
       // list.add(4);

        list = wave(list);
        for(Integer i : list)
            System.out.println(i);

    }
}
