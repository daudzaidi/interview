package BehavioralDP.ChainOfResponsibility;

/**
 * Created by shalvi on 10/04/16.
 */
public class Numbers {
    private int number1;
    private int number2;

    private String calculationWanted;

    public Numbers(int n1 , int n2, String calculationWanted){
        this.number1 = n1;
        this.number2=n2;
        this.calculationWanted = calculationWanted;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public String getCalculationWanted() {
        return calculationWanted;
    }
}
