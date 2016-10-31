package BehavioralDP.ChainOfResponsibility;

/**
 * Created by shalvi on 10/04/16.
 */
public class MultiplyNumbers implements Chain {
    private Chain nextInChain;


    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void calculate(Numbers request) {

        if(request.getCalculationWanted() == "mult"){

            System.out.print(request.getNumber1() + " * " + request.getNumber2() + " = "+
                    (request.getNumber1()*request.getNumber2()));

        } else {

            nextInChain.calculate(request);

        }
    }
}
