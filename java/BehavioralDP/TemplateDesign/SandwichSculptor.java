package BehavioralDP.TemplateDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class SandwichSculptor {

    public static void main(String... args){
        System.out.println("Order Italian Hoagie for Customer #1 :\n");

        Hoagie  cust1 = new ItalianHoagie();

        cust1.makeSandwich();

        System.out.println("Order Italian Hoagie for Customer #1 :\n");

        Hoagie cust2 = new VeggieHoagie();

        cust2.makeSandwich();
    }
}
