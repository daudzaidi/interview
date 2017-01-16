package InterviewBit;

import java.util.*;

/**
 * Created by shyamsunderpandita on 08/01/17.
 */
public class FourSum {
    public ArrayList<ArrayList<Integer>> FourSum(ArrayList<Integer> A, int target) {
        Collections.sort(A);
        Integer[] num = new Integer[A.size()];
        num = A.toArray(num);
        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int k = j + 1;
                int l = num.length - 1;

                while (k < l) {
                    int sum = num[i] + num[j] + num[k] + num[l];

                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else if (sum == target) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[k]);
                        temp.add(num[l]);

                        if (!hashSet.contains(temp)) {
                            hashSet.add(temp);
                            result.add(temp);
                        }

                        k++;
                        l--;
                    }
                }
            }
        }

        return result;
    }

    public  static void main(String... args){
        FourSum d = new FourSum();
     ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(0);
        a.add(-1);
        a.add(0);
        a.add(-2);
        a.add(2);

        System.out.println(d.FourSum(a,0));

        int[] ba = new int[]{11, 85, 100, 44, 3, 32, 96, 72, 93, 76, 67, 93, 63, 5, 10, 45, 99, 35, 13};
        ArrayList<Integer> barr = new ArrayList<>();
        for(int i = 0 ; i < ba.length ; i++){
            barr.add(ba[i]);
        }

      //  System.out.println(d.FourSum(barr,60));
    }
}
