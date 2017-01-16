package Recursion;

/**
 * Created by shyamsunderpandita on 10/01/17.
 */
public class HelloWorld {
    public void HelloWorld(int count)
    {
        if(count<1){
            System.out.println("count < 1  : count = "+count);
            return;
        }

        System.out.println("Hello World!");
        System.out.println("count-1 : count = "+count);
        HelloWorld(count - 1);
        System.out.println("count-2 : count = "+count);
        HelloWorld(count - 2);

        System.out.println("FINISHED !! : count = " + count);
    }

    public static void main(String... args){
        HelloWorld h = new HelloWorld();
        h.HelloWorld(5);

    }
}
