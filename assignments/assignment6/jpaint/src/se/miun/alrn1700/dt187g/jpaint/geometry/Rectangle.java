package se.miun.alrn1700.dt187g.jpaint.geometry;
/**
* A class which represents a rectangle shape.
*
* @author Albin Rönnkvist (alrn1700)
* @version 1.0
*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Arrays;

public class Rectangle extends Shape {

    public Rectangle(Point p, String color) {
        super(p, color);
    }

    public Rectangle(ArrayList<Point> points, String color) {
        super(points, color);
    }

    public Rectangle(double x, double y, String color) {
        this(new Point(x, y), color);
    }

    public Rectangle(double x1, double y1, double x2, double y2, String color) {
        this(new ArrayList<Point>(Arrays.asList(
                new Point(x1, y1),
                new Point(x2, y2)))
            , color);
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
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.decode(getColor()));

        var startPoint = points.get(0);
        var endPoint = points.get(1);
        double x = Math.min(startPoint.getX(), endPoint.getX());
        double y = Math.min(startPoint.getY(), endPoint.getY());
        double width = getWidth();
        double height = getHeight();

        var rectangle = new java.awt.Rectangle.Double(x, y, width, height);
        g2.fill(rectangle);
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
