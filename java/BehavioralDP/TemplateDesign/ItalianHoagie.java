package BehavioralDP.TemplateDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class ItalianHoagie extends Hoagie{

    String[] meatUsed = {"chicken","mutton"};
    String[] cheeseUsed = {"cheddar","provolone"};
    String[] veggiesUsed = {"tomatoes","cucumber","onion","mushroom"};

    @Override
    void addMeat() {


        System.out.println("Adding the Meat :");
        for(String meat: meatUsed){
            System.out.println(meat);
        }
    }

    @Override
    void addCheese() {


        System.out.println("Adding the Cheeses :");
        for(String cheese: cheeseUsed){
            System.out.println(cheese);
        }
    }

    @Override
    void addVeggies() {


        System.out.println("Adding the Veggies :");
        for(String veg: veggiesUsed){
            System.out.println(veg);
        }
    }

    @Override
    boolean customerWantsMeat() {
        return true;
    }

    @Override
    boolean customerWantsCheese() {
        return true;
    }

    @Override
    boolean customerWantsVeggies() {
        return true;
    }
}
