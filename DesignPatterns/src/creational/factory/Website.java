package creational.factory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Claudiu.Marinescu on 7/18/2017.
 */
public abstract class Website {

    protected List<Page> pages = new ArrayList<>();

    public Website() {
        this.createWebsite();
    }

    public abstract void createWebsite();

    public List<Page> getPages() {
        return this.pages;
    }

}
