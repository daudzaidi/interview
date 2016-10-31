package DesignQuestions.ShipmentTrackerSystem;

/**
 * Created by shalvi on 29/06/16.
 */
public class Invoice {
    OrderPackage orderPackage;
    User user;

    public Invoice(OrderPackage orderPackage, User user) {
        this.orderPackage = orderPackage;
        this.user = user;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("YOUR INVOICE :\n");
        builder.append("Hello "+this.user.username+"\n");
        builder.append("User ID :" + this.user.userID+"\n");
        builder.append("Address :" + this.user.permanentAddress.toString()+"\n");
        builder.append("Total Amount : "+"\n");
        builder.append("Fixed Charges = "+orderPackage.fixedPrice+"\n");
        builder.append("Service Charges = "+Price.serviceTax+" %"+"\n");
        builder.append("Delivery Charges = "+Price.deliveryCharges+"\n");
        builder.append("VAT Charges = "+Price.vat+ " %"+"\n");
        builder.append("Total = "+ orderPackage.totalPrice+"\n");
        return builder.toString();
    }
}
