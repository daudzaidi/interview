package old.java.Miscellaneous.JSONConversion;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by pandita on 11/15/2015.
 */


public class JSONConversion {

    public void JavaToJSON(Employee emp){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("emp.json"), emp);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(
                    new File("prettyemp.json"), emp);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void JSONToJava(String filename){
        Employee emp = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            emp = objectMapper.readValue(new File(filename),
                    Employee.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Employee ID: "+emp.getEmpID());
        System.out.println("Employee Name: "+ emp.getEmpName());
    }

    public static void main(String... args){
        Employee emp = new Employee("Shalvi","57395");
        JSONConversion conv = new JSONConversion();
        conv.JavaToJSON(emp);
        conv.JSONToJava("emp.json");
        conv.JSONToJava("prettyemp.json");
    }
}

