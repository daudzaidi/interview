package InterviewBit;

/**
 * Created by shyamsunderpandita on 05/01/17.
 * x % p = (x + p) % p,
 */
public class PowerFunction {
    public int pow(int x, int n, int d) {
        long power = pow(x,n);

        if(power < 0){
            power = power+d;
        }
        long res = (power) % d;
        return (int)res;
    }


    public long pow(long x, long n){
        if(n == 0){
            return 1;
        }

        if(n == 1){
            return x;
        }

        long temp=pow(x,n/2);

        long isEven = (n % 2 == 0) ? 1 : 0; //1 means even and 0 means odd

        long mul = temp * temp;

        if(isEven == 1){
            return mul;
        }
        else{
            if(n > 0){
                return x* mul;
            }
            else{
                return mul/2;
            }
        }

    }

    public int pow2(int x, int n, int d) {

        long a = x % d;
        long res = 1L;

        while (n > 0) {

            if (n % 2 == 1) {
                res = (res*a) % d;
            }

            a = (a * a) % d;
            n = n >> 1;

        }

        res = (res + d) % d;

        return (int) res;

    }

    public static void main(String... args){
        PowerFunction f = new PowerFunction();
        //System.out.println(f.pow(2,3,3));
        //System.out.println(f.pow(-1,1,20));
        System.out.println(f.pow2(71045970,41535484,64735492));
    }
}
