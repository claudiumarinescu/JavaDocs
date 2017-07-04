package ro.teamnet.zerotohero.oop.graphicshape;

import static java.lang.Math.PI;

/**
 * Created by Claudiu.Marinescu on 7/4/2017.
 */
public class Circle extends Shape {

    private int xPos, yPos, radius;

    public Circle() {
        this.xPos = 0;
        this.yPos = 0;
        this.radius = 1;
    }

    public Circle(int r) {
        this.xPos = 0;
        this.yPos = 0;
        this.radius = r;
    }

    public Circle(int x, int y) {
        this.xPos = x;
        this.yPos = y;
        this.radius = 1;
    }

    public Circle(int x, int y, int r) {
        this.xPos = x;
        this.yPos = y;
        this.radius = r;
    }

    public double area() {
        return (Math.PI * radius * radius);
    }

    @Override
    public String toString() {
        return "center = ( " + xPos + ", " + yPos + ") and radius = " + radius;
    }

    public void fillColour() {
        System.out.println(super.getColor());
    }

    public void fillColour(int newColor) {
        this.color = newColor;
        System.out.println("The circle color is now " + this.color);
    }

    public void fillColour(float newSat) {
        super.saturation = newSat;
        System.out.println("The parent's saturation is now " + super.saturation);
    }
}
