package CreationalDP.AbstractFactory.CreditCard;

/**
 * Created by shalvi on 20/03/16.
 */
public class VisaFactory extends CreditCardFactory {
    @Override
    public CreditCard getCreditCard(CardType type) {
        switch (type){
            case NORMAL:return new VisaCreditCard();
            case BLACK:return new VisaBlackCreditCard();
            case GOLD: return new VisaGoldCreditCard();
        }
        return null;
    }

    @Override
    public Validator getValidator(CardType type) {
        return new VisaValidator();
    }
}
