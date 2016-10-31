package old.java.Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by pandita on 9/25/2015.
 */
public class DeserializeEmployee {

    public static void main(String args[]){
        String name ="employee.ser";
        Employee e = null;

        try {
            FileInputStream file = new FileInputStream(name);
            ObjectInputStream in = new ObjectInputStream(file);
            e=(Employee)in.readObject();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.number);
        e.mailCheck();
    }
}
