package old.java.Abstraction;

/**
 * Created by pandita on 9/25/2015.
 */
public class URL extends URLAbstract {
    @Override
    public void action() {
        System.out.println("Action in URL Class");
    }
    public static void main(String args[]){
        URL url = new URL();
        url.process();
    }
}
