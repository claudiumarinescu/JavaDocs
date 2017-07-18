package behavioral.observer;

/**
 * Created by Claudiu.Marinescu on 7/18/2017.
 */
public class TabletClient extends Observer {

    public TabletClient (Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    public void addMessage(String message) {
        subject.setState(message + " - sent from tablet");
    }

    @Override
    void update() {
        System.out.println("Tablet Stream: " + subject.getState());
    }
}
