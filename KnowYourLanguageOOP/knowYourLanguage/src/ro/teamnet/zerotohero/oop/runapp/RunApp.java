package ro.teamnet.zerotohero.oop.runapp;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.w3c.dom.css.Rect;
import ro.teamnet.zerotohero.exceptions.MyException;
import ro.teamnet.zerotohero.oop.graphicshape.*;
import ro.teamnet.zerotohero.canvas.Canvas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Claudiu.Marinescu on 7/4/2017.
 */
public class RunApp {

    public static void main(String[] args) throws Exception {

        Circles circles = new Circles();
        //System.out.println(circles.getAreaPub());

//        if (circles.getAreaPub() == Math.PI) {
//            throw new MyException("Got PI.");
//        }

        try (BufferedReader br = new BufferedReader(new FileReader("example.txt"))) {
            System.out.println(br.readLine());
            throw new MyException("I threw this one...");
        } catch (FileNotFoundException e) {
            System.out.println("First catch block: " + e.getMessage());
        } catch (ArithmeticException | MyException e) {
            System.out.println(" Other exception: " + e.getMessage());
        } finally {
            System.out.println("===> In finally block <===");
        }

        circles.getAreaDef();

        Canvas canvas = new Canvas();
        //canvas.paint();

        Shape poli = new Circle(10);
        System.out.println("[Polimorphism] Circle area = " + poli.area());

        ShapeBehaviour poli2 = new Square(10);
        System.out.println("[Polimorphism] Square area = " + poli2.area());

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);
        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));

        Rectangle r = new Rectangle(2,4);
        System.out.println("Area of the rectangle: " + r.area());
    }

}
