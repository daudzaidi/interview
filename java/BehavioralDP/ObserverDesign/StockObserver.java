package BehavioralDP.ObserverDesign;

/**
 * Created by shalvi on 08/04/16.
 */
public class StockObserver implements Observer {

    private double ibmPrice;
    private double googlePrice;
    private double amazonPrice;

    private static int observerIDTracker = 0;

    private int observerID;

    private Subject stockGrabber;

    public StockObserver(Subject stockGrabber){
        this.stockGrabber = stockGrabber;
        this.observerID = ++observerIDTracker;
        System.out.println("New Observer : id # "+this.observerID);
        stockGrabber.register(this);
    }

    @Override
    public void update(double ibmPrice, double googlePrice, double amazonPrice) {
        this.ibmPrice = ibmPrice;
        this.googlePrice = googlePrice;
        this.amazonPrice = amazonPrice;

        printThePrices();
    }

    public void printThePrices() {
        System.out.println("ObserverID # : "+this.observerID );
        System.out.println("AMAZON : "+this.amazonPrice );
        System.out.println("GOOGLE : "+this.googlePrice );
        System.out.println("IBM : "+this.ibmPrice );
    }
}
