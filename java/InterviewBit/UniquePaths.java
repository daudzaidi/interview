package InterviewBit;

/**
 * Created by shyamsunderpandita on 18/11/16.
 */
public class UniquePaths {
    public static int uniquePaths(int a, int b) {
        if(a-1 == 0 || b-1 == 0){
            return 1;
        }

        return uniquePaths(a-1,b) + uniquePaths(a, b-1);
    }

    public static void main(String... args){
        System.out.println(uniquePaths(3,4));
    }
}
