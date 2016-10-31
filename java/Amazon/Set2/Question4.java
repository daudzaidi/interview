package Amazon.Set2;

/**
 * Created by shalvi on 30/06/16.
 */
public class Question4 {

    public static void findTurningPoint(int[] arr){
        if(arr == null) return;
        int start =0 ;
        int end = arr.length-1;
        while(start < end){
            int mid = (start+end)/2;
            if(start == mid || end == mid){
                if (end == start+1) {
                    System.out.println("The turning point is = " + arr[mid]);
                    return;
                }
            }
            else if (arr[mid-1] < arr[mid])
                start = mid;
            else if (arr[mid-1] > arr[mid])
                end = mid;
        }

    }

    public static void main(String... args){
        findTurningPoint(new int[]{2,3,4,5,6,7,8,6,4,3,2});
    }
}
