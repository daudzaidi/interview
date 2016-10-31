package old.java.Serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by pandita on 9/25/2015.
 */
public class SerializeEmployee {

    public static void main(String args[]){

        String filename = "employee.ser";
        Employee e = new Employee();
        e.name="Shalvi";
        e.address="Adobe";
        e.number=123456;
        e.SSN=1191;

        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(e);
            out.close();
            fos.close();
            System.out.printf("Serialized data is saved in employee.ser");
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }
}
