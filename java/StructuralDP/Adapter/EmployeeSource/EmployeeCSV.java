package StructuralDP.Adapter.EmployeeSource;

import java.util.StringTokenizer;

/**
 * Created by shalvi on 03/04/16.
 */
public class EmployeeCSV {
    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;

    public EmployeeCSV(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s,",");
        if(tokenizer.hasMoreElements()){
            id=Integer.parseInt(tokenizer.nextToken());
        }
        if(tokenizer.hasMoreElements()){
            firstName = tokenizer.nextToken();
        }
        if(tokenizer.hasMoreElements()){
            lastName = tokenizer.nextToken();
        }
        if(tokenizer.hasMoreElements()){
            emailAddress = tokenizer.nextToken();
        }
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

}
