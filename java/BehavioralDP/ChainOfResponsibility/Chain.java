package BehavioralDP.ChainOfResponsibility;

/**
 * Created by shalvi on 10/04/16.
 */
public interface Chain {

    public void setNextChain(Chain nextChain);

    public void calculate(Numbers request);
}
