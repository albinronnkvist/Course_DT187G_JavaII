package se.miun.alrn1700.dt187g.jpaint.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import se.miun.alrn1700.dt187g.jpaint.Drawing;
import se.miun.alrn1700.dt187g.jpaint.DrawingException;
import se.miun.alrn1700.dt187g.jpaint.geometry.Circle;
import se.miun.alrn1700.dt187g.jpaint.geometry.Point;
import se.miun.alrn1700.dt187g.jpaint.geometry.Rectangle;

public class DrawingTests {
    private static Stream<Object[]> invalidDrawingArgumentsConstructor() {
        return Stream.of(
            new Object[]{null, "Author"},          // Null name
            new Object[]{"My Drawing", null},      // Null author
            new Object[]{"", "Author"},            // Blank name
            new Object[]{"My Drawing", ""},        // Blank author
            new Object[]{"", ""},                  // Both name and author are blank
            new Object[]{null, null}               // Both name and author are null
        );
    }
    @ParameterizedTest
    @MethodSource("invalidDrawingArgumentsConstructor")
    public void testInvalidDrawingCreation(String name, String author) {
        assertThatThrownBy(() -> new Drawing(name, author))
            .isInstanceOf(DrawingException.class)
            .hasMessageContaining("Drawing name and author can't be null or empty");
    }

    private static Stream<Object[]> invalidDrawingArgumentsSetters() {
        return Stream.of(
            new Object[]{null},
            new Object[]{""}
        );
    }
    @ParameterizedTest
    @MethodSource("invalidDrawingArgumentsSetters")
    public void testSetNameThrowsException(String name) throws DrawingException {
        Drawing drawing = new Drawing("Valid Name", "Valid Author");

        assertThatThrownBy(() -> drawing.setName(name))
            .isInstanceOf(DrawingException.class)
            .hasMessageContaining(name == null ? "Drawing name can't be null" : "Drawing name can't be empty");
    }

    @ParameterizedTest
    @MethodSource("invalidDrawingArgumentsSetters")
    public void testSetAuthorThrowsException(String author) throws DrawingException {
        Drawing drawing = new Drawing("Valid author", "Valid Author");

        assertThatThrownBy(() -> drawing.setAuthor(author))
            .isInstanceOf(DrawingException.class)
            .hasMessageContaining(author == null ? "Drawing author can't be null" : "Drawing author can't be empty");
    }

    @Test
    public void testAddShape() throws DrawingException {
        var drawing = new Drawing("My Drawing", "Author Name");
        var shape = new Circle(new Point(1, 1), "#FFFFFF");

        drawing.addShape(shape);

        assertThat(drawing.getSize()).isEqualTo(1);
    }

    @Test
    public void testAddNullShape() throws DrawingException {
        var drawing = new Drawing("My Drawing", "Author Name");

        drawing.addShape(null);

        assertThat(drawing.getSize()).isEqualTo(0);
    }

    @Test
    public void testRemoveShape() throws DrawingException {
        var drawing = new Drawing("My Drawing", "Author Name");
        var shape = new Circle(new Point(1, 1), "#FFFFFF");
        drawing.addShape(shape);

        drawing.removeShape(0);

        assertThat(drawing.getSize()).isEqualTo(0);
    }

    @Test
    public void testRemoveShape_InvalidIndex_IgnoresRemovalAttempt() throws DrawingException {
        var drawing = new Drawing("My Drawing", "Author Name");
        var shape = new Circle(new Point(1, 1), "#FFFFFF");
        drawing.addShape(shape);

        drawing.removeShape(-1);
        drawing.removeShape(3);

        assertThat(drawing.getSize()).isEqualTo(1);
    }

    @Test
    public void testRemoveShape_EmptyList() throws DrawingException {
        var drawing = new Drawing("My Drawing", "Author Name");

        drawing.removeShape(0);

        assertThat(drawing.getSize()).isEqualTo(0);
    }

    @Test
    public void testGetSizeWithoutShapes() throws DrawingException {
        var drawing = new Drawing("My Drawing", "Author Name");

        assertThat(drawing.getSize()).isEqualTo(0);
    }

    @Test
    public void testGetTotalCircumference() throws DrawingException {
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
    public void testGetTotalCircumferenceWithoutEndpoints() throws DrawingException {
        var drawing = new Drawing("My Drawing", "Author Name");
        var circle = new Circle(new Point(1, 1), "#FFFFFF");
        var rectangle = new Rectangle(new Point(0, 0), "#FFFFFF");
        
        drawing.addShape(circle);
        drawing.addShape(rectangle);

        assertThat(drawing.getTotalCircumference()).isEqualTo(0);
    }

    @Test
    public void testGetTotalArea() throws DrawingException {
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
    public void testGetTotalAreWithoutEndpoints() throws DrawingException {
        var drawing = new Drawing("My Drawing", "Author Name");
        var circle = new Circle(new Point(1, 1), "#FFFFFF");
        var rectangle = new Rectangle(new Point(0, 0), "#FFFFFF");
        
        drawing.addShape(circle);
        drawing.addShape(rectangle);

        assertThat(drawing.getTotalArea()).isEqualTo(0);
    }

    @Test
    public void testToStringWithAllValues() throws DrawingException {
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
}
