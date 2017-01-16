package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by shyamsunderpandita on 11/01/17.
 * Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

 Make sure the combinations are sorted.

 To elaborate,
 1. Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
 2. Entries should be sorted within themselves.

 Example :
 If n = 4 and k = 2, a solution is:

 [
 [1,2],
 [1,3],
 [1,4],
 [2,3],
 [2,4],
 [3,4],
 ]

 */
public class CombinationsKElements {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        public ArrayList<ArrayList<Integer>> combine(int n, int k) {
            if(k > 0 && n > 0   && n >=k){
                ArrayList<Integer> list = new ArrayList<>();

                for(int i = 1 ; i <= n ; i++){
                    list.add(i);
                }

                getCombinations(list,k,0,0,new ArrayList<Integer>());
                Collections.sort(result,new Comparator<ArrayList<Integer>>() {
                    @Override
                    public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                        int an = a.size();
                        int bn = b.size();
                        for (int i = 0; i < Math.min(an, bn); i++) {
                            int cmp = Integer.compare(a.get(i), b.get(i));
                            if (cmp != 0)
                                return cmp;
                        }
                        return Integer.compare(a.size(), b.size());
                    }
                });
            }
            return result;
    }

    private void getCombinations(ArrayList<Integer> a, int k, int index,int start, ArrayList<Integer> temp) {
        if(index == k){
            Collections.sort(temp);

            if(!result.contains(temp)){
                result.add(new ArrayList<>(temp));
                return;
            }
        }

        if(index > k || start >= a.size()){
            return;
        }

        temp.add(a.get(start));
        getCombinations(a,k,index+1,start+1,temp);
        temp.remove(temp.size()-1);
        getCombinations(a,k,index,start+1,temp);


    }

    public static void main(String... args){
        CombinationsKElements sum = new CombinationsKElements();

        System.out.println(sum.combine(4,2));
    }
}
