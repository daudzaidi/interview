package CreationalDP.AbstractFactory.CreditCard;

/**
 * Created by shalvi on 20/03/16.
 */
public abstract class CreditCardFactory {

    public static CreditCardFactory getCreditCardFactory(int creditScore){
        if(creditScore > 750){
            return new AmexFactory();
        }
        else{
            return new VisaFactory();
        }
    }

    public abstract CreditCard getCreditCard(CardType type);

    public abstract Validator getValidator(CardType type);
}
