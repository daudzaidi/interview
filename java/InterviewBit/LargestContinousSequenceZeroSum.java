package InterviewBit;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by shyamsunderpandita on 08/01/17.
 */
public class LargestContinousSequenceZeroSum {
    public ArrayList<Integer> lszero(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<>();
        if(a!=null){
            int size = a.size();
            int startIndex = 0;
            int endIndex = 0;
            boolean sumZero = false;
            for(int i = 0 ; i < size ; i++){
                int start = i ;
                int end = i;
                int sum = a.get(i);
                if(sum == 0){
                    sumZero = true;
                    if(endIndex - startIndex <= 0) {
                        startIndex = i;
                        endIndex = i;
                    }
                }
                for(int j = i+1 ; j < size ; j++){
                    sum = sum + a.get(j);

                    if(sum == 0){
                        sumZero = true;
                        if(end-start < j-start){
                            end = j;
                        }
                        if(endIndex - startIndex < end-start){
                            endIndex = end;
                            startIndex = start;
                        }
                    }

                }
            }

            if(sumZero == true) {
                for (int k = startIndex; k <= endIndex; k++) {
                    result.add(a.get(k));
                }
            }
        }

        return result;
    }

    public ArrayList<Integer> lszeroHM(ArrayList<Integer> A) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if(A == null) return rst;
        int len = 0;
        int sum = 0;
        int l = -1, r = -1;
        map.put(0, -1);
        for(int i = 0; i < A.size(); i++){
            sum += A.get(i);
            if(!map.containsKey(sum))
                map.put(sum, i);
            else{
                if(i - map.get(sum) > len){
                    l = map.get(sum) + 1;
                    r = i;
                    len = i - map.get(sum);
                }
            }
        }
        if(l >=0 && r >= 0){
            for(int i = l; i <= r; i++){
                rst.add(A.get(i));
            }
        }
        return rst;
    }
    public static void main(String... args){
        LargestContinousSequenceZeroSum problem = new LargestContinousSequenceZeroSum();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(-2);
        a.add(4);
        a.add(-4);
        System.out.println(problem.lszeroHM(a));

        ArrayList<Integer> b = new ArrayList<>();
        b.add(0);
        b.add(1);
        b.add(-1);
        System.out.println(problem.lszeroHM(b));

        ArrayList<Integer> c = new ArrayList<>();
        c.add(-19);
        c.add(8);
        c.add(2);
        c.add(-8);
        c.add(19);
        c.add(5);
        c.add(-2);
        c.add(-23);

        System.out.println(problem.lszeroHM(c));

        ArrayList<Integer> d = new ArrayList<>();
        d.add(0);
        d.add(-2);
        d.add(2);
        d.add(0);
        System.out.println(problem.lszeroHM(d));
    }

}
