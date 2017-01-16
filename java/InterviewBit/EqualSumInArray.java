package InterviewBit;

import java.util.*;

/**
 * Created by shyamsunderpandita on 07/01/17.
 */
public class EqualSumInArray {
    public ArrayList<Integer> equal(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer,ArrayList<ArrayList<Integer>>> map = new HashMap<>();

        for(int i = 0 ; i < a.size()-1 ; i++){
            for(int j = i+1; j < a.size() ; j++){
                int sum = a.get(i) + a.get(j);
                if(map.containsKey(sum)){

                    ArrayList<ArrayList<Integer>> p = map.get(sum);

                    ArrayList<Integer> index = p.get(0);
                    if(index.get(0) < index.get(1) && index.get(0) < i && i < j && index.get(1)!=j && index.get(1)!=i){

                        ArrayList<Integer> array  = new ArrayList<>();
                        array.add(i);
                        array.add(j);
                        p.add(array);
                        map.put(sum,p);
                    }

                }
                else{
                    ArrayList<ArrayList<Integer>> p = new ArrayList<>();
                    ArrayList<Integer> array  = new ArrayList<>();
                    array.add(i);
                    array.add(j);
                    p.add(array);
                    map.put(sum,p);
                }
            }
        }
        if(map.size()>0) {
            int i1 = Integer.MAX_VALUE, i2 = Integer.MAX_VALUE, i3 = Integer.MAX_VALUE,i4 = Integer.MAX_VALUE;
            Iterator itr = map.entrySet().iterator();
            while (itr.hasNext()) {
                int ti1,ti2,ti3,ti4;
                Map.Entry obj = (Map.Entry) itr.next();
                ArrayList<ArrayList> e = (ArrayList<ArrayList>) obj.getValue();
                if (e.size() != 1) {
                    ti1 = (int) e.get(0).get(0);
                    ti2 = (int) e.get(0).get(1);
                    ti3 = (int) e.get(1).get(0);
                    ti4 = (int) e.get(1).get(1);

                    if(i1 > ti1 || (i1 == ti1 && i2 > ti2) || (i1 ==ti1 && i2 == ti2 && i3 > ti3) || (i1 == ti1 && i2 == ti2 && i3 == ti3 && i4 > ti4))
                    {
                        i1 = ti1;
                        i2 = ti2;
                        i3 = ti3;
                        i4 = ti4;
                    }
                }
            }

            result.add(i1);
            result.add(i2);
            result.add(i3);
            result.add(i4);
        }
        return result;
    }

    public static void main(String... args){
        EqualSumInArray e = new EqualSumInArray();

        final ArrayList<Integer> ar = new ArrayList<>();
        ar.add(3);
        ar.add(4);
        ar.add(7);
        ar.add(1);
        ar.add(2);
        ar.add(9);
        ar.add(8);

        System.out.println(e.equal(ar));

        final ArrayList<Integer> ar2 = new ArrayList<>();
        ar2.add(1);
        ar2.add(5);
        ar2.add(2);
        ar2.add(4);
        ar2.add(2);
        ar2.add(0);
        ar2.add(2);
        ar2.add(5);
        ar2.add(1);
        ar2.add(0);
        ar2.add(5);
        ar2.add(0);

        System.out.println(e.equal(ar2));

        int [] y = new int[]{9, 5, 4, 9, 3, 6, 8, 7, 1, 2, 8, 7, 2, 9, 7, 1, 3, 9, 7, 8, 1, 0, 5, 5};
        final ArrayList<Integer> ar3 = new ArrayList<>();

        for(int i = 0 ; i < y.length ; i++){
            ar3.add(y[i]);
        }

        System.out.println(e.equal(ar3));

        int [] y1 = new int[]{0, 0, 1, 0, 2, 1};
        final ArrayList<Integer> ar4 = new ArrayList<>();

        for(int i = 0 ; i < y1.length ; i++){
            ar4.add(y1[i]);
        }

        System.out.println(e.equal(ar4));
    }
}
