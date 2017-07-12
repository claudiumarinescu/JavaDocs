package ro.teamnet.zerotohero.reflection.demoobjects;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Claudiu.Marinescu on 7/12/2017.
 */
public class Demo extends DemoParent {

    public Demo() {}

    public Demo(int useless) {}

    public enum Days {FRIDAY, SATURDAY, SUNDAY}

    public Map<Integer, String> dictionary = new HashMap<Integer, String>();

    public int age;

    public class Samsung {};
    public class Iphone {};
    public class Nokia {};

    private String password = "qwerty";

    public String getPassword() {
        return this.password;
    }
}
