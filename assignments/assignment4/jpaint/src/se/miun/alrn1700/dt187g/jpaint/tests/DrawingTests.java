package se.miun.alrn1700.dt187g.jpaint.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import se.miun.alrn1700.dt187g.jpaint.Drawing;
import se.miun.alrn1700.dt187g.jpaint.geometry.Circle;
import se.miun.alrn1700.dt187g.jpaint.geometry.Point;
import se.miun.alrn1700.dt187g.jpaint.geometry.Rectangle;

public class DrawingTests {
    @Test
    public void testAddShape() {
        var drawing = new Drawing("My Drawing", "Author Name");
        var shape = new Circle(new Point(1, 1), "#FFFFFF");

        drawing.addShape(shape);

        assertThat(drawing.getSize()).isEqualTo(1);
    }

    @Test
    public void testAddNullShape() {
        var drawing = new Drawing("My Drawing", "Author Name");

        drawing.addShape(null);

        assertThat(drawing.getSize()).isEqualTo(0);
    }

    @Test
    public void testGetSizeWithoutShapes() {
        var drawing = new Drawing("My Drawing", "Author Name");

        assertThat(drawing.getSize()).isEqualTo(0);
    }

    @Test
    public void testGetTotalCircumference() {
        var drawing = new Drawing("My Drawing", "Author Name");
        var circle = new Circle(new Point(0, 0), "#FFFFFF");
        circle.addPoint(new Point(3, 4));
        final double expectedCircleCircumference = 31.4159265;

        var rectangle = new Rectangle(new Point(0, 0), "#FFFFFF");
        rectangle.addPoint(new Point(1, 5));
        final double expectedRectangleCircumference = 12;
        
        drawing.addShape(circle);
        drawing.addShape(rectangle);

        double expectedTotalCircumference = expectedCircleCircumference + expectedRectangleCircumference;
        assertThat(drawing.getTotalCircumference()).isEqualTo(expectedTotalCircumference);
    }

    @Test
    public void testGetTotalCircumferenceWithoutEndpoints() {
        var drawing = new Drawing("My Drawing", "Author Name");
        var circle = new Circle(new Point(1, 1), "#FFFFFF");
        var rectangle = new Rectangle(new Point(0, 0), "#FFFFFF");
        
        drawing.addShape(circle);
        drawing.addShape(rectangle);

        assertThat(drawing.getTotalCircumference()).isEqualTo(0);
    }

    @Test
    public void testGetTotalArea() {
        var drawing = new Drawing("My Drawing", "Author Name");
        var circle = new Circle(new Point(0, 0), "#FFFFFF");
        circle.addPoint(new Point(3, 4));
        final double expectedCircleArea = 78.53981625;

        var rectangle = new Rectangle(new Point(0, 0), "#FFFFFF");
        rectangle.addPoint(new Point(1, 5));
        final double expectedRectangleArea = 5;
        
        drawing.addShape(circle);
        drawing.addShape(rectangle);

        double expectedTotalArea = expectedCircleArea + expectedRectangleArea;
        assertThat(drawing.getTotalArea()).isEqualTo(expectedTotalArea);
    }

    @Test
    public void testGetTotalAreWithoutEndpoints() {
        var drawing = new Drawing("My Drawing", "Author Name");
        var circle = new Circle(new Point(1, 1), "#FFFFFF");
        var rectangle = new Rectangle(new Point(0, 0), "#FFFFFF");
        
        drawing.addShape(circle);
        drawing.addShape(rectangle);

        assertThat(drawing.getTotalArea()).isEqualTo(0);
    }

    @Test
    public void testToStringWithAllValues() {
        var drawing = new Drawing("My Drawing", "Author Name");
        var circle = new Circle(new Point(0, 0), "#FFFFFF");
        circle.addPoint(new Point(3, 4));
        final double expectedCircleCircumference = 31.4159265;
        final double expectedCircleArea = 78.53981625;

        var rectangle = new Rectangle(new Point(0, 0), "#FFFFFF");
        rectangle.addPoint(new Point(1, 5));
        final double expectedRectangleCircumference = 12;
        final double expectedRectangleArea = 5;

        drawing.addShape(circle);
        drawing.addShape(rectangle);

        var expectedTotalCircumference = expectedCircleCircumference + expectedRectangleCircumference;
        var expectedTotalArea = expectedCircleArea + expectedRectangleArea;
        var expectedString = "Drawing[name: My Drawing; author: Author Name; size: 2; circumference: " + expectedTotalCircumference + "; area: " + expectedTotalArea + "]";
        assertThat(drawing.toString()).isEqualTo(expectedString);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "   "})
    public void testToStringWithMissingValues(String value) {
        var drawing = new Drawing(value, value);
        var circle = new Circle(new Point(0, 0), "#FFFFFF");
        var rectangle = new Rectangle(new Point(0, 0), "#FFFFFF");

        drawing.addShape(circle);
        drawing.addShape(rectangle);

        var expectedString = String.format("Drawing[name: ; author: ; size: 2; circumference: 0.0; area: 0.0]");
        assertThat(drawing.toString()).isEqualTo(expectedString);
    }
}
