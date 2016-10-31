package CrackingTheCodingInterview.ArraysAndStrings.Question1;

/**
 * Created by shalvi on 24/04/16.
 */
public class UniqueCharactersInString {

    public  static boolean isUniqueChars(String str){
        int checker = 0;
        for(int i =0;i<str.length();i++){
            int val = str.charAt(i) -'a';
            int chk = 1 << val;
            if((checker & chk) >0){
                System.out.println("The String "+str+" does not have unique characters");
                return false;
            }
            checker|= chk;
        }

        System.out.println("The String "+str+" has unique characters");
        return true;
    }


    public static void main(String... args){
        UniqueCharactersInString.isUniqueChars("shaa");
       // UniqueCharactersInString.isUniqueChars("shalvi");
    }
}
