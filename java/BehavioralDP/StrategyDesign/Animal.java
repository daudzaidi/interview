package BehavioralDP.StrategyDesign;

/**
 * Created by shalvi on 08/04/16.
 */
public class Animal {


    private String name;
    private double height;
    private int weight;
    private String favFood;
    private double speed;
    private String sound;

    // we use an instance variable that is a subclass
    // of the Flys interface.
    // Animal doesn't care what flyingType does, it just
    // knows the behavior is available to its subclasses
    // This is known as Composition : Instead of inheriting
    // an ability through inheritance the class is composed
    // with Objects with the right ability
    // Composition allows you to change the capabilities of
    // objects at run time!
    //
    public Flys flyingType;

    public void setName(String newName){ name = newName; }
    public String getName(){ return name; }

    public void setHeight(double newHeight){ height = newHeight; }
    public double getHeight(){ return height; }

    public void setWeight(int newWeight){
        if (newWeight > 0){
            weight = newWeight;
        } else {
            System.out.println("Weight must be bigger than 0");
        }
    }
    public double getWeight(){ return weight; }

    public void setFavFood(String newFavFood){ favFood = newFavFood; }
    public String getFavFood(){ return favFood; }

    public void setSpeed(double newSpeed){ speed = newSpeed; }
    public double getSpeed(){ return speed; }

    public void setSound(String newSound){ sound = newSound; }
    public String getSound(){ return sound; }

    public void setFlyingAbility(Flys type){
        flyingType = type;
    }

    public String canFly(){
        return flyingType.fly();
    }
}
