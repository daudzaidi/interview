package BehavioralDP.ObserverDesign;

import java.util.ArrayList;

/**
 * Created by shalvi on 08/04/16.
 */
public class StockGrabber implements Subject {

    private ArrayList<Observer> observers;
    private double ibmPrice;
    private double googlePrice;
    private double amazonPrice;

    public StockGrabber(){

        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);
        System.out.println("Observer Deleted :" + deleteObserver);
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observers){
            observer.update(ibmPrice,googlePrice,amazonPrice);
        }
    }

    public void setIBMPrice(double newPrice){
        this.ibmPrice = newPrice;
        notifyObserver( );
    }

    public void setGooglePrice(double newPrice){
        this.googlePrice = newPrice;
        notifyObserver( );
    }

    public void setAmazonPrice(double newPrice){
        this.amazonPrice = newPrice;
        notifyObserver( );
    }
}
