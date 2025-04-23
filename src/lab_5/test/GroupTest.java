package lab_5.test;

import lab_5.Group;
import lab_5.Line;
import lab_5.Point;
import lab_5.Polygon;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    @Test
    void rotate_group_90Degrees() {
        Group g = new Group();
        g.add(new Point(1,0));
        g.add(new Line(1,0, 0,1));
        g.rotate(90);
        assertEquals(new Point(0,1), g.getFigures().get(0));
        Line l = (Line)g.getFigures().get(1);
        assertEquals(new Point(0,1), l.getStart());
        assertEquals(new Point(-1,0), l.getEnd());
    }

    @Test
    void rotate_group_45Degrees() {
        Group g = new Group();
        g.add(new Point(1,1));
        g.add(new Polygon(List.of(
                new Point(1,0), new Point(0,1), new Point(-1,0)
        )));
        g.rotate(45);
        // sprawdź tylko pierwszy element:
        assertEquals(new Point(0.0, 1.414), g.getFigures().get(0));
        Polygon p = (Polygon)g.getFigures().get(1);
        assertEquals(new Point(0.707, 0.707), p.getVertices().get(0));
    }



    @Test
    void move_movesAllMembers() {
        Group g = new Group();
        g.add(new Point(1,1));
        g.add(new Line(0,0, 1,0));
        g.move(2,3);
        assertEquals(new Point(3,4), g.getFigures().get(0));
        Line l = (Line)g.getFigures().get(1);
        assertEquals(new Point(2,3), l.getStart());
    }

    @Test
    void flip_flipsAllMembers() {
        Group g = new Group();
        g.add(new Point(1,2));
        g.add(new Line(1,1, 2,2));
        g.flip();
        assertEquals(new Point(-1,-2), g.getFigures().get(0));
        Line l = (Line)g.getFigures().get(1);
        assertEquals(new Point(-1,-1), l.getStart());
    }

    @Test
    void clone_createsDeepCopyOfAll() {
        Group g = new Group();
        g.add(new Point(0,0));
        g.add(new Line(0,0, 1,1));
        Group c = g.clone();
        assertEquals(g, c);
        assertNotSame(g, c);
        // sprawdź, że pod-figury też są inne instancje
        assertNotSame(g.getFigures().get(0), c.getFigures().get(0));
    }

    @Test
    void toString_combinesAllFigures() {
        Group g = new Group();
        g.add(new Point(0,0));
        g.add(new Line(0,0,1,1));
        String s = g.toString();
        assertTrue(s.startsWith("Group[") && s.contains("Point(0.0, 0.0)")
                && s.contains("Line["));
    }

    @Test
    void equals_detectsDifferentGroups() {
        Group g1 = new Group();
        g1.add(new Point(0,0));
        Group g2 = new Group();
        g2.add(new Point(1,1));
        assertNotEquals(g1, g2);
    }


}
