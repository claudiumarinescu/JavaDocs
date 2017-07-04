package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Claudiu.Marinescu on 7/4/2017.
 */
public class Point {

    private int xPos;
    private int yPos;

    public Point() {}

    public Point(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof Point) {
            Point other = (Point) obj;

            if ((this.xPos == other.getxPos()) && (this.yPos == other.getyPos())) {
                return true;
            }
        }
        return false;
    }
}








