package creational.abstractFactory;

/**
 * Created by Claudiu.Marinescu on 7/18/2017.
 */
public class AmexPlatinumValidator implements Validator {

    @Override
    public boolean isValid(CreditCard creditCard) {
        return false;
    }

}
