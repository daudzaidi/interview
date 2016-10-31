package CreationalDP.Singleton;

/**
 * Created by shalvi on 19/03/16.
 */
public class RuntimeSingleton {

    public static void main(String args[]){

        Runtime singletonRuntime = Runtime.getRuntime();
        System.out.println("Singleton Runtime before GC: "+ singletonRuntime);
        singletonRuntime.gc();
        System.out.println("Singleton Runtime after GC: "+ singletonRuntime);
        Runtime anotherInstance = Runtime.getRuntime();

        if(singletonRuntime == anotherInstance)
            System.out.println("Both instances are same");

    }
}
