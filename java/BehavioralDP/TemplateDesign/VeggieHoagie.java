package BehavioralDP.TemplateDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class VeggieHoagie extends Hoagie {

    String[] veggiesUsed = {"tomatoes","cucumber","onion","mushroom"};

    @Override
    void addMeat() {
        System.out.println("NO MEAT TO BE ADDED\n");
    }

    @Override
    void addCheese() {
        System.out.println("NO MEAT TO BE ADDED\n");
    }

    @Override
    void addVeggies() {

        System.out.println("Adding the Veggies :\n");
        for(String veg: veggiesUsed){
            System.out.println(veg);
        }
    }

    @Override
    boolean customerWantsMeat() {
        return false;
    }

    @Override
    boolean customerWantsCheese() {
        return false;
    }

    @Override
    boolean customerWantsVeggies() {
        return true;
    }
}
