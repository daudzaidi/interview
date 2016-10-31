package BehavioralDP.VisitorDesign;

import java.text.DecimalFormat;

/**
 * Created by shalvi on 10/04/16.
 */
public class TaxVisitor implements Visitor {

    DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public TaxVisitor(){}
    @Override
    public double visit(Liquor liquor) {
        System.out.println("Liquor Item: Price With Tax");
        return Double.parseDouble(decimalFormat.format((liquor.getPrice()*0.18)+liquor.getPrice()));
    }

    @Override
    public double visit(Tobacco tobacco) {
        System.out.println("Tobacco Item: Price With Tax");
        return Double.parseDouble(decimalFormat.format((tobacco.getPrice()*0.32)+tobacco.getPrice()));
    }

    @Override
    public double visit(Necessity necessity) {
        System.out.println("Necessity Item: Price Without Tax");
        return Double.parseDouble(decimalFormat.format((necessity.getPrice()*0)+necessity.getPrice()));
    }
}
