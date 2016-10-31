package BehavioralDP.StrategyDesign;

/**
 * Created by shalvi on 08/04/16.
 */
public class Bird extends Animal {

    public Bird(){
        super();
        setSound("QUACK");
        setName("DUCK");
        setFavFood("SEEDS");
        setFlyingAbility(new FlyWithWings());
    }

}
