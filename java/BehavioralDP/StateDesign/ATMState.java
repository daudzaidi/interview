package BehavioralDP.StateDesign;

/**
 * Created by shalvi on 10/04/16.
 */
public interface ATMState {

    void insertCard();
    void ejectCard();
    void insertPin(int pinEntered);
    void requestCash(int cashToWithdraw);
}
