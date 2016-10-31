package old.java.Threading.SharingResource;

/**
 * Created by pandita on 9/20/2015.
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    @Override
    public int next() {
        ++currentEvenValue;
        ++currentEvenValue; //Danger Point Here
        return currentEvenValue;
    }
}
