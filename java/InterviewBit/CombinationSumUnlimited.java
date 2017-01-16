package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by shyamsunderpandita on 11/01/17.
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The combinations themselves must be sorted in ascending order.
 CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
 The solution set must not contain duplicate combinations.
 Example,
 Given candidate set 2,3,6,7 and target 7,
 A solution set is:

 [2, 2, 3]
 [7]
 */
public class CombinationSumUnlimited {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {

        if(a!=null){
            Collections.sort(a);
            getCombinations(a,b,0,new ArrayList<Integer>());
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

    private void getCombinations(ArrayList<Integer> a, int b, int i, ArrayList<Integer> temp) {
        if(b == 0){
            if(!result.contains(temp)) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        if(b < 0 || i >= a.size()){
            return;
        }

        getCombinations(a,b,i+1,temp);

        int factor = (b/a.get(i));
        for(int k = 1 ; k <= factor ; k++){
            temp.add(a.get(i));
            getCombinations(a,b-(k*a.get(i)),i+1,temp);
            //temp.remove(temp.size()-1);
        }


        for(int k = 1 ; k <= factor ; k++){
            temp.remove(temp.size()-1);
        }

    }

    public static void main(String... args){
        CombinationSumUnlimited sum = new CombinationSumUnlimited();
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(3);
        a.add(6);
        a.add(7);
        System.out.println(sum.combinationSum(a,7));

        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(8);
        b.add(10);
        b.add(6);
        b.add(11);
        b.add(1);
        b.add(16);
        b.add(8);
        System.out.println(sum.combinationSum(b,28));
    }
}
