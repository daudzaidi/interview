package InterviewBit;

/**
 * Created by shyamsunderpandita on 04/01/17.
 */
public class NumberOf1Bits {
    public int numSetBits(long a) {
        int count = 0 ;

        for(int i = 0 ; i < 32 ; i++ ){

            if(((1 << i) & a )!=0){
                count++;
            }
        }
        return count;
    }

    public static void main(String... args){
        NumberOf1Bits n = new NumberOf1Bits();
        System.out.println(n.numSetBits(11));
    }
}
