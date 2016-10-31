package DesignQuestions.ShipmentTrackerSystem;

/**
 * Created by shalvi on 29/06/16.
 */
public class ShipmentSystem {

    NotificationSystem notificationSystem;

    ShipmentSystem(NotificationSystem notificationSystem){
        this.notificationSystem = notificationSystem;
    }

    public ShipmentPackage generateShipment(Location address, ShipmentState initialState, String url,OrderPackage orderPackage,User user){
        ShipmentPackage shipmentPackage = new ShipmentPackage(address,initialState,url,orderPackage,user);
        registerUserWithTracker(user,shipmentPackage);
        return shipmentPackage;
    }

    public void registerUserWithTracker(User user,ShipmentPackage shipmentPackage){
        System.out.println("Dear "+user.username+", We are happy to inform that You have been successfully registered with the Shipment Tracker");
        ShipmentTracker.tracker.put(user,shipmentPackage);
    }

    public void deliverShipment(Location location,User user,ShipmentState state){
        System.out.println("The Shipment is currently at "+location);
        ShipmentTracker.tracker.get(user).shipmentState = state;
        ShipmentTracker.tracker.get(user).deliveryLocation =location;
        System.out.println("Current Shipment Status is  "+ShipmentTracker.tracker.get(user).shipmentState);
        System.out.println("Current Shipment Location is  "+ShipmentTracker.tracker.get(user).deliveryLocation);
        notificationSystem.sendNotification(ShipmentTracker.tracker.get(user),user);
    }



}
