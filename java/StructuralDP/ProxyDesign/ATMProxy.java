package StructuralDP.ProxyDesign;

/**
 * Created by shalvi on 10/04/16.
 */
public class ATMProxy implements GetATMData {


    @Override
    public ATMState getATMData() {
        ATMMachine realATMMachine = new ATMMachine();
        return realATMMachine.getATMData();
    }

    @Override
    public int getCashInMachine() {
        ATMMachine realATMMachine = new ATMMachine();
        return realATMMachine.cashInMachine;
    }
}
