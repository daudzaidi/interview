package old.java.Abstraction;

/**
 * Created by pandita on 9/25/2015.
 */
public abstract class URLAbstract {

    public void stepBefore(){
        System.out.println("Step before");
    }


    public void stepAfter(){
        System.out.println("Step after");
    }


    public void process(){
        stepBefore();
        action();
        stepAfter();
    }


    public abstract void action();
}
