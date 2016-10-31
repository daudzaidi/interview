package BehavioralDP.ObserverDesign;

/**
 * Created by shalvi on 08/04/16.
 */
public interface Observer {

    public void update(double ibmPrice, double googlePrice, double amazonPrice);
}
