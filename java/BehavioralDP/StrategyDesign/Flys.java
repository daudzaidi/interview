package BehavioralDP.StrategyDesign;

/**
 * Created by shalvi on 08/04/16.
 */

// The interface is implemented by many other
// subclasses that allow for many types of flying
// without effecting Animal, or Flys.

// Classes that implement new Flys interface
// subclasses can allow other classes to use
// that code eliminating code duplication

// I'm decoupling : encapsulating the concept that varies


public interface Flys {

    public String fly();
}


class CantFly implements Flys {
    @Override
    public String fly() {
        return "I cannot Fly";
    }
}


class FlyWithWings implements Flys{
    @Override
    public String fly() {
        return "Flying High With Wings";
    }
}
