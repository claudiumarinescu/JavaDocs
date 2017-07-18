package structural.proxy;

/**
 * Created by Claudiu.Marinescu on 7/18/2017.
 */
public class TwitterServiceStub implements TwitterService {

    @Override
    public String getTimeline(String screenName) {
        return "My neato timeline";
    }

    @Override
    public void postToTimeline(String screenName, String Message) {

    }

}
