package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shyamsunderpandita on 01/12/16.
 */
public class FindCountBinarySearch {
    public int findCount(final List<Integer> a, int b) {
        if(a == null || a.size() == 0){
            return b;
        }

        int low = 0 ;
        int high = a.size()-1;
        int count =0;
        int mid ;

        while(low <= high){
            mid = (low+high)/2;
            if(b == a.get(mid)){
                count++;
                count = count + searchNumber(a,low,mid-1,b);
                count = count + searchNumber(a,mid+1,high,b);

                return count;

            }
            else if (b < a.get(mid)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return 0;
    }

    public int searchNumber(final List<Integer> a, int low, int high, int b){

        int mid ;

        while(low <= high){
            mid = (low+high)/2;
            if(b == a.get(mid)){
                int count = 1 + searchNumber(a,low,mid-1,b);
                count = count+searchNumber(a,mid+1,high,b);
                return count;

            }
            else if (b < a.get(mid)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return 0;
    }

    public static void main(String... args){
        FindCountBinarySearch prob = new FindCountBinarySearch();
        final List<Integer> a = new ArrayList<>();
        a.add(5);
        a.add(7);
        a.add(7);
        a.add(8);
        a.add(8);
        a.add(10);
        System.out.println(prob.findCount(a,8));
    }
}
