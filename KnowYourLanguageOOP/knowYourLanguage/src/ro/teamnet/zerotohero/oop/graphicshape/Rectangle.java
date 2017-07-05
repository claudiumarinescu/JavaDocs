package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Claudiu.Marinescu on 7/4/2017.
 */
public final class Rectangle extends Shape {

    private final int length, width;

    public Rectangle(int l, int w) {
        this.length = l;
        this.width = w;
    }

    public double area() {
        return (length * width);
    }

}
