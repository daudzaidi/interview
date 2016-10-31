package CreationalDP.AbstractFactory.CreditCard;

/**
 * Created by shalvi on 20/03/16.
 */
public class AmexPlatinumValidator extends Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return true;
    }
}
