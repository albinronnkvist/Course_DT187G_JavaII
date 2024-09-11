package se.miun.alrn1700.dt187g.jpaint.tests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import se.miun.alrn1700.dt187g.jpaint.Circle;
import se.miun.alrn1700.dt187g.jpaint.Point;
import static org.assertj.core.api.Assertions.*;

public class CircleTests {
    @Test
    public void testAddPointWithPoint() {
        var circle = new Circle(new Point(1, 1), "Red");
        circle.addPoint(new Point(2, 2));

        assertThat(circle.hasEndpoint()).isTrue();
    }

    @Test
    public void testAddPointWithCoordinates() {
        var circle = new Circle(new Point(1, 1), "Red");
        circle.addPoint(2, 2);

        assertThat(circle.hasEndpoint()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    public void testHasEndpoint(boolean endPointAdded) {
        var circle = new Circle(new Point(1, 1), "Red");

        var hasEndpointBefore = circle.hasEndpoint();
        if (endPointAdded) {
            circle.addPoint(2, 2);
        }

        assertThat(hasEndpointBefore).isFalse();
        assertThat(circle.hasEndpoint()).isEqualTo(endPointAdded);
    }

    @Test
    public void testGetRadiusWhenNoEndPoint() {
        var circle = new Circle(new Point(1, 1), "Green");
        assertThat(circle.getRadius()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0, 3, 4, 5",
        "3, 3, -1, 6, 5",
        "5, 15, -1, 6, 10.816653826391969",
    })
    public void testGetRadius(double centerPointX, double centerPointY, double edgePointX, double edgePointY, double expectedRadius) {
        var centerPoint = new Point(centerPointX, centerPointY);
        var edgePoint = new Point(edgePointX, edgePointY);
        var circle = new Circle(centerPoint, "Green");
        circle.addPoint(edgePoint);

        assertThat(circle.getRadius()).isEqualTo(expectedRadius);
    }

    @Test
    public void testGetCircumferenceWhenNoEndPoint() {
        var startPoint = new Point(1, 1);
        var circle = new Circle(startPoint, "Red");
        
        assertThat(circle.getCircumference()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0, 3, 4, 31.4159265",
        "3, 3, -1, 6, 31.4159265",
        "5, 15, -1, 6, 67.96304031717477",
    })
    public void testGetCircumference(double centerPointX, double centerPointY, double edgePointX, double edgePointY, double expectedCircumference) {
        var centerPoint = new Point(centerPointX, centerPointY);
        var edgePoint = new Point(edgePointX, edgePointY);
        var circle = new Circle(centerPoint, "Green");
        circle.addPoint(edgePoint);
        
        assertThat(circle.getCircumference()).isEqualTo(expectedCircumference);
    }

    @Test
    public void testGetAreaWhenNoEndPoint() {
        var startPoint = new Point(1, 1);
        var circle = new Circle(startPoint, "Red");
        
        assertThat(circle.getArea()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0, 3, 4, 78.53981625",
        "3, 3, -1, 6, 78.53981625",
        "5, 15, -1, 6, 367.56634005000006",
    })
    public void testGetArea(double centerPointX, double centerPointY, double edgePointX, double edgePointY, double expectedArea) {
        var centerPoint = new Point(centerPointX, centerPointY);
        var edgePoint = new Point(edgePointX, edgePointY);
        var circle = new Circle(centerPoint, "Green");
        circle.addPoint(edgePoint);
        
        assertThat(circle.getArea()).isEqualTo(expectedArea);
    }

    @Test
    public void testDraw() {
        var startPoint = new Point(0, 0);
        var endPoint = new Point(3, 4);
        var circle = new Circle(startPoint, "Red");
        circle.addPoint(endPoint);
        
        try {
            final var outContent = new ByteArrayOutputStream(); // Custom output stream
            System.setOut(new PrintStream(outContent)); // Reassign to custom output stream

            circle.draw();

            assertThat(outContent.toString())
                .contains("Circle[start=[0.0, 0.0]; end=[3.0, 4.0]; radius=5.0; color=Red]");
        } finally {
            System.setOut(System.out); // Restore to standard output stream
        }
    }

    @Test
    public void testToStringAllValuesPresent() {
        var startPoint = new Point(0, 0);
        var endPoint = new Point(3, 4);
        var circle = new Circle(startPoint, "#0000ff");
        circle.addPoint(endPoint);
        
        String result = circle.toString();
        
        assertThat(result)
            .isEqualTo("Circle[start=[0.0, 0.0]; end=[3.0, 4.0]; radius=5.0; color=#0000ff]");
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "   "})
    public void testToStringWithMissingValues(String color) {
        var startPoint = new Point(2.0, -5.0);
        var circle = new Circle(startPoint, color);
        
        String result = circle.toString();
        
        assertThat(result)
            .isEqualTo("Circle[start=[2.0, -5.0]; end=N/A; radius=N/A; color=N/A]");
    }

}
