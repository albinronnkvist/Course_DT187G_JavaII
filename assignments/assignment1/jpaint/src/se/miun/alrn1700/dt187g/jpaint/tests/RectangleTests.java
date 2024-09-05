package se.miun.alrn1700.dt187g.jpaint.tests;

import se.miun.alrn1700.dt187g.jpaint.classes.Point;
import se.miun.alrn1700.dt187g.jpaint.classes.shapes.Rectangle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RectangleTests {
    @Test
    public void testAddPointWithPoint() {
        var rectangle = new Rectangle(new Point(1, 1), "Red");
        rectangle.addPoint(new Point(2, 2));

        assertThat(rectangle.getWidth()).isEqualTo(1);
    }

    @Test
    public void testAddPointWithCoordinates() {
        var rectangle = new Rectangle(new Point(1, 1), "Red");
        rectangle.addPoint(2, 2);
    }

    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    public void testHasEndpoint(boolean endPointAdded) {
        var rectangle = new Rectangle(new Point(1, 1), "Red");

        if (endPointAdded) {
            rectangle.addPoint(2, 2);
        }

        assertThat(rectangle.hasEndpoint()).isEqualTo(endPointAdded);
    }

    @Test
    public void testGetWidthWhenNoEndPoint() {
        var rectangle = new Rectangle(new Point(1, 1), "Green");
        assertThat(rectangle.getWidth()).isEqualTo(0);
    }

    @Test
    public void testGetHeightWhenNoEndPoint() {
        var rectangle = new Rectangle(new Point(1, 1), "Green");
        assertThat(rectangle.getHeight()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({
        "1, 5, 4",      // positive numbers
        "5, 1, 4",      // positive numbers, reversed order
        "-5, -1, 4",    // negative numbers
        "-1, -5, 4",    // negative numbers, reversed order
        "-1, 5, 6",     // mixed negative and positive numbers
        "5, -1, 6",     // mixed negative and positive numbers, reversed order
        "1, 1, 0",      // same points
        "0, 0, 0"       // both points at zero
    })
    public void testGetWidth(double startPointX, double endPointX, double expectedWidth) {
        var startPoint = new Point(startPointX, 0);
        var endPoint = new Point(endPointX, 0);
        var rectangle = new Rectangle(startPoint, "Black");
        rectangle.addPoint(endPoint);
        
        assertThat(expectedWidth).isEqualTo(rectangle.getWidth());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 5, 4",        // positive numbers
        "5, 1, 4",        // positive numbers, reversed order
        "1.5, 5.5, 4",    // positive numbers, with decimals
        "-5, -1, 4",      // negative numbers
        "-5.3, -1.3, 4",  // negative numbers, with decimals
        "-1, -5, 4",      // negative numbers, reversed order
        "-1, 5, 6",       // mixed negative and positive numbers
        "5, -1, 6",       // mixed negative and positive numbers, reversed order
        "1, 1, 0",        // same points
        "0, 0, 0"         // both points at zero
    })
    public void testGetHeight(double startPointY, double endPointY, double expectedHeight) {
        var startPoint = new Point(0, startPointY);
        var endPoint = new Point(0, endPointY);
        var rectangle = new Rectangle(startPoint, "Black");
        rectangle.addPoint(endPoint);

        assertThat(expectedHeight).isEqualTo(rectangle.getHeight());
    }

    @Test
    public void testToStringAllValuesPresent() {
        var startPoint = new Point(0.0, 0.0);
        var endPoint = new Point(10.0, 10.0);
        var rectangle = new Rectangle(startPoint, "#0000ff");
        rectangle.addPoint(endPoint);
        
        String result = rectangle.toString();
        
        assertThat(result)
            .isEqualTo("Rectangle[start=[0.0, 0.0] end=[10.0, 10.0] width=10.0 height=10.0 color=#0000ff]");
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "   "})
    public void testToStringWithMissingValues(String color) {
        var startPoint = new Point(2.0, -5.0);
        var rectangle = new Rectangle(startPoint, color);
        
        String result = rectangle.toString();
        
        assertThat(result)
            .isEqualTo("Rectangle[start=[2.0, -5.0] end=N/A width=N/A height=N/A color=N/A]");
    }

    @Test
    public void testDraw() {
        var startPoint = new Point(1.7, 1.5);
        var endPoint = new Point(-5, 5);
        var rectangle = new Rectangle(startPoint, "Red");
        rectangle.addPoint(endPoint);
        
        try {
            final var outContent = new ByteArrayOutputStream(); // Custom output stream
            System.setOut(new PrintStream(outContent)); // Reassign to custom output stream

            rectangle.draw();

            assertThat(outContent.toString())
                .contains("Rectangle[start=[1.7, 1.5] end=[-5.0, 5.0] width=6.7 height=3.5 color=Red]");
        } finally {
            System.setOut(System.out); // Restore to standard output stream
        }
    }

    @Test
    public void getCircumferenceWhenNoEndPoint() {
        var startPoint = new Point(1, 1);
        var rectangle = new Rectangle(startPoint, "Red");
        
        assertThat(rectangle.getCircumference()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({
        "1, 5, 12",
        "5, 1, 12",
        "1.5, 5.5, 14",
        "0, 0, 0"
    })
    public void getCircumference(double width, double height, double expectedCircumference) {
        var startPoint = new Point(0, 0);
        var endPoint = new Point(width, height);
        var rectangle = new Rectangle(startPoint, "Red");
        rectangle.addPoint(endPoint);
        
        assertThat(rectangle.getCircumference()).isEqualTo(expectedCircumference);
    }

    @Test
    public void getAreaWhenNoEndPoint() {
        var startPoint = new Point(1, 1);
        var rectangle = new Rectangle(startPoint, "Red");
        
        assertThat(rectangle.getArea()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({
        "5, 3, 15",
        "7.5, 2.5, 18.75",
        "0, 0, 0"
    })
    public void getArea(double width, double height, double expectedArea) {
        var startPoint = new Point(0, 0);
        var endPoint = new Point(width, height);
        var rectangle = new Rectangle(startPoint, "Red");
        rectangle.addPoint(endPoint);
        
        assertThat(rectangle.getArea()).isEqualTo(expectedArea);
    }
}
