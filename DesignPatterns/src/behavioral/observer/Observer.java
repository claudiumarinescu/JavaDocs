package behavioral.observer;

/**
 * Created by Claudiu.Marinescu on 7/18/2017.
 */
public abstract class Observer {

    protected Subject subject;
    abstract void update();

}
