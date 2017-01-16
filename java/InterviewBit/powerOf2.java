package InterviewBit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

/**
 * Created by shyamsunderpandita on 26/11/16.
 */
public class powerOf2 {

    public static int power(String a) {

        String regex = "[0-9]*";

        if(a == null || a.isEmpty() || !a.matches(regex)){
            return 0;
        }

        if(a.length() == 1 && Character.getNumericValue(a.charAt(0)) ==2){
            return 1;
        }

        List<Integer> res = new ArrayList<>();

        int rem = 0;
        for(int i = 0; i < a.length() ; i++){
            int num = Character.getNumericValue(a.charAt(i));
            StringBuilder builder = new StringBuilder();

            if(rem !=0){
                builder.append(rem);
                builder.append(num);
            }
            else {
                builder.append(num);
            }
            String n = builder.toString();
            int finalInt = Integer.parseInt(n);
            int div = finalInt/2;
            rem = finalInt%2;
            if(i == 0 && div ==0){
                continue;
            }

                res.add(div);

        }

        while(rem == 0 && res.size() > 1){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0 ; j < res.size() ; j++){
                int num = res.get(j);
                StringBuilder builder = new StringBuilder();

                if(rem !=0){
                    builder.append(rem);
                    builder.append(num);
                }
                else {
                    builder.append(num);
                }
                String n = builder.toString();
                int finalInt = Integer.parseInt(n);
                int div = finalInt/2;
                rem = finalInt%2;
                if(j == 0 && div ==0){
                    continue;
                }

                    temp.add(div);

            }

            res = temp;
        }

        if(res.size()>0) {
            int num = res.get(0);
            if (res.size() == 1 && (num == 8 || num == 4 || num == 2)) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String... args){
        //System.out.print(power("1"));
        StringBuilder b = new StringBuilder();
        b.append("a");
        b.append("bc");
        b.append('v');
        System.out.print(b.length());
    }
}
