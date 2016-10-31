package BehavioralDP.ObserverDesign;

/**
 * Created by shalvi on 08/04/16.
 */
public interface Subject {

    public void register(Observer o);

    public void unregister(Observer o);

    public void notifyObserver( );
}
