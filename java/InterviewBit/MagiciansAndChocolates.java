package InterviewBit;

import java.util.*;

/**
 * Created by shyamsunderpandita on 13/01/17.
 */
public class MagiciansAndChocolates {
    public int nchoc(int A, ArrayList<Integer> B) {
        double res = 0 ;

        PriorityQueue<Integer> queue = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int N = B.size();
        if(N >=1){
            for(int i = 0 ; i < N ; i++){
                queue.add(B.get(i));
            }

            int count = 0;
            while(!queue.isEmpty() && count < A){
                int deq = queue.poll();
                res = res + deq;
                deq = (int) Math.floor(deq/2);
                queue.add(deq);
                count++;
            }

        }
        double mod = Math.pow(10,9);
        mod = mod+7;

        res = res % mod;
        return (int)res;
    }

    public static void main(String... args){
        MagiciansAndChocolates m = new MagiciansAndChocolates();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(6);
        A.add(5);
        System.out.println(m.nchoc(3,A));
    }
}
