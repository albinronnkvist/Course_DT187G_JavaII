package se.miun.alrn1700.dt187g.jpaint.classes;

import se.miun.alrn1700.dt187g.jpaint.interfaces.Drawable;

/**
* TODO: explain
*
* @author Albin Rönnkvist (alrn1700)
* @version 1.0
*/

public abstract class Shape implements Drawable {
    private String color;
    private Point[] points;

    public Shape(Point p, String color) {
        this.color = color;
        this.points = new Point[1];
        this.points[0] = p;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double getCircumference();

    public abstract double getArea();

    public abstract void addPoint(Point p);
    public abstract void addPoint(double x, double y);

    public abstract boolean hasEndpoint();
}
