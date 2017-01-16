package InterviewBit;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by shyamsunderpandita on 13/01/17.
 */
public class DistinctNumbersInWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        if(A == null){
            return result;
        }
        int N = A.size();
        if(B > N){
            return result;
        }

        for(int i = 0 ; i < N - B + 1 ; i++){
            int distinct = B;
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j = 0 ; j < B; j++){
                int key = A.get(i+j);
                if(map.containsKey(key)){
                    distinct --;
                }
                else{
                    map.put(key,1);
                }
            }

            result.add(distinct);
        }
        return result;
    }


    public ArrayList<Integer> dNumsEfficient(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        if(A == null){
            return result;
        }
        int N = A.size();
        if(B > N){
            return result;
        }

        int distinct = 0 ;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < B ; i++){
            int key = A.get(i);
            if(map.containsKey(key)){
                map.put(key, map.get(key)+1);
            }
            else{
                distinct++;
                map.put(key,1);
            }
        }

        result.add(distinct);

        for(int i = B ; i < N ; i++){

            // Remove first element of previous window
            // If there was only one occurrence, then
            // reduce distinct count.
            if(map.get(A.get(i-B))== 1){
                map.remove(A.get(i-B));
                distinct--;
            }
            else{
                map.put(A.get(i-B),map.get(A.get(i-B))-1);
            }

            if(map.containsKey(A.get(i))){
                map.put(A.get(i),map.get(A.get(i))+1);
            }
            else{
                distinct++;
                map.put(A.get(i),1);
            }

            result.add(distinct);
        }



        return result;
    }


    public static void main(String... args){
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(1);
        A.add(3);
        A.add(4);
        A.add(3);
        DistinctNumbersInWindow  d = new DistinctNumbersInWindow();
        System.out.println(d.dNumsEfficient(A,3));
    }
}
