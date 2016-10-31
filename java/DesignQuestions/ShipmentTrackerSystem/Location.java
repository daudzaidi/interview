package DesignQuestions.ShipmentTrackerSystem;

/**
 * Created by shalvi on 29/06/16.
 */
public abstract class Location {
    Address address;
    public Address getAddress(){
        return address;
    }

    public String toString(){
        return address.toString();
    }
}
