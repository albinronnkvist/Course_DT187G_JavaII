/**
* An abstaction class for shapes.
* This class is abstract and can't be instantiated on its own, it needs to be subclassed by another class to use its properties.
*
* It implements the Drawable interface and therefore have to implement all of its abstract methods 
*   - (Drawable doesn't contain any default or static methods).
* 
* It defines both concrete (with implementation) and abstract methods (without implementation).
*
* @author Albin Rönnkvist (alrn1700)
* @version 1.0
*/

package se.miun.alrn1700.dt187g.jpaint.classes;

import se.miun.alrn1700.dt187g.jpaint.interfaces.Drawable;


public abstract class Shape implements Drawable {
    private String color;
    protected Point[] points;

    public Shape(Point p, String color) {
        this.color = color;
        this.points = new Point[2];
        this.points[0] = p;
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

    public abstract void addPoint(Point p);

    public abstract void addPoint(double x, double y);

    public abstract boolean hasEndpoint();
}
