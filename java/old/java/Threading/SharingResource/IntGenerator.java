package old.java.Threading.SharingResource;

/**
 * Created by pandita on 9/19/2015.
 */
public abstract class IntGenerator {
    private volatile boolean canceled=false;
    public abstract int next();
    public void cancel(){ canceled=true; }
    public boolean isCancelled(){ return canceled;}
}
