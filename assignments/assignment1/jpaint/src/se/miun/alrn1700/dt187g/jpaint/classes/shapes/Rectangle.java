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

    // TODO: implement
    public double getWidth() {
        return 0;
    }

    // TODO: implement
    public double getHeight() {
        return 0;
    }

    // TODO: implement
    @Override
    public void draw() {
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

    // TODO: implement
    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

    // TODO: implement
    @Override
    public double getCircumference() {
        throw new UnsupportedOperationException("Unimplemented method 'getCircumference'");
    }

    // TODO: implement
    @Override
    public double getArea() {
        throw new UnsupportedOperationException("Unimplemented method 'getArea'");
    }

    // TODO: implement
    @Override
    public void addPoint(Point p) {
        throw new UnsupportedOperationException("Unimplemented method 'addPoint'");
    }

    // TODO: implement
    @Override
    public void addPoint(double x, double y) {
        throw new UnsupportedOperationException("Unimplemented method 'addPoint'");
    }

    // TODO: implement
    @Override
    public boolean hasEndpoint() {
        throw new UnsupportedOperationException("Unimplemented method 'hasEndpoint'");
    }

    // TODO: implement
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }
}
