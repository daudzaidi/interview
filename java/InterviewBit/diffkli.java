package InterviewBit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shyamsunderpandita on 08/01/17.
 * Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

 Example :

 Input :

 A : [1 5 3]
 k : 2
 Output :

 1
 as 3 - 1 = 2

 Return 0 / 1 for this problem.
 */
public class diffkli {
    public int diffPossible(final List<Integer> a, int b) {
        if(a!=null && a.size() > 1) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < a.size() ; i++){
                map.put(a.get(i),i);
            }
            for (int i = 0; i < a.size() ; i++){
                int search = a.get(i) + b;

                    if(map.containsKey(search) && map.get(search) !=i){
                        return 1;
                    }

            }
        }
        return 0;
    }

    public  static void main(String... args){
        diffkli d = new diffkli();
        final List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(5);
        a.add(3);

        System.out.println(d.diffPossible(a,2));

        int[] ba = new int[]{11, 85, 100, 44, 3, 32, 96, 72, 93, 76, 67, 93, 63, 5, 10, 45, 99, 35, 13};
        ArrayList<Integer> barr = new ArrayList<>();
        for(int i = 0 ; i < ba.length ; i++){
            barr.add(ba[i]);
        }

        System.out.println(d.diffPossible(barr,60));
    }
}
