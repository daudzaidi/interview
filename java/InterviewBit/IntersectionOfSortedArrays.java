package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shyamsunderpandita on 05/01/17.
 */
public class IntersectionOfSortedArrays {
    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {

        ArrayList<Integer> result = new ArrayList<>();

        int i = 0 ; int j = 0;
        int sizeA = a.size();
        int sizeB = b.size();

        while(i!=sizeA && j!=sizeB){
            if(a.get(i).intValue() == b.get(j).intValue()){
                result.add(a.get(i));
                i++; j++;
            }
            else if(a.get(i).intValue() < b.get(j).intValue()){
                i++;
            }
            else{
                j++;
            }
        }
        return result;
    }

    public static void main(String... args){
        IntersectionOfSortedArrays p = new IntersectionOfSortedArrays();
        final List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        final List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(5);
      //  System.out.println(p.intersect(a,b));

        final List<Integer> a1 = new ArrayList<>();
        a1.add(1000);

        final List<Integer> b1 = new ArrayList<>();
        b1.add(1000);

        System.out.println(p.intersect(a1,b1));
    }
}
