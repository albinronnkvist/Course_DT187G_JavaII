package se.miun.alrn1700.dt187g.jpaint.geometry;
/**
* A class which represents a rectangle shape.
*
* @author Albin Rönnkvist (alrn1700)
* @version 1.0
*/

import java.awt.Graphics;

public class Rectangle extends Shape {

    public Rectangle(Point p, String color) {
        super(p, color);
    }

    public Rectangle(double x, double y, String color) {
        this(new Point(x, y), color);
    }

    public double getWidth() {
        if(!hasEndpoint()){
            return 0;
        }

        var startPointX = points.get(0).getX();
        var endPointX = points.get(1).getX();
        
        return Math.abs(startPointX - endPointX);
    }

    public double getHeight() {
        if(!hasEndpoint()){
            return 0;
        }
        
        var startPointY = points.get(0).getY();
        var endPointY = points.get(1).getY();
        
        return Math.abs(startPointY - endPointY);
    }

    @Override
    public double getCircumference() {
        if(!hasEndpoint()){
            return 0;
        }

        return 2 * (getWidth() + getHeight());
    }

    @Override
    public double getArea() {
        if(!hasEndpoint()){
            return 0;
        }

        return getWidth() * getHeight();
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + this.toString());
    }

    // Implement in another assignment
    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

    @Override
    public void addPoint(Point p) {
        if (points.size() > 1) {
            points.set(1, p);
        } else {
            points.add(1, p);
        }
    }

    @Override
    public void addPoint(double x, double y) {
        addPoint(new Point(x, y));
    }

    @Override
    public boolean hasEndpoint() {
        return points.size() == 2 && points.get(1) != null;
    }

    @Override
    public String toString() {
        var rectangleInfo = new StringBuilder();
        rectangleInfo.append("Rectangle[");
        rectangleInfo.append("start=" + points.get(0).toString()); 
        rectangleInfo.append(" end=" + (hasEndpoint() ? points.get(1).toString() : "N/A"));
        rectangleInfo.append(" width=" + (hasEndpoint() ? getWidth() : "N/A"));
        rectangleInfo.append(" height=" + (hasEndpoint() ? getHeight() : "N/A"));
        rectangleInfo.append(" color=" + (getColor() != null && !getColor().isBlank() ? getColor() : "N/A"));
        rectangleInfo.append("]");

        return rectangleInfo.toString();
    }
}
