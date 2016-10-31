package Hackerrank.ThirtyDayCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shyamsunderpandita on 24/10/16.
 */
public class RegexAndDB {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<String> users = new ArrayList<String>();
        String regExPat = "@gmail.com";
        Pattern pattern = Pattern.compile(regExPat);

        for(int a0 = 0; a0 < N; a0++){
            String firstName = in.next();
            String emailID = in.next();
            Matcher matcher  = pattern.matcher(emailID);
            if(matcher.find()){
                users.add(firstName);
            }
        }

        Collections.sort(users);
        for(String user : users){
            System.out.println(user);
        }
    }
}
