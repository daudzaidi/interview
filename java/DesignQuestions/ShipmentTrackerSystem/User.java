package DesignQuestions.ShipmentTrackerSystem;

import java.util.List;

/**
 * Created by shalvi on 29/06/16.
 */
public class User {
    String username;
    String userID;
    Location permanentAddress;
    Location deliveryAddress;
    Contact contactDetails;

    public User(String username,Location permanentAddress, Location deliveryAddress, Contact contactDetails) {
        this.username = username;
        this.permanentAddress = permanentAddress;
        this.deliveryAddress = deliveryAddress;
        this.contactDetails = contactDetails;
    }

    public List<Item> checkoutItems(List<Item> items){
        System.out.println("===================================================================================");
        System.out.println("Dear : "+this.username+" , you have put following items in the basket: ");
        for(Item item : items){
            System.out.println(item.itemName);
        }
        System.out.println("===================================================================================");
        return items;
    }
}
