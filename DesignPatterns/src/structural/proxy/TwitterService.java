package structural.proxy;

/**
 * Created by Claudiu.Marinescu on 7/18/2017.
 */
public interface TwitterService {

    String getTimeline(String screenName);
    void postToTimeline(String screenName, String Message);

}
