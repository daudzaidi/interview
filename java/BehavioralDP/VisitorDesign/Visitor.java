package BehavioralDP.VisitorDesign;

/**
 * Created by shalvi on 10/04/16.
 */
public interface Visitor {

    public double visit(Liquor liquor);
    public double visit(Tobacco tobacco);
    public double visit(Necessity necessity);
}
