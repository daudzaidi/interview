package BehavioralDP.InterpreterDesign;

/**
 * Created by shalvi on 10/04/16.
 */
public abstract class Expression {

    public abstract String gallons(double quantity);
    public abstract String quarts(double quantity);
    public abstract String pints(double quantity);
    public abstract String cups(double quantity);
    public abstract String tablespoons(double quantity);

}
