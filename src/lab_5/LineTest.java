package lab_5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void move_translatesEndpoints() {
        Line l = new Line(0,0, 1,1);
        l.move(2,3);
        assertEquals(new Point(2,3), l.getStart());
        assertEquals(new Point(3,4), l.getEnd());
    }

    @Test
    void equals_selfIsTrue() {
        Line l = new Line(0,0, 1,1);
        assertTrue(l.equals(l));
    }

    @Test
    void equals_nullOrOtherTypeIsFalse() {
        Line l = new Line(0,0, 1,1);
        assertFalse(l.equals(null));
        assertFalse(l.equals("not a line"));
    }

    @Test
    void flip_reflectsEndpoints() {
        Line l = new Line(1,2, 3,-4);
        l.flip();
        assertEquals(new Point(-1,-2), l.getStart());
        assertEquals(new Point(-3,4), l.getEnd());
    }

    @Test
    void rotate_180Degrees() {
        Line l = new Line(1,0, 0,1);
        l.rotate(180);
        assertEquals(new Point(-1,0), l.getStart());
        assertEquals(new Point(0,-1), l.getEnd());
    }

    @Test
    void rotate_90Degrees() {
        Line l = new Line(2,0, 0,2);
        l.rotate(90);
        assertEquals(new Point(0,2), l.getStart());
        assertEquals(new Point(-2,0), l.getEnd());
    }

    @Test
    void clone_deepCopy() {
        Line l = new Line(5,6,7,8);
        Line c = l.clone();
        assertEquals(l, c);
        assertNotSame(l, c);
        assertNotSame(l.getStart(), c.getStart());
    }

    @Test
    void toString_format() {
        Line l = new Line(0,0,1,1);
        assertEquals("Line[Point(0.0, 0.0) -> Point(1.0, 1.0)]", l.toString());
    }

    @Test
    void equals_detectsDifference() {
        Line a = new Line(0,0,1,1), b = new Line(0,0,2,2);
        assertNotEquals(a,b);
    }
}