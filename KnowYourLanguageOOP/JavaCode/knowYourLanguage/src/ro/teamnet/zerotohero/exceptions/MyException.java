package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Claudiu.Marinescu on 7/4/2017.
 */
public class MyException extends Exception {

    public MyException() {}

    public MyException(String msg) {
        System.out.println("Exception caught: " + msg);
    }

}
