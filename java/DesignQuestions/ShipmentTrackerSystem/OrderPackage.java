package DesignQuestions.ShipmentTrackerSystem;

import java.util.List;

/**
 * Created by shalvi on 29/06/16.
 */
public class OrderPackage extends Package{

    List<Item> orderItems;
    double totalPrice;
    double fixedPrice;
    private static int incrementor = 1000;

    OrderPackage(List<Item> items,User user){
        this.user = user;
        this.orderItems = items;
        this.packageID = "order_"+incrementor;
        double total = 0;
        for(Item item : items){
            total = total + item.price;
        }
        this.fixedPrice = total;
        this.totalPrice = Price.getTotal(total);
        incrementor++;
    }
}
