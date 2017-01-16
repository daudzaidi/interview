package InterviewBit;

/**
 * Created by shyamsunderpandita on 25/11/16.
 */
public class LengthOflastWord {
    public static int lengthOfLastWord(final String a) {


        if(a.length() == 0){
            return 0;
        }
        String[] array = a.split(" ");

        if(array.length == 0){
            return 0;
        }
        int c = 0;
        while(c < array.length-1){
            c++;
        }

        return array[c].length();
    }

    public static void main(String... args){
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   "));
    }
}
