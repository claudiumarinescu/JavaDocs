package creational.factory;

/**
 * Created by Claudiu.Marinescu on 7/18/2017.
 */
public class Blog extends Website {

    @Override
    public void createWebsite() {
        pages.add(new PostPage());
        pages.add(new AboutPage());
        pages.add(new CommentPage());
        pages.add(new ContactPage());
    }

}
