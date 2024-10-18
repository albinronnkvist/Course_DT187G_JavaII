package se.miun.alrn1700.dt187g.jpaint.geometry;

import java.util.ArrayList;

import se.miun.alrn1700.dt187g.jpaint.Drawable;

/**
* An abstract class for shapes.
*
* @author Albin Rönnkvist (alrn1700)
* @version 1.0
*/

public abstract class Shape implements Drawable {
    private String color;
    protected ArrayList<Point> points;

    public Shape(Point p, String color) {
        this.color = color;
        this.points = new ArrayList<Point>();
        this.points.add(p);
    }

    
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public abstract void draw();

    @Override
    public abstract void draw(java.awt.Graphics g);

    public abstract double getCircumference();

    public abstract double getArea();

    public void addPoint(Point p) {
        this.points.add(p);
    }

    public void addPoint(double x, double y) {
        addPoint(new Point(x, y));
    }

    public ArrayList<Point> getPoints() {
        return this.points;
    }

    public abstract boolean hasEndpoint();
}
