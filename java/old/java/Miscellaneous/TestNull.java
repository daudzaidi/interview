package old.java.Miscellaneous;

/**
 * Created by pandita on 10/8/2015.
 */
public class TestNull {

    public static void main(String args[]){
        TestNull test = new TestNull();
        test.f(null);
    }

    void f (String str){
       System.out.println("String "+str);
    }

    void f (Object obj){
        System.out.println("Object "+ obj);
    }


}
