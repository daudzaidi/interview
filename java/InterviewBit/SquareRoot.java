package InterviewBit;

/**
 * Created by shyamsunderpandita on 02/12/16.
 */
public class SquareRoot {
    public static int sqrt(int a) {

        if(a == 0){
            return 0;
        }

        if(a == 1 || a == 2 || a==3){
            return 1;
        }

        int i = 1;
        while(true) {
            double next = (i + 1) * (i + 1);
            if (a == next) {
                return i + 1;
            }

            if (a > next) {
                i++;
                continue;
            }

            double current = i * i;
            if ((a == current) || (a > current && a < next)) {
                return i;
            }

            i++;

        }

    }

    public static int sqrtBinaryApproach(int A){
        int low, high, root;
        int mid;


        low = 1;
        high = A;
        root = 0;

        while (low <= high) {

            mid = (low + high) / 2;

            if (mid == A / mid && (A % mid == 0))
                return mid;

            if (mid <= A / mid) {
                root = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return root;
    }

    public static void main(String... args){
        System.out.println(sqrt(2));
        System.out.println(sqrt(0));
        System.out.println(sqrt(1));
        System.out.println(sqrt(3));
        System.out.println(sqrt(4));
        System.out.println(sqrt(9));
        System.out.println(sqrt(11));
        System.out.println(sqrt(2000));
        System.out.println(sqrt(1000));
        System.out.println(sqrt(100));
        System.out.println(sqrt(530751374));
    }
}
