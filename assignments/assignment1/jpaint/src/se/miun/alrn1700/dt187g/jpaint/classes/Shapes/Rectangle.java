package se.miun.alrn1700.dt187g.jpaint.classes.Shapes;

import java.awt.Graphics;

import se.miun.alrn1700.dt187g.jpaint.classes.Point;
import se.miun.alrn1700.dt187g.jpaint.classes.Shape;

/**
* TODO: explain
*
* @author Albin Rönnkvist (alrn1700)
* @version 1.0
*/

public class Rectangle extends Shape {

    public Rectangle(Point p, String color) {
        super(p, color);
    }

    public Rectangle(double x, double y, String color) {
        super(new Point(x, y), color);
    }

    // TODO: implement
    public double getWidth() {
        return 0;
    }

    // TODO: implement
    public double getHeight() {
        return 0;
    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

    @Override
    public double getCircumference() {
        throw new UnsupportedOperationException("Unimplemented method 'getCircumference'");
    }

    @Override
    public double getArea() {
        throw new UnsupportedOperationException("Unimplemented method 'getArea'");
    }

    @Override
    public void addPoint(Point p) {
        throw new UnsupportedOperationException("Unimplemented method 'addPoint'");
    }

    @Override
    public void addPoint(double x, double y) {
        throw new UnsupportedOperationException("Unimplemented method 'addPoint'");
    }

    @Override
    public boolean hasEndpoint() {
        throw new UnsupportedOperationException("Unimplemented method 'hasEndpoint'");
    }
}
