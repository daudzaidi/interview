package DesignQuestions.ShipmentTrackerSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shalvi on 29/06/16.
 */
public class ShipmentDemo {
    public static void main(String... args){
        OnlineSystemFacade systemFacade = new OnlineSystemFacade(new OrderSystem(),new ShipmentSystem(new Email()));
        User user = new User("shalvi",new Destination(new Address("Noida","203","Okhla","India","201301")),new Destination(new Address("Noida","203","Okhla","India","201301")),new Contact("9716528753","2506302","none","shalvipandit@gmail.com"));
        List<Item> items = new ArrayList<>();
        items.add(new Item(ItemType.LARGE,ItemFragility.FRAGILE,"ITEM_TV_203","SONY Television",70000));
        items.add(new Item(ItemType.SMALL,ItemFragility.NON_FRAGILE,"ITEM_BOOK_B1","The Da Vinci Code",900));
        items.add(new Item(ItemType.SMALL,ItemFragility.FRAGILE,"ITEM_CUPS_6","6 pc Mug Set",1230));
        items.add(new Item(ItemType.MEDIUM,ItemFragility.NON_FRAGILE,"ITEM_LAPTOP_MAC1245","Macbook Pro Laptop",55000));
        systemFacade.registerOnline(user);
        systemFacade.orderItems(user.checkoutItems(items),user);
        systemFacade.shipmentSystem.deliverShipment(new Warehouse(new Address("bombay","warehouse","thane","India","1100223")),user,ShipmentState.INTERMEDIATE);
        systemFacade.shipmentSystem.deliverShipment(user.deliveryAddress,user,ShipmentState.DELIVERED);

    }
}
