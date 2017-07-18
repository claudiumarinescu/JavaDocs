package behavioral.observer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Claudiu.Marinescu on 7/18/2017.
 */
public class MessageStream extends Subject {

    private Deque<String> messageHistory = new ArrayDeque<>();

    @Override
    void setState(String state) {
        messageHistory.add(state);
        this.notifyObservers();
    }

    @Override
    String getState() {
        return messageHistory.getLast();
    }
}
