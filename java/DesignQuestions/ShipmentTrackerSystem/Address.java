package DesignQuestions.ShipmentTrackerSystem;

/**
 * Created by shalvi on 29/06/16.
 */
public class Address {
    String city;
    String house;
    String district;
    String country;
    String pincode;

    public Address(String city, String house, String district, String country, String pincode) {
        this.city = city;
        this.house = house;
        this.district = district;
        this.country = country;
        this.pincode = pincode;
    }

    public String toString(){
        return " House No. "+house+", "+district+", "+city+", "+country+", "+pincode;
    }
}
