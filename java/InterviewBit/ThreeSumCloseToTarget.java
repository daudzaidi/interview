package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shyamsunderpandita on 04/01/17.
 */
public class ThreeSumCloseToTarget {

    // Fixing integer starting from lowest and then finding other two

    int globalSum = 0;

    public int threeSumClosest(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        int size = a.size();
        if(size < 3){
            return 0;
        }
        globalSum = a.get(0)+a.get(1)+a.get(2);

        if(size == 3){
            return globalSum;
        }

        int low,mid,high;
        for(low = 0 ; low <= size-3 ; low++){
            mid = low+1;
            high = size-1;
            int sum = a.get(low) ;

            while(mid<high){
                int r = sum + a.get(mid) + a.get(high);
                if(r == b){
                    return b;
                }
                else if(r < b){
                    mid++;
                }
                else{
                    high--;
                }

                int diff1 = Math.abs(b-globalSum);
                int diff2 = Math.abs(b - r);
                globalSum = (diff1 > diff2) ? r : globalSum;
            }
        }
        return globalSum;
    }


    /*Driver function to check for above function*/
    public static void main (String[] args) {
        ThreeSumCloseToTarget sum = new ThreeSumCloseToTarget();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(-1);
        arr.add(2);
        arr.add(1);
        arr.add(-4);
        System.out.println(sum.threeSumClosest(arr,1));
    }
}
