package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shyamsunderpandita on 10/01/17.
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 Example :

 Given candidate set 10,1,2,7,6,1,5 and target 8,

 A solution set is:

 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6]
 */
public class CombinationSum {
    ArrayList<ArrayList<Integer>> res;

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {

        if (A == null)
            return null;

        res = new ArrayList<>();

        Collections.sort(A);

        rec(A, new ArrayList<>(), B, 0);

        return res;
    }

    public void rec(ArrayList<Integer> A, ArrayList<Integer> ans, int B, int index) {

        if (B == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }

        if (B < 0 || index >= A.size())
            return;

        int i = index + 1;
        for (; i < A.size(); i++)
            if (A.get(i) != A.get(i - 1))
                break;
        rec(A, ans, B, i);

        ans.add(A.get(index));
        rec(A, ans, B - A.get(index), index + 1);
        ans.remove(ans.size() - 1);



    }

    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> combinationSumMyVersion(ArrayList<Integer> a, int b) {
        if(a == null){
            return null;
        }
        Collections.sort(a);
        getCombinationsRec(a,b,0,new ArrayList<Integer>());
        return result;
    }

    public void getCombinationsRec(ArrayList<Integer> a, int target ,int index , ArrayList<Integer> temp){
        if(target == 0){
            result.add(new ArrayList<Integer>(temp));
            return;
        }

        if(target < 0 || index >= a.size()){
            return;
        }

        if(target > 0){
            int i = index + 1;
            for (; i < a.size(); i++)
                if (a.get(i) != a.get(i - 1))
                    break;

            getCombinationsRec(a,target,i,temp);
            temp.add(a.get(index));
            getCombinationsRec(a,target-a.get(index),index+1,temp);
            temp.remove(temp.size() - 1);

        }
    }

    public static void main(String... args){
        CombinationSum sum = new CombinationSum();
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(10);
        a.add(1);
        a.add(2);
        a.add(7);
        a.add(6);
        a.add(1);
        a.add(5);
        System.out.println(sum.combinationSumMyVersion(a,8));
    }
}
