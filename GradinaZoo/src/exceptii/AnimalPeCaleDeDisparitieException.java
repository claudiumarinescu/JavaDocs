package exceptii;

import animale.Animal;

/**
 * Created by Claudiu.Marinescu on 7/4/2017.
 */
public class AnimalPeCaleDeDisparitieException extends Exception {

    public AnimalPeCaleDeDisparitieException() {}

    public AnimalPeCaleDeDisparitieException(String msg) {
        System.out.println("Checked exception message: " + msg);
    }
}
