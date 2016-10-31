package StructuralDP.ProxyDesign;

/**
 * Created by shalvi on 10/04/16.
 */
public class ATMMachine implements GetATMData {

    ATMState hasCard;
    ATMState noCard;
    ATMState hasCorrectPin;
    ATMState atmOutOfMoney;

    ATMState atmState;
    int cashInMachine = 2000;
    boolean pinCorrectEntered = false;

    public ATMMachine(){
        hasCard = new HasCard(this);
        noCard = new NoCard(this);
        hasCorrectPin = new HasPin(this);
        atmOutOfMoney = new NoCash(this);

        atmState = noCard;

        if(cashInMachine < 0 ){
            atmState = atmOutOfMoney;
        }
    }

    public void setATMState(ATMState state){
        atmState = state;
    }

    public void setCashInMachine(int cashInMachine) {
        this.cashInMachine = cashInMachine;
    }

    public void insertCard(){
        atmState.insertCard();
    }

    public void ejectCard(){
        atmState.ejectCard();
    }

    public void insertPin(int pin){
        atmState.insertPin(pin);
    }

    public void requestCash(int cashToWithdraw){
        atmState.requestCash(cashToWithdraw);
    }

    public ATMState getYesCardState(){
        return hasCard;
    }

    public ATMState getNoCardState(){
        return noCard;
    }

    public  ATMState getHasPin(){
        return hasCorrectPin;
    }

    public ATMState getNoCashState(){
        return atmOutOfMoney;
    }

    @Override
    public ATMState getATMData() {
        return atmState;
    }

    @Override
    public int getCashInMachine() {
        return cashInMachine;
    }
}
