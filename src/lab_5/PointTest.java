package lab_5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void move_changesCoordinates() {
        Point p = new Point(1.0, 2.0);
        p.move(3.0, -1.0);
        assertEquals(4.0, p.getX());
        assertEquals(1.0, p.getY());
    }

    @Test
    void equals_selfAndNull() {
        Point p = new Point(1,2);
        assertTrue(p.equals(p));
        assertFalse(p.equals(null));
        assertFalse(p.equals("foo"));
    }

    @Test
    void flip_negatesCoordinatesAndNormalizesZero() {
        Point p = new Point(0.0, 0.0);
        p.flip();
        assertEquals(0.0, p.getX());
        assertEquals(0.0, p.getY());
    }

    @Test
    void rotate_90Degrees() {
        Point p = new Point(1.0, 0.0);
        p.rotate(90.0);
        assertEquals(new Point(0.0, 1.0), p);
    }

    @Test
    void rotate_45Degrees() {
        Point p = new Point(1.0, 1.0);
        p.rotate(45.0);
        assertEquals(new Point(0.0, 1.414), p);
    }

    @Test
    void clone_createsEqualButDistinct() {
        Point p = new Point(2.5, -3.5);
        Point c = p.clone();
        assertEquals(p, c);
        assertNotSame(p, c);
    }

    @Test
    void toString_format() {
        Point p = new Point(0.5, -1.25);
        assertEquals("Point(0.5, -1.25)", p.toString());
    }

    @Test
    void equals_detectsInequality() {
        Point p1 = new Point(1,1), p2 = new Point(1,2);
        assertNotEquals(p1, p2);
    }
}