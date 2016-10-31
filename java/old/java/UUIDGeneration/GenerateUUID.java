package old.java.UUIDGeneration;

import java.util.UUID;

/**
 * Created by pandita on 10/5/2015.
 */
public class GenerateUUID {

    public static void main(String args[])
    {
        for(int i=0;i<100;i++)
        {
            UUID id=UUID.randomUUID();
            System.out.println("UUId is\t"+id);
        }
    }

}
