package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shyamsunderpandita on 15/01/17.
 */
public class MaxProductSubarrayContigous {

    public int maxProduct(final List<Integer> a) {
        int[] max = new int[a.size()]; int[] min = new int[a.size()];
        int result = 0;
        if(a!=null && a.size() > 0){
            max[0] = a.get(0);
            min[0] = a.get(0);
            result = a.get(0);
            for(int i = 1 ; i < a.size() ; i++){
                if(a.get(i) > 0){
                    max[i] = Math.max(a.get(i),max[i-1]*a.get(i));
                    min[i] = Math.min(a.get(i),min[i-1]*a.get(i));
                }
                else{
                    max[i] = Math.max(a.get(i),min[i-1]*a.get(i));
                    min[i] = Math.min(a.get(i),max[i-1]*a.get(i));
                }

                result = Math.max(result,max[i]);
            }
        }
        return result;
    }

    public static void main(String... args){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(-2);
        list.add(4);
        MaxProductSubarrayContigous m = new MaxProductSubarrayContigous();
        System.out.println(m.maxProduct(list));

    }
}
