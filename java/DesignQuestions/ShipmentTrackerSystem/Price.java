package DesignQuestions.ShipmentTrackerSystem;

/**
 * Created by shalvi on 29/06/16.
 */
public class Price {

    static final double serviceTax = 14.07;
    static final double deliveryCharges = 100;
    static final double vat = 12;

    public static double getTotal(double fixed){
        return fixed+((serviceTax/100)*fixed +fixed)+deliveryCharges+((vat/100)*fixed +fixed);
    }
}
