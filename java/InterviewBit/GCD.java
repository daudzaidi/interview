package InterviewBit;

/**
 * Created by shyamsunderpandita on 18/11/16.
 */
public class GCD {
    public static int gcd(int a, int b) {

        if(a == 0 && b == 0){
            return 0;
        }

        if(a == 0){
            return b;
        }

        if(b == 0){
            return a;
        }

        int n1 = (a >=b ) ? a : b; //divident number
        int n2 = (a < b) ? a : b; //divisor number

        if(a == b){
            return a;
        }

        if(n1 % n2 == 0){
            return n2;
        }

        while(n1%n2 !=0){
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }

        return n2;
    }

    public static void main(String... args){
        System.out.println(gcd(0,74));
    }
}
