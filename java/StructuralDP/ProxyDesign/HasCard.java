package StructuralDP.ProxyDesign;

/**
 * Created by shalvi on 10/04/16.
 */
public class HasCard implements ATMState {

    ATMMachine atmMachine;

    public HasCard(ATMMachine atmMachine){
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("You cannot enter more than 1 card");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card Ejected Successfully");
        atmMachine.setATMState(atmMachine.getNoCardState());
    }

    @Override
    public void insertPin(int pinEntered) {
        if(pinEntered == 1234) {
            System.out.println("Correct Pin");
            atmMachine.pinCorrectEntered = true;
            atmMachine.setATMState(atmMachine.getHasPin());
        }
        else{
            System.out.println("Incorrect Pin");
            atmMachine.pinCorrectEntered = false;
            System.out.println("Card Ejected");
            atmMachine.setATMState(atmMachine.getNoCardState());
        }
    }

    @Override
    public void requestCash(int cashToWithdraw) {
        System.out.println("You have not entered your PIN");
    }
}
