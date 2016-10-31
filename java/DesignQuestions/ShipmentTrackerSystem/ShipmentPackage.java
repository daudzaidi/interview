package DesignQuestions.ShipmentTrackerSystem;

/**
 * Created by shalvi on 29/06/16.
 */
public class ShipmentPackage extends Package{
    Location deliveryLocation;
    ShipmentState shipmentState;
    OrderPackage orderPackage;
    String URL;

    private static int incrementor = 10000;

    public ShipmentPackage(Location location, ShipmentState state, String url,OrderPackage orderPackage,User user){
        this.user = user;
        this.deliveryLocation = location;
        this.shipmentState = state;
        this.URL = url;
        this.orderPackage = orderPackage;
        this.packageID = "shipment_"+incrementor;
        incrementor++;
    }


}
