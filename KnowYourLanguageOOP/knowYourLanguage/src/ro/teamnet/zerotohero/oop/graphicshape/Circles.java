package ro.teamnet.zerotohero.oop.graphicshape;

import ro.teamnet.zerotohero.exceptions.MyException;

/**
 * Created by Claudiu.Marinescu on 7/4/2017.
 */
public class Circles {

    public double getAreaPub() throws Exception {
        Circle myCircle = new Circle();
        if (myCircle.area() == Math.PI) {
            throw new MyException("Got PI in Circles!");
        }
        return myCircle.area();
    }

    public void getAreaDef() {
        int newColor = 5;
        float newSat = 2.7f;
        Circle myCircle = new Circle();
        myCircle.fillColour();
        myCircle.fillColour(newColor);
        myCircle.fillColour(newSat);
    }

}
