package CreationalDP.AbstractFactory.CreditCard;

/**
 * Created by shalvi on 20/03/16.
 */
public abstract class CreditCard {

    protected int cardNumberLength;

    public int getCardNumberLength() {
        return cardNumberLength;
    }

    public void setCardNumberLength(int cardNumberLength) {
        this.cardNumberLength = cardNumberLength;
    }

    public int getCscsNumber() {
        return cscsNumber;
    }

    public void setCscsNumber(int cscsNumber) {
        this.cscsNumber = cscsNumber;
    }

    protected int cscsNumber;
}
