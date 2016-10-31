package DesignQuestions.ShipmentTrackerSystem;

/**
 * Created by shalvi on 29/06/16.
 */
public class Item {
    ItemType itemType;
    ItemFragility itemFargility;
    String itemID;
    String itemName;
    double price;

    public Item(ItemType itemType, ItemFragility itemFragility, String itemID, String itemName, double price) {
        this.itemType = itemType;
        this.itemFargility = itemFragility;
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price;
    }
}
