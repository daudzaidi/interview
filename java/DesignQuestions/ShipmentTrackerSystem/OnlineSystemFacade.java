package DesignQuestions.ShipmentTrackerSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shalvi on 29/06/16.
 */
public class OnlineSystemFacade {

    OrderSystem orderSystem;
    ShipmentSystem shipmentSystem;
    Map<String,User> registeredUsers;
    static int autogenerator = 20000;

    public OnlineSystemFacade(OrderSystem orderSystem, ShipmentSystem shipmentSystem) {
        this.orderSystem = orderSystem;
        this.shipmentSystem = shipmentSystem;
        this.registeredUsers = new HashMap<>();
    }

    public void registerOnline(User user){
        user.userID = "user_"+autogenerator;
        autogenerator++;
        this.registeredUsers.put(URLgenerator(user.userID),user);
    }

    public void orderItems(List<Item> items,User user){
        System.out.println("===================================================================================");
        System.out.println("Customer ID : "+user.userID+" placed an order for following items: ");
        for(Item item : items){
            System.out.println(item.itemName);
        }
        System.out.println("===================================================================================");
        OrderPackage orderPackage = orderSystem.generateOrder(items,user);
        Invoice invoice = orderSystem.generateInvoice(orderPackage,user);
        System.out.println("===================================================================================");
        System.out.println(invoice.toString());
        System.out.println("===================================================================================");
        shipmentSystem.generateShipment(user.deliveryAddress,ShipmentState.SHIPPED,URLgenerator(user.userID),orderPackage,user);
    }


    public String URLgenerator(String userID){
        return "http://trackshipment.system.com/"+userID;
    }

}
