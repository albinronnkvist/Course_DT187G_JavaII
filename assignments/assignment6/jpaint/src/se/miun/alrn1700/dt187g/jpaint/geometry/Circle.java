package se.miun.alrn1700.dt187g.jpaint.geometry;
/**
* A class which represents a circle shape.
*
* @author Albin Rönnkvist (alrn1700)
* @version 1.0
*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Arrays;

public class Circle extends Shape {
    private final double PI = 3.14159265;

    public Circle(Point point, String color) {
        super(point, color);
    }

    public Circle(ArrayList<Point> points, String color) {
        super(points, color);
    }

    public Circle(double x, double y, String color) {
        this(new Point(x, y), color);
    }

    public Circle(double x1, double y1, double x2, double y2, String color) {
        this(new ArrayList<Point>(Arrays.asList(
                new Point(x1, y1),
                new Point(x2, y2)))
            , color);
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
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(Color.decode(getColor()));

        var startPoint = points.get(0);
        double centerX = startPoint.getX();
        double centerY = startPoint.getY();
        double radius = getRadius();

        double x = (centerX - radius);
        double y = (centerY - radius);
        double diameter = (2 * radius);

        var circle = new Ellipse2D.Double(x, y, diameter, diameter);

        g2.fill(circle);
    }

    @Override
    public void addPoint(Point p) {
        if (this.points.size() > 1) {
            this.points.set(1, p);
        } else {
            this.points.add(1, p);
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
        rectangleInfo.append("Circle[");
        rectangleInfo.append("start=" + points.get(0).toString()); 
        rectangleInfo.append(" end=" + (hasEndpoint() ? points.get(1).toString() : "N/A"));
        rectangleInfo.append(" radius=" + (hasEndpoint() ? getRadius() : "N/A"));
        rectangleInfo.append(" color=" + (getColor() != null && !getColor().isBlank() ? getColor() : "N/A"));
        rectangleInfo.append("]");

        return rectangleInfo.toString();
    }
}
