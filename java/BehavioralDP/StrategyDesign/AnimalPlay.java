package BehavioralDP.StrategyDesign;

/**
 * Created by shalvi on 08/04/16.
 */
public class AnimalPlay {

    public static void main(String[] args){

        Animal sparky = new Dog();
        Animal tweety = new Bird();

        System.out.println("Dog: " + sparky.canFly());

        System.out.println("Bird: " + tweety.canFly());

        // This allows dynamic changes for flyingType

        sparky.setFlyingAbility(new FlyWithWings());

        System.out.println("Dog: " + sparky.canFly());

    }
}
