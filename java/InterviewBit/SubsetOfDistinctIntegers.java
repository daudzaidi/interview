package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by shyamsunderpandita on 10/01/17.
 */
public class SubsetOfDistinctIntegers {

    ArrayList<ArrayList<Integer>> res;
    ArrayList<Integer> A;
    int N;
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<Integer> temp;
        res = new ArrayList<>();
        temp = new ArrayList<>();
        this.A = A;
        N = A.size();
        Collections.sort(A);

        subset(0, temp);

        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
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

        return res;

    }

    private void subset(int index, ArrayList<Integer> arr) {

        if (index == N) {
            res.add(new ArrayList<>(arr));
            System.out.println("New State : "+res);
            return;
        }

        subset(index + 1, arr);
        arr.add(A.get(index));
        System.out.println("Adding "+A.get(index));
        subset(index + 1, arr);
        arr.remove(arr.size() - 1);
        System.out.println("Removing "+A.get(index));

    }

    public static ArrayList<ArrayList<Integer>> subsets2(ArrayList<Integer> a) {
        if(a == null)
            return null;
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < a.size(); i++){
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

            for(ArrayList<Integer> list : result){
                temp.add(new ArrayList<Integer>(list));
            }
//            System.out.println(" temp has: " );
//            for(ArrayList<Integer> list : temp)
//                System.out.println("\t" + list);

            for(ArrayList<Integer> list : temp){
                list.add(a.get(i));
            }
            ArrayList<Integer> single = new ArrayList<Integer>();
            single.add(a.get(i));
            temp.add(single);


            result.addAll(temp);
        }
        result.add(0, new ArrayList<Integer>());
        //Collections.sort(result);
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
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

        return result;
    }

    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
       /* ArrayList<ArrayList<Integer>> result = subsets2(a);
        for(ArrayList<Integer> list : result)
            System.out.println(list);
*/
        SubsetOfDistinctIntegers s = new SubsetOfDistinctIntegers();
        System.out.println(s.subsets(a));
    }
}
