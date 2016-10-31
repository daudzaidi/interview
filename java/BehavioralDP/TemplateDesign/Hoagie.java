package BehavioralDP.TemplateDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public abstract class Hoagie {

    //TEMPLATE METHOD -

    final void makeSandwich(){
        
        cutBun();
        
        if(customerWantsMeat()){
            addMeat();
        }

        if(customerWantsCheese()){
            addCheese();
        }

        if(customerWantsVeggies()){
            addVeggies();
        }

        wrapTheHoagie();
    }

    private void wrapTheHoagie() {
        System.out.println("Hoagie Bun is Wrapped\n");
    }

    private void cutBun() {
        System.out.println("Hoagie Bun is cut\n");
    }


    abstract void addMeat();
    abstract void addCheese();
    abstract void addVeggies();
    abstract boolean customerWantsMeat();
    abstract boolean customerWantsCheese();
    abstract boolean customerWantsVeggies();
}
