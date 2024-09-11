package se.miun.alrn1700.dt187g.jpaint.geometry;
/**
* A class which represents a Point in 2D space with x and y coordinates.
*
* The class uses encapsulation to hide the implementation details of the x and y coordinates.
*   - The instance variables are private and cannot be accessed from outside the class.
*   - It provides getter and setter methods to access and modify the private x and y coordinates.
*
* It has two constructors:
*   - A default constructor which sets the x and y coordinates to 0.
*     We have to explicitly define a default constructor, since we have another explicitly defined constructor, and a default constructor is not provided by the compiler in that case.
*   - A parameterized constructor which takes two arguments: x and y coordinates.
*
* It also overrides the toString() method to return a custom string representation of the point.
*   - All classes inherits from the Object class, which is where the default toString() method is defined.
*
* @author Albin Rönnkvist (alrn1700)
* @version 1.0
*/

public class Point {
    private double x;
    private double y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
