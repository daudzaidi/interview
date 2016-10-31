package BehavioralDP.StrategyDesign;

/**
 * Created by shalvi on 08/04/16.
 */
public class Dog extends Animal {

    public Dog(){
        super();
        setSound("BARK");
        setName("GROVER");
        setFavFood("BONE");
        setFlyingAbility(new CantFly());
    }
}
