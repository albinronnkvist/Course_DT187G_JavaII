package se.miun.alrn1700.dt187g.jpaint.tests;

import org.junit.jupiter.api.Test;
import se.miun.alrn1700.dt187g.jpaint.classes.Point;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTests {

    @Test
    public void testDefaultConstructor() {
        Point point = new Point();
        assertThat(point.getX()).isEqualTo(0.0);
        assertThat(point.getY()).isEqualTo(0.0);
    }

    @Test
    public void testParameterizedConstructor() {
        final double x = 1.0;
        final double y = 2.0;

        Point point = new Point(x, y);
        assertThat(point.getX()).isEqualTo(x);
        assertThat(point.getY()).isEqualTo(y);
    }

    @Test
    public void testSetX() {
        Point point = new Point();

        final double x = 5.5;
        point.setX(x);
        assertThat(point.getX()).isEqualTo(x);
    }

    @Test
    public void testSetY() {
        Point point = new Point();

        final double y = 7.5;
        point.setY(y);
        assertThat(point.getY()).isEqualTo(y);
    }

    @Test
    public void testToString() {
        Point point = new Point(1.5, 2.5);
        assertThat(point.toString()).isEqualTo("[1.5, 2.5]");
    }
}
