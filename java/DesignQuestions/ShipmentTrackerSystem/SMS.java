package DesignQuestions.ShipmentTrackerSystem;

/**
 * Created by shalvi on 29/06/16.
 */
public class SMS extends NotificationSystem {
    @Override
    public void sendNotification(ShipmentPackage shipmentPackage, User user) {
        System.out.println("===================================================================================");
        System.out.println("Dear "+user.username+", this sms sent to u at"+user.contactDetails.mobile+" has been sent to inform that your shipment with the shipment ID "+ shipmentPackage.packageID+"" +
                " is "+shipmentPackage.shipmentState+" at the location "+shipmentPackage.deliveryLocation.toString()+". You can track your complete order status at "+shipmentPackage.URL);
        System.out.println("===================================================================================");
    }
}
