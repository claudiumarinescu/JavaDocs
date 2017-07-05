package exceptii;

/**
 * Created by Claudiu.Marinescu on 7/4/2017.
 */
public class AnimalManancaAnimalException extends RuntimeException {

    public AnimalManancaAnimalException() {}

    public AnimalManancaAnimalException(String msg) {
        System.out.println("Unchecked exception message: " + msg);
    }
}

