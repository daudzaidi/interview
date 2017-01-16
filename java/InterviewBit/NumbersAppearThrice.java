package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shyamsunderpandita on 04/01/17.
 */
public class NumbersAppearThrice {
    public int singleNumber(final List<Integer> a) {
        int res = 0;
        int x,sum;
        int size = a.size();
        for(int i = 0 ; i < 32 ; i++){
            x = (1 << i);
            sum = 0;
            for(int j = 0 ; j < size ; j++){
                if((x & a.get(j)) != 0){
                    sum++;
                }
            }
            if(sum % 3 !=0){
                res = res | x;
            }
        }

        return res;
    }

    public static void main(String... args){
        NumbersAppearThrice problem = new NumbersAppearThrice();
        final List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);
        list.add(3);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(1);

        System.out.println(problem.singleNumber(list));
    }
}
