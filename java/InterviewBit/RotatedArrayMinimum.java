package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shyamsunderpandita on 02/12/16.
 */
public class RotatedArrayMinimum {
    public int findMin(final List<Integer> a) {

        if(a == null || a.size() == 0 ){
            return -1;
        }

        if(a.size() == 1){
            return a.get(0);
        }

        int i = 0 ;
        int length = a.size();

        while(i+1 < length && a.get(i) < a.get(i+1)){
            i++;
        }

        if(i+1 != length){
            return a.get(i+1);
        }

        return a.get(0);

    }

    public int findMinBinarySearch(final List<Integer> a) {

        if(a == null || a.size() == 0 ){
            return -1;
        }

        if(a.size() == 1){
            return a.get(0);
        }

        int start = 0 ;
        int end = a.size() - 1;

        if(a.get(start) <= a.get(end)){
            return a.get(start);
        }
        int breakpoint = 0;
        while(start <= end){
            int mid = start+((end-start)/2);
            if(mid-1 <0 || mid+1 >= a.size()){
                breakpoint = mid;
                break;
            }
            if(a.get(mid) < a.get(mid+1) && a.get(mid) < a.get(mid-1)){
                return a.get(mid);
            }
            if(a.get(end) < a.get(mid) && a.get(end) < a.get(mid)){
                start = mid+1;
            }
            else{
                end = mid-1;
            }

        }

       return a.get(breakpoint);

    }

    public static void main(String... args){
        RotatedArrayMinimum prob = new RotatedArrayMinimum();
        List<Integer> a = new ArrayList<>();
        //a.add(4);
        //a.add(5);
        //a.add(6);
        //a.add(7);
        //a.add(8);
        //a.add(0);
       // a.add(1);
        //a.add(2);
       // a.add(3);

        Integer[] arr = new Integer[]{40342, 40766, 41307, 42639, 42777, 46079, 47038, 47923, 48064, 48083, 49760, 49871, 51000, 51035, 53186, 53499, 53895, 59118, 60467, 60498, 60764, 65158, 65838, 65885, 65919, 66638, 66807, 66989, 67114, 68119, 68146, 68584, 69494, 70914, 72312, 72432, 74536, 77038, 77720, 78590, 78769, 78894, 80169, 81717, 81760, 82124, 82583, 82620, 82877, 83131, 84932, 85050, 85358, 89896, 90991, 91348, 91376, 92786, 93626, 93688, 94972, 95064, 96240, 96308, 96755, 97197, 97243, 98049, 98407, 98998, 99785, 350, 2563, 3075, 3161, 3519, 4176, 4371, 5885, 6054, 6495, 7218, 7734, 9235, 11899, 13070, 14002, 16258, 16309, 16461, 17338, 19141, 19526, 21256, 21507, 21945, 22753, 25029, 25524, 27311, 27609, 28217, 30854, 32721, 33184, 34190, 35040, 35753, 36144, 37342};

        for(int i = 0 ; i < arr.length ; i++){
            a.add(arr[i]);
        }
        System.out.println(prob.findMinBinarySearch(a));

        List<Integer> b = new ArrayList<>();
        b.add(4);
        b.add(5);
        b.add(6);
        b.add(7);
        b.add(8);
       // b.add(3);
       // b.add(2);
       // b.add(1);
       // b.add(0);


        System.out.println(prob.findMinBinarySearch(b));
    }
}
