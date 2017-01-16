package InterviewBit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shyamsunderpandita on 07/01/17.
 */
public class FractionInString {
    public String fractionToDecimal(int n, int de) {
        if(n == 0)
            return "0";
        if(de == 0)
            return "";
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        String tempResult = "";
        String result = "";
        if ((n < 0) && (de > 0) || (n > 0) && (de < 0)) {
            result += "-";
        }
        long numerator = n;
        long denominator = de;
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        System.out.println("numerator : " + numerator);
        System.out.println("denominator : " + denominator);
        long res = numerator/denominator;
        result += String.valueOf(res);

        long remainder = (numerator % denominator) * 10;
        System.out.println("remainder after calculating before . part: " + remainder);
        if(remainder == 0)
            return result;

        result += '.';

        while(remainder != 0){
            System.out.println("remainder : " + remainder);
            if(map.containsKey(remainder)){
                int beg = map.get(remainder);
                String part1 = result.substring(0, beg);
                String part2 = result.substring(beg, result.length());
                result = part1 + "(" + part2 + ")";
                return result;
            }
            map.put(remainder, result.length());
            res = remainder/denominator;
            result += String.valueOf(res);
            remainder = (remainder % denominator) * 10;
        }



        return result;
    }

    public String fractionToDecimalEfficient(int numerator, int denominator) {
        long a=numerator, b=denominator;

        if(a%b==0) return String.valueOf(a/b);

        Map<Long,Integer> map=new HashMap<>();

        StringBuilder res=new StringBuilder();

        if((a>0&&b<0)||(a<0&&b>0)) res.append("-");

        a=Math.abs(a);

        b=Math.abs(b);

        res.append(a/b+".");

        a=(a%b)*10;

        while(!map.containsKey(a)){
            map.put(a,res.length());
            res.append(String.valueOf(a/b));
            a=(a%b)*10;
            if(a==0) return res.toString();
        }

        return res.insert(map.get(a),"(").append(")").toString();
    }

    public static void main(String... args){
        FractionInString f = new FractionInString();
        System.out.println(f.fractionToDecimal(22,7));
        System.out.println(f.fractionToDecimal(3,7));
        System.out.println(f.fractionToDecimal(1,25));
        System.out.println(f.fractionToDecimal(1,2));
        System.out.println(f.fractionToDecimal(10,5));
        System.out.println(f.fractionToDecimal(7,7));
        System.out.println(f.fractionToDecimal(1,3));
    }
}
