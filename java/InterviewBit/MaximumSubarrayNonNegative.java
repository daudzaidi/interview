package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 17/11/16.
 */
public class MaximumSubarrayNonNegative {

    public static ArrayList<Integer> maxset(ArrayList<Integer> a) {

        long maxSum = 0;
        long newSum = 0;
        ArrayList<Integer> maxArray = new ArrayList<Integer>();
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (Integer i : a) {
            if (i >= 0) {
                newSum += i;
                newArray.add(i);
            } else {
                newSum = 0;
                newArray = new ArrayList<Integer>();
            }
            if ((maxSum < newSum) || ((maxSum == newSum) && (newArray.size() > maxArray.size()))) {
                maxSum = newSum;
                maxArray = newArray;
            }
        }
        return maxArray;
    }

    public static ArrayList<Integer> maxset2(ArrayList<Integer> a) {

        if(a == null){
            return null;
        }

        int len = a.size();

        int maxSum = -1 ;
        int maxLength = -1 ;
        int minIndex = 0;

        for(int i = 0 ; i < len ; i++){
            if(a.get(i) < 0){
                continue;
            }

            int sum = 0 ;
            int l = 0;
            int k = i;
            while(i != len && a.get(i) >= 0){
                if(sum + a.get(i) < sum){
                    sum = Integer.MAX_VALUE;
                }
                else{
                    sum = sum + a.get(i);
                }
                l = l + 1;

                if(maxSum < sum || (maxSum == sum && maxLength < l)){
                    maxSum = sum;
                    maxLength = l;
                    minIndex = k;
                }
                i++;
            }
            i--;
        }


        ArrayList<Integer> output = new ArrayList<Integer>();

        for(int j = minIndex ; j < minIndex+maxLength ; j++){
            output.add(a.get(j));
        }

        return output;
    }
    public static void main(String... args){
        ArrayList<Integer> list = new ArrayList<>();
       // list.add(0);
        //list.add(0);
       // list.add(756898537);
        list.add(756898537);
        list.add(-2038664370);
        list.add(-184803526);
        list.add(1424268980);

        //list.add(0);
        //list.add(2);

        System.out.println(maxset(list));
        System.out.println(maxset2(list));
    }
}
