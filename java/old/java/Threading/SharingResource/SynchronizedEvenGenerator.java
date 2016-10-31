package old.java.Threading.SharingResource;

/**
 * Created by pandita on 9/20/2015.
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    @Override
    public synchronized  int next() {
        ++currentEvenValue;
        ++currentEvenValue; //Danger Point Here
        return currentEvenValue;
    }

}
