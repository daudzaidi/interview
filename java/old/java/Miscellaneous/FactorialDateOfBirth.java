package old.java.Miscellaneous;

import java.util.regex.Pattern;

/**
 * Created by pandita on 1/5/2016.
 */
public class FactorialDateOfBirth {

    public boolean calcFactorial(String dob){
        if(dob==null)
            return false;

        int len = dob.length();
        if(len!=8) //default format dd.mm.yy (8 characters)
            return false; // Invalid Date

        String[] datesplit = dob.split(Pattern.quote("."));

        for(int i =0;i<datesplit.length;i++){
            int next = Integer.parseInt(datesplit[i]);
            if(next<10){
                System.out.print(getFactorial(0));
                System.out.print(getFactorial(next));
            }
            else{
            printFactorial(next);
           }
           System.out.print(".");
        }
        return true;
    }

    public int getFactorial(int n){
        if(n==0 || n==1)
            return 1;

        return n*getFactorial(n-1);
    }

    public void  printFactorial(int n){
        if(n>=10)
            printFactorial(n/10);
        System.out.print(getFactorial(n));
    }

    public static void main(String... args){
        FactorialDateOfBirth d = new FactorialDateOfBirth();
        String dob="01.05.91";
        d.calcFactorial(dob);
    }
}
