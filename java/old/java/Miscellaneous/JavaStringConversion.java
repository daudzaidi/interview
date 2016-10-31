package old.java.Miscellaneous;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pandita on 11/16/2015.
 */
public class JavaStringConversion {

    public static void main(String... args) throws ParseException {
        String a=1+2+3+3.7+"Hello"+4+5+6;
        System.out.println(a);

        String dateInString="November 29, 1991";
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy");
        Date date = dateFormat.parse(dateInString);

        System.out.println(date);
        System.out.println(dateInString.intern());

        jack();
        jill();
    }



    public static void jack() {
        String s1 = "hill5";
        String s2 = "hill" + "5";
        System.out.println(s1==s2);
    }
    public static void jill() {
        String s1 = "hill5";
        String s2 = "hill" + s1.length();
        System.out.println(s1==s2);
    }


}

 class Null{
    public static void g() {
        System.out.println("H");
    }
}