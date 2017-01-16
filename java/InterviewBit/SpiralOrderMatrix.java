package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shyamsunderpandita on 11/11/16.
 */
public class SpiralOrderMatrix {

    static public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // Populate result;


        if(a == null || a.size() == 0) return result;

        int m = a.size();
        int n = a.get(0).size();

        int x=0;
        int y=0;

        while(m>0 && n>0){

            //if one row/column left, no circle can be formed
            if(m==1){
                for(int i=0; i<n; i++){
                    result.add(a.get(x).get(y++));
                }
                break;
            }else if(n==1){
                for(int i=0; i<m; i++){
                    result.add(a.get(x++).get(y));
                }
                break;
            }

            //below, process a circle

            //top - move right
            for(int i=0;i<n-1;i++){
                result.add(a.get(x).get(y++));
            }

            //right - move down
            for(int i=0;i<m-1;i++){
                result.add(a.get(x++).get(y));
            }

            //bottom - move left
            for(int i=0;i<n-1;i++){
                result.add(a.get(x).get(y--));
            }

            //left - move up
            for(int i=0;i<m-1;i++){
                result.add(a.get(x--).get(y));
            }

            x++;
            y++;
            m=m-2;
            n=n-2;
        }
        return result;
    }

    public static void main(String... args){
        List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        ArrayList<Integer> l3 = new ArrayList<>();
        l1.add(1);
        l2.add(2);
        l3.add(3);
        //l2.add(4);
        //l3.add(5);
        //l3.add(6);
        //l3.add(7);
        //l3.add(8);
        //l3.add(9);

        list.add(l1);
        list.add(l2);
        list.add(l3);

        ArrayList<Integer> result = spiralOrder(list);
        System.out.print(result);
    }
}
