package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by shyamsunderpandita on 11/01/17.
 */
public class SubsetDuplicateElements {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {

        if(a!=null){
            Collections.sort(a);
            getSubsets(a,0,new ArrayList<Integer>());
            Collections.sort(result, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    int size1 = o1.size();
                    int size2 = o2.size();

                    for(int i = 0 ; i < Math.min(size1,size2) ; i++){
                        int cmp = Integer.compare(o1.get(i),o2.get(i));
                        if(cmp!=0)
                            return cmp;
                    }
                    return Integer.compare(size1,size2);
                }
            });
        }
        return result;
    }

    private void getSubsets(ArrayList<Integer> a, int i, ArrayList<Integer> temp) {
        if(i == a.size()){
            Collections.sort(temp);
            if(!result.contains(temp)){
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        if(i >= a.size()){
            return;
        }

        getSubsets(a,i+1,temp);
        temp.add(a.get(i));
        getSubsets(a,i+1,temp);
        temp.remove(temp.size()-1);
    }

    public static void main(String... args){
        SubsetDuplicateElements sum = new SubsetDuplicateElements();
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(2);
        System.out.println(sum.subsetsWithDup(a));


    }
}
