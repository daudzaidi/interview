package old.java.Miscellaneous;

/**
 * Created by pandita on 11/15/2015.
 */
public class JavaIntegerCache {
    public static void main(String... strings) {

        //Range -127 to +127

        Integer integer1 = new Integer(3);
        Integer integer2 = new Integer(3);

        if (integer1 == integer2)
            System.out.println("integer1 == integer2");
        else
            System.out.println("integer1 != integer2");

        Integer integer3 = 126;
        Integer integer4 = 126;

        if (integer3 == integer4)
            System.out.println("integer3 == integer4");
        else
            System.out.println("integer3 != integer4");

        integer3++;

        if (integer3 == integer4)
            System.out.println("integer3 == integer4");
        else
            System.out.println("integer3 != integer4");

        System.out.println("Value of integer 3 changed: "+integer3);
        System.out.println("Value of integer 4 remains unchanged: "+integer4);


    }
}