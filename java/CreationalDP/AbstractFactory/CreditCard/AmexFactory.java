package CreationalDP.AbstractFactory.CreditCard;

/**
 * Created by shalvi on 20/03/16.
 */
public class AmexFactory extends CreditCardFactory {
    @Override
    public CreditCard getCreditCard(CardType type) {
        switch (type){
            case GOLD: return new AmexGoldCreditCard();
            case PLATINUM: return new AmexPlatinumCreditCard();
        }

        return null;
    }

    @Override
    public Validator getValidator(CardType type) {
        switch(type){
            case GOLD: return new AmexGoldValidator();
            case PLATINUM:return new AmexPlatinumValidator();
        }
        return null;
    }
}
