package old.java.Miscellaneous;

/**
 * Created by pandita on 1/5/2016.
 */
public class DetermineUpperCase {

    public boolean isStringStartUpperCase(String str){
        if(str==null)
            return false;

        char start = str.charAt(0);
        int startNum = (int)start;
        if(startNum>=65 && startNum<=90)
            return true;

        return false;
    }

    public static void main(String... args){
        DetermineUpperCase det= new DetermineUpperCase();
        System.out.println(det.isStringStartUpperCase("Shalvi"));
        System.out.println(det.isStringStartUpperCase("shalvi"));
    }
}
