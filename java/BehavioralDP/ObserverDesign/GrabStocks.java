package BehavioralDP.ObserverDesign;

/**
 * Created by shalvi on 08/04/16.
 */
public class GrabStocks {

    public static void main(String args[]){

        StockGrabber stockGrabber = new StockGrabber();
        StockObserver observer1 = new StockObserver(stockGrabber);
        StockObserver observer2 = new StockObserver(stockGrabber);
        stockGrabber.setAmazonPrice(197.00);
        stockGrabber.setGooglePrice(200.00);
        stockGrabber.setIBMPrice(32.00);

        stockGrabber.unregister(observer1);

        stockGrabber.setAmazonPrice(210.00);
        stockGrabber.setGooglePrice(300.00);
        stockGrabber.setIBMPrice(320.00);

        Runnable getIBM = new GetTheStock(stockGrabber, "IBM", 197.00);
        Runnable getAMAZON = new GetTheStock(stockGrabber, "AMAZON", 677.60);
        Runnable getGOOGLE = new GetTheStock(stockGrabber, "GOOGLE", 676.40);

        // Call for the code in run to execute

        new Thread(getIBM).start();
        new Thread(getAMAZON).start();
        new Thread(getGOOGLE).start();
    }
}
