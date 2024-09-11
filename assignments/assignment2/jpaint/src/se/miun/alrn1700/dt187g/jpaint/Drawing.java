package se.miun.alrn1700.dt187g.jpaint;
/*
* A class which represents a drawing. It can draw shapes.
*
* @author Albin Rönnkvist (alrn1700)
* @version 1.0
*/

import java.awt.Graphics;
import java.util.ArrayList;

import se.miun.alrn1700.dt187g.jpaint.geometry.Shape;

public class Drawing implements Drawable {

    private String name;
    private String author;
    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    public Drawing() {
    }

    public Drawing(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void addShape(Shape shape) {
        if(shape != null)
        {
            this.shapes.add(shape);
        }
    }

    public int getSize() {
        return this.shapes.size();
    }

    public double getTotalCircumference() {
        var totalCircumference = 0d;
        for (var shape : shapes) {
            totalCircumference += shape.getCircumference();
        }

        return totalCircumference;
    }

    public double getTotalArea() {
        var totalArea = 0d;
        for (var shape : shapes) {
            totalArea += shape.getArea();
        }

        return totalArea;
    }

    @Override
    public void draw() {
        System.out.println("A drawing by " + author + " called " + name);
        for (var shape : shapes) {
            System.out.println("Drawing a " + shape.toString());
        }
    }

    // Implement in another assignment
    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

    @Override
    public String toString() {
        var name = this.name != null && !this.name.trim().isEmpty() ? this.name : "";
        var author = this.author != null && !this.author.trim().isEmpty() ? this.author : "";

        var drawingInfo = new StringBuilder();
        drawingInfo.append("Drawing[");
        drawingInfo.append("name: " + name + ";"); 
        drawingInfo.append(" author: " + author + ";");
        drawingInfo.append(" size: " + getSize() + ";");
        drawingInfo.append(" circumference: " + getTotalCircumference() + ";");
        drawingInfo.append(" area: " + getTotalArea());
        drawingInfo.append("]");

        return drawingInfo.toString();
    }
}
