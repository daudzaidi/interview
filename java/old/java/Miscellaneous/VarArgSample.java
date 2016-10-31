package old.java.Miscellaneous;

/**
 * Created by pandita on 11/15/2015.
 */
public class VarArgSample {

    static int sum(int i, int... marks) {
        int total = 0;
        for (int mark : marks) {
            total = total + mark;
        }
        return total;
    }

    public static void main(String... args) {

        //invoking with variable arguments
        System.out.println(sum(1, 2, 3,4,5,6,7,8,9,10,1));

        //same invocation using an array
        int arr[] = {2,3};
        System.out.println(sum(1, arr));
    }
}