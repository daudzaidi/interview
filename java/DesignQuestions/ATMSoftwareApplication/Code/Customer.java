package DesignQuestions.ATMSoftwareApplication.Code;

/**
 * Created by shalvi on 18/04/16.
 */
public class Customer {

    private Card customersATMCard;

    // Replaces public Card insertATMCard()

    Customer(Card newATMCard){

        customersATMCard = newATMCard;

    }

    public Card getATMCard() { return customersATMCard; }
}
