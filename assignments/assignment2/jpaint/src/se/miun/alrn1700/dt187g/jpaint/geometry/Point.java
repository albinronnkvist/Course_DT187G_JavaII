package se.miun.alrn1700.dt187g.jpaint.geometry;
/**
* A class which represents a Point in 2D space with x and y coordinates.
*
* @author Albin Rönnkvist (alrn1700)
* @version 1.0
*/

public class Point {
    private double x;
    private double y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
