package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shyamsunderpandita on 05/01/17.
 */
public class SearchForARange {

    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        ArrayList<Integer> range = new ArrayList<Integer>();
        range.add(-1); //start
        range.add(-1); //end

        int start = 0;
        int end = a.size() - 1;

        while (start < end) {
            int middle = ((end - start) / 2)+1;
            //case 1 : element less than middle
            if (a.get(middle) > b) {
                end = middle - 1;
            }
            //case 2 : element more than middle
            else if (a.get(middle) < b) {
                start = middle + 1;
            }
            //case 3 : element equal to middle
            else {
                int firstOccurence = middle, lastOccurence = middle;
                while(a.get(firstOccurence) == b){
                    if(a.get(firstOccurence-1) == b) {
                        firstOccurence--;
                    }
                    else{
                        break;
                    }
                }

                while(a.get(lastOccurence) == b){
                    if(a.get(lastOccurence+1) ==b){
                        lastOccurence++;
                    }
                    else{
                        break;
                    }
                }

                range.set(0, firstOccurence);
                range.set(1, lastOccurence);

                break;
            }
        }

        return range;
    }

    public ArrayList<Integer> searchRange2(final List<Integer> a, int b) {
        ArrayList<Integer> range = new ArrayList<Integer>();
        range.add(-1); //start
        range.add(-1); //end

        int start = 0;
        int end = a.size() - 1;

        if(start == end && a.get(start) == b){
            range.set(0,0);
            range.set(1,0);
        }
        int firstoccurence = -1;

        // searching for first occurence
        while(start <= end){
            int middle = start  + ((end-start+1)/2);
            if(a.get(middle) < b){
                start = middle+1;
            }
            else if(a.get(middle) > b){
                end = middle-1;
            }
            else{
                end = middle-1;
                firstoccurence = middle;
            }
        }

        if(firstoccurence == -1)
            return range;


        int lastOccurence = -1;

        start = firstoccurence;
        end = a.size()-1;
        while(start <= end){
            int middle = start + ((end-start+1)/2);
            if(a.get(middle) < b){
                start = middle+1;
            }
            else if(a.get(middle) > b){
                end = middle-1;
            }
            else {
                start = middle + 1;
                lastOccurence = middle;
            }
        }
        range.set(0,firstoccurence);
        range.set(1,lastOccurence);

        return range;
    }
    public static void main(String... args){
        SearchForARange search = new SearchForARange();
        final List<Integer> a = new ArrayList<>();
        a.add(5);
        a.add(7);
        a.add(7);
        a.add(8);
        a.add(8);
        a.add(10);
        System.out.println(search.searchRange2(a,8));
    }
}
