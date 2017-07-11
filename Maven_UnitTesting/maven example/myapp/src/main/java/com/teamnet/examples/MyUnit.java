package com.teamnet.examples;

/**
 * Created by Claudiu.Marinescu on 7/10/2017.
 */
public class MyUnit {

    public String concatenate(String one, String two){
        if (one == null) {
            return two;
        }
        if (two == null) {
            return one;
        }
        return one + two;
    }

    public boolean getBoolean() {
        return new java.util.Random().nextBoolean();
    }
}
