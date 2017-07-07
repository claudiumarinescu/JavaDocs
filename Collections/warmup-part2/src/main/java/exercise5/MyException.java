package exercise5;

/**
 * Created by Claudiu.Marinescu on 7/5/2017.
 */
public class MyException extends RuntimeException {

    public MyException() {}

    public MyException(String msg) {
        System.out.println("Exception meesage: " + msg);
    }

}
