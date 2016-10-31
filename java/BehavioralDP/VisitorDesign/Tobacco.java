package BehavioralDP.VisitorDesign;

/**
 * Created by shalvi on 10/04/16.
 */
public class Tobacco implements Visitable {
    private double price;

    public Tobacco(double item) {
        this.price = item;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
