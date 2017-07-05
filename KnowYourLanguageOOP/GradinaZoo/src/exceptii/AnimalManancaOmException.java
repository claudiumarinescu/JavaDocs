package exceptii;

/**
 * Created by Claudiu.Marinescu on 7/4/2017.
 */
public class AnimalManancaOmException extends RuntimeException {

    public AnimalManancaOmException() {}

    public AnimalManancaOmException(String msg) {
        System.out.println("Unchecked exception message: " + msg);
    }
}
