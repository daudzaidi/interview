package BehavioralDP.VisitorDesign;

/**
 * Created by shalvi on 10/04/16.
 */
public class VisitorTest {
    public static void main(String args[]){

        TaxVisitor taxVisitor = new TaxVisitor();

        Necessity milk = new Necessity(3.47);

        Liquor vodka = new Liquor(100);

        Tobacco tobacco = new Tobacco(23);

        System.out.println("\n"+milk.accept(taxVisitor));
        System.out.println("\n"+vodka.accept(taxVisitor));
        System.out.println("\n"+tobacco.accept(taxVisitor));
    }
}
