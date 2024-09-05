package se.miun.alrn1700.dt187g.jpaint;

import se.miun.alrn1700.dt187g.jpaint.classes.Point;
import se.miun.alrn1700.dt187g.jpaint.classes.Shape;
import se.miun.alrn1700.dt187g.jpaint.classes.shapes.Circle;
import se.miun.alrn1700.dt187g.jpaint.classes.shapes.Rectangle;

/**
* Manual tests for the Rectangle and Circle classes.
*
* @author Albin Rönnkvist (alrn1700)
* @version 1.0
*/


public class App {
    public static void main(String[] args) {
		testRectangle();
		System.out.println(); // new line
		testCircle();
	}

	private static void testRectangle() {
		// Create two rectangles. Store one as a Rectangle and
		// one as a Shape. Draw them.
		Rectangle r1 = new Rectangle(new Point(0, 0),  "#0000ff");  // blue
		Shape s1 = new Rectangle(2, -5, "#ff0000"); // red
		System.out.println("Drawing two newly created rectangles...");
		r1.draw();
		s1.draw();
		
		// Print the area of the rectangle
		System.out.println("\nThe area of the rectangle is: " + r1.getArea());
		
		// Add end points to the rectangles and draw them again
		Point p1 = new Point(10, 10);
		System.out.println("\nAdding " + p1 + " as end point to the two rectangles...");
		r1.addPoint(p1);
		s1.addPoint(p1);
		r1.draw();
		s1.draw();
		
		// Set new end point to rectangle r1 by calling addPoint with a 
		// new value and then print the new width
		r1.addPoint(5, 5);
		double widthR1 = r1.getWidth();
		System.out.println("\nChanging end point of r1 to [5.0, 5.0]...");
		System.out.println("The width of r1 is now: " + widthR1); // 5.0
		
		// It is not possible to call getWidth/Height on s1 since it is stored 
		// as an Shape. We first need to cast it to a Rectangle
		Rectangle r2 = (Rectangle) s1;
		System.out.println("\nCasting Shape s1 to a Rectangle (r2)...");
		System.out.println("The height of r2 (s1) is: " + r2.getHeight()); // 15.0
		
		// Change end point on s1. Will r2 change as well???
		System.out.println("\nChanging end point of s1 to (12.0, 0.0)...");
		s1.addPoint(12, 0);
		s1.draw();
		r2.draw();
		
		// Print circumference and area of rectangle s1
		System.out.println("\nThe circumference of s1 is: " + s1.getCircumference()); // 30.0
		System.out.println("The area of s1 is: " + s1.getArea()); // 50.0
	}
	
	private static void testCircle() {
		// Create a circle and store it as a Shape. Draw it.
		Shape s1 = new Circle(3, 3, "#000000"); // black
		System.out.println("Drawing a newly created circle...");
		s1.draw();
		
		// Add a end point to the circle and draw it again
		Point p1 = new Point(-1, 6);
		System.out.println("\nAdding " + p1 + " as end point to shape s1...");
		s1.addPoint(p1);
		s1.draw();
		
		// Print circumference and area of rectangle s1
		System.out.println("\nThe circumference of s1 is: " + s1.getCircumference()); // 31.4
		System.out.println("The area of s1 is: " + s1.getArea()); // 78.5
		
		// Set new end point to shape s1 by calling addPoint with a 
		// new value and then print the new radius (by doing a cast)
		s1.addPoint(3, -7);
		// double radiusS1 = s1.getRadius(); // will not work
		
		double radiusS1 = ((Circle) s1).getRadius();
		System.out.println("\nChanging end point of s1 to [5.0, 15.0]...");
		System.out.println("The radius of s1 is now: " + radiusS1); // 10.0
		String oldColor = s1.getColor();
		s1.setColor("#123456");
		System.out.println("\nChanging color of s1...");
		System.out.println("Old color was "+ oldColor +" and new color is " + s1.getColor());
	}
}
