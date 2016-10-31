package BehavioralDP.InterpreterDesign;

/**
 * Created by shalvi on 10/04/16.
 */
public class Gallons  extends Expression{

    public String gallons(double quantity) {

        return Double.toString(quantity);
    }

    public String quarts(double quantity) {
        return Double.toString(quantity*4);
    }

    public String pints(double quantity) {
        return Double.toString(quantity*8);
    }

    public String cups(double quantity) {
        return Double.toString(quantity*16);
    }

    public String tablespoons(double quantity) {
        return Double.toString(quantity*256);
    }
}
