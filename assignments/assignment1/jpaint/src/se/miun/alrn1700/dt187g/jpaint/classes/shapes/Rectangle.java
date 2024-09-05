/**
* TODO: explain
*
* @author Albin Rönnkvist (alrn1700)
* @version 1.0
*/

package se.miun.alrn1700.dt187g.jpaint.classes.shapes;

import java.awt.Graphics;
import se.miun.alrn1700.dt187g.jpaint.classes.Point;
import se.miun.alrn1700.dt187g.jpaint.classes.Shape;

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

        var startPointX = points[0].getX();
        var endPointX = points[1].getX();
        
        return Math.abs(startPointX - endPointX);
    }

    public double getHeight() {
        if(!hasEndpoint()){
            return 0;
        }
        
        var startPointY = points[0].getY();
        var endPointY = points[1].getY();
        
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
        System.out.println(this.toString());
    }

    // Implement in another assignment
    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }


    @Override
    public void addPoint(Point p) {
        points[1] = p;
    }

    @Override
    public void addPoint(double x, double y) {
        addPoint(new Point(x, y));
    }

    @Override
    public boolean hasEndpoint() {
        return points[1] != null;
    }

    @Override
    public String toString() {
        var rectangleInfo = new StringBuilder();
        rectangleInfo.append("Rectangle[");
        rectangleInfo.append("start=" + points[0].toString()); 
        rectangleInfo.append(" end=" + (hasEndpoint() ? points[1].toString() : "N/A"));
        rectangleInfo.append(" width=" + (hasEndpoint() ? getWidth() : "N/A"));
        rectangleInfo.append(" height=" + (hasEndpoint() ? getHeight() : "N/A"));
        rectangleInfo.append(" color=" + (getColor() != null && !getColor().trim().isEmpty() ? getColor() : "N/A"));
        rectangleInfo.append("]");

        return rectangleInfo.toString();
    }
}
