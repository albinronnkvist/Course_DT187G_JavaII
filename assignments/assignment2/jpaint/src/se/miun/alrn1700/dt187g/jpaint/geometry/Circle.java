package se.miun.alrn1700.dt187g.jpaint.geometry;
/**
* A class which represents a circle shape.
*
* It inherits from the abstract Shape class
*   - It overrides all abstract methods
*   - It can access all public and protected members of the Shape class
*
* @author Albin Rönnkvist (alrn1700)
* @version 1.0
*/

import java.awt.Graphics;

public class Circle extends Shape {
    private final double PI = 3.14159265;

    public Circle(Point p, String color) {
        super(p, color);
    }

    public Circle(double x, double y, String color) {
        this(new Point(x, y), color);
    }

    public double getRadius() {
        if(!hasEndpoint()){
            return 0;
        }
        
        var startPointX = points.get(0).getX();
        var startPointY = points.get(0).getY();
        var endPointX = points.get(1).getX();
        var endPointY = points.get(1).getY();
        
        return Math.sqrt(Math.pow(endPointX - startPointX, 2) + Math.pow(endPointY - startPointY, 2));
    }

    @Override
    public double getCircumference() {
        if(!hasEndpoint()){
            return 0;
        }

        return 2 * PI * getRadius();
    }
    
    @Override
    public double getArea() {
        if(!hasEndpoint()){
            return 0;
        }

        return PI * Math.pow(getRadius(), 2);
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
    public boolean hasEndpoint() {
        return points.get(1) != null;
    }

    @Override
    public String toString() {
        var rectangleInfo = new StringBuilder();
        rectangleInfo.append("Circle[");
        rectangleInfo.append("start=" + points.get(0).toString() + ";"); 
        rectangleInfo.append(" end=" + (hasEndpoint() ? points.get(1).toString() : "N/A") + ";");
        rectangleInfo.append(" radius=" + (hasEndpoint() ? getRadius() : "N/A") + ";");
        rectangleInfo.append(" color=" + (getColor() != null && !getColor().trim().isEmpty() ? getColor() : "N/A"));
        rectangleInfo.append("]");

        return rectangleInfo.toString();
    }
}
