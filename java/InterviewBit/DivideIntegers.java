package InterviewBit;

/**
 * Created by shyamsunderpandita on 04/01/17.
 */
public class DivideIntegers {

    /**
     *NAIVE Solution :
     * Div(10,2) = 10-2-2-2-2-2 = 0
     * Keep on subtracting (dividend-divisor) until the remainder is less than divisor
     * Performance slow
     *
     *OPTIMIZED SOLUTION :
     * Division can also be performed below way :
     *
     * 5/2 = Floor [ e ^ (ln(5) - ln(2) ]
     *
     * because e ^ (ln(5) - ln(2)) = e^(ln(5)) / e^(ln(2)) = 5/2
     * since x ^ (log y base x) = y
     *
     **/

    public int divide(int dividend, int divisor) {

        if (divisor == 0)
            return Integer.MAX_VALUE;

        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        if (dividend == divisor)
            return 1;

        if (divisor == 1)
            return dividend;

        if (divisor == -1)
            return -dividend;

        if (divisor == 2)
            return (dividend >> 1);

        int res = (int) res(dividend, divisor);

        return res;
    }

    private long res(long dividend, long divisor) {
        boolean sign = false;

        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            sign = true;


        dividend = Math.abs(dividend);

        divisor = Math.abs(divisor);

        double t1 = Math.log(dividend);
        double t2 = Math.log(divisor);
        double t3 =t1-t2;
        double t4 = Math.exp(t3);
        double t5 = Math.floor(t4);
        int result = (int) Math.floor(Math.exp(Math.log(dividend) - Math.log(divisor)));

        return sign ? -result : result;
    }

    public static void main(String... args){
        DivideIntegers division = new DivideIntegers();
        System.out.println(division.divide(5,2));
        System.out.println(division.divide(10,3));
        System.out.println(division.divide(5,20));
        System.out.println(division.divide(5,5));
        System.out.println(division.divide(5,1));
        System.out.println(division.divide(5,0));
        System.out.println(division.divide(Integer.MIN_VALUE,-1));
        System.out.println(division.divide(Integer.MAX_VALUE,2));
        System.out.println(division.divide(Integer.MAX_VALUE,19));
        System.out.println(division.divide(Integer.MIN_VALUE,2));
        System.out.println(division.divide(Integer.MIN_VALUE,-2));
    }
}
