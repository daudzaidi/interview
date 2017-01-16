package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shyamsunderpandita on 05/01/17.
 */
public class RemoveDuplicateFromSortedArray {
    public int removeDuplicates(ArrayList<Integer> a) {

        int i = 0 ;
        int j = i+1;
        int size = a.size()-1;
        while(i < size){
            if( a.get(i).intValue() == a.get(j).intValue()){
                while (a.get(i).intValue() == a.get(j).intValue()){
                    a.remove(a.get(j));
                    size--;
                    if(i>=size){
                        break;
                    }
                }
            }
            else{
                i++;
                j++;
            }
        }

        return size+1;
    }

    public int removeDuplicatesEfficient(ArrayList<Integer> A) {
        int index = 1;
        int n = A.size();

        if (A == null || A.size() == 0)
            return 0;

        for (int i = 1; i < n; i++) {

            if (A.get(i).intValue() != A.get(i - 1).intValue()) {
                A.set(index, A.get(i));
                index++;
            }
        }

        return index;

    }

    public static void main(String... args){
        RemoveDuplicateFromSortedArray p = new RemoveDuplicateFromSortedArray();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1);
        a.add(2);
        a.add(2);
        a.add(3);
        a.add(3);
        a.add(3);
        a.add(6);
        a.add(6);

        System.out.println(p.removeDuplicatesEfficient(a));

        int[] b = new int[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < b.length ; i++){
            arr.add(b[i]);
        }

        System.out.println(p.removeDuplicatesEfficient(arr));
    }
}
