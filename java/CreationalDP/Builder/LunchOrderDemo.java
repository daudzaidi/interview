package CreationalDP.Builder;

/**
 * Created by shalvi on 19/03/16.
 */
public class LunchOrderDemo {

    public static void main(String... args){
        LunchOrderBuilder.Builder builder = new LunchOrderBuilder.Builder();
        builder.bread("wheat").condiment("lettuce").dressing("mayo").meat("turkey");

        LunchOrderBuilder lunch = builder.build();

        System.out.println("Bread: "+lunch.getBread());
        System.out.println("Condiment: "+lunch.getCondiment());
        System.out.println("Dressing: "+lunch.getDressing());
        System.out.println("Meat: "+lunch.getMeat());
    }
}
