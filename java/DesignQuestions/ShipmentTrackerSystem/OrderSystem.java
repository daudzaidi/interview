package DesignQuestions.ShipmentTrackerSystem;

import java.util.List;

/**
 * Created by shalvi on 29/06/16.
 */
public class OrderSystem {

    public OrderPackage generateOrder(List<Item> itemList,User user){
        return new OrderPackage(itemList,user);
    }

    public Invoice generateInvoice(OrderPackage orderPackage,User user){
        return new Invoice(orderPackage,user);
    }

}
