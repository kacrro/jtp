package lab_5.test;

import lab_5.Point;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void rotate_90Degrees() {
        Point p = new Point(1, 0);
        p.rotate(90);
        assertEquals(new Point(0.0,1.0), p);
    }

    @Test
    void rotate_45Degrees() {
        Point p = new Point(1,1);
        p.rotate(45);
        // 1,1 rotated 45º -> (0, 1.4142...) and (1.4142..., 0) but around origin formula
        // Actually (x cos - y sin, x sin + y cos) = (1*√2/2 - 1*√2/2, ...) = (0, √2)
        assertEquals(new Point(0.0, 1.414), p);
    }


    @Test
    void move_changesCoordinates() {
        Point p = new Point(1, 2);
        p.move(3, -1);
        assertEquals(4.0, p.getX());
        assertEquals(1.0, p.getY());
    }

    @Test
    void flip_negatesCoordinates() {
        Point p = new Point(-5, 7);
        p.flip();
        assertEquals(5.0, p.getX());
        assertEquals(-7.0, p.getY());
    }

    @Test
    void clone_createsEqualButDistinct() {
        Point p = new Point(2, 3);
        Point c = p.clone();
        assertEquals(p, c);
        assertNotSame(p, c);
    }

    @Test
    void toString_returnsCorrectFormat() {
        Point p = new Point(0.5, -1.25);
        assertEquals("Point(0.5, -1.25)", p.toString());
    }

    @Test
    void equals_detectsInequality() {
        Point p1 = new Point(1,1), p2 = new Point(1,2);
        assertNotEquals(p1, p2);
    }
}
