package lab_5.test;

import lab_5.Line;
import lab_5.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void rotate_line_180Degrees() {
        Line l = new Line(1,0, 0,1);
        l.rotate(180);
        assertEquals(new Point(-1,0), l.getStart());
        assertEquals(new Point(0,-1), l.getEnd());
    }

    @Test
    void rotate_line_90Degrees() {
        Line l = new Line(2,0, 0,2);
        l.rotate(90);
        assertEquals(new Point(0,2), l.getStart());
        assertEquals(new Point(-2,0), l.getEnd());
    }


    @Test
    void move_translatesBothEndpoints() {
        Line l = new Line(0,0, 1,1);
        l.move(2,3);
        Assertions.assertEquals(new Point(2,3), l.getStart());
        assertEquals(new Point(3,4), l.getEnd());
    }

    @Test
    void flip_reflectsEndpoints() {
        Line l = new Line(1,2, 3,-4);
        l.flip();
        assertEquals(new Point(-1,-2), l.getStart());
        assertEquals(new Point(-3,4), l.getEnd());
    }

    @Test
    void clone_createsDeepCopy() {
        Line l = new Line(5,6, 7,8);
        Line c = l.clone();
        assertEquals(l, c);
        assertNotSame(l, c);
        // upewnij się, że punkty też są różne instancje
        assertNotSame(l.getStart(), c.getStart());
    }

    @Test
    void toString_formatIsCorrect() {
        Line l = new Line(0,0, 1,1);
        assertEquals("Line[Point(0.0, 0.0) -> Point(1.0, 1.0)]", l.toString());
    }

    @Test
    void equals_detectsDifferentLines() {
        Line a = new Line(0,0, 1,1);
        Line b = new Line(0,0, 2,2);
        assertNotEquals(a, b);
    }
}
