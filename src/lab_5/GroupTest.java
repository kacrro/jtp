package lab_5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class GroupTest {

    @Test
    void move_movesAll() {
        Group g = new Group();
        g.add(new Point(1,1));
        g.add(new Line(0,0,1,0));
        g.move(2,3);
        assertEquals(new Point(3,4), g.getFigures().get(0));
        Line l = (Line)g.getFigures().get(1);
        assertEquals(new Point(2,3), l.getStart());
    }

    @Test
    void equals_selfAndNullAndOtherType() {
        Group g = new Group();
        assertTrue(g.equals(g));
        assertFalse(g.equals(null));
        assertFalse(g.equals("foo"));
    }

    @Test
    void flip_flipsAll() {
        Group g = new Group();
        g.add(new Point(1,2));
        g.add(new Line(1,1,2,2));
        g.flip();
        assertEquals(new Point(-1,-2), g.getFigures().get(0));
        Line l = (Line)g.getFigures().get(1);
        assertEquals(new Point(-1,-1), l.getStart());
    }

    @Test
    void rotate_group_90() {
        Group g = new Group();
        g.add(new Point(1,0));
        g.add(new Line(1,0,0,1));
        g.rotate(90);
        assertEquals(new Point(0,1), g.getFigures().get(0));
        Line l = (Line)g.getFigures().get(1);
        assertEquals(new Point(0,1), l.getStart());
        assertEquals(new Point(-1,0), l.getEnd());
    }

    @Test
    void rotate_group_45() {
        Group g = new Group();
        g.add(new Point(1,1));
        g.rotate(45);
        assertEquals(new Point(0.0,1.414), g.getFigures().get(0));
    }

    @Test
    void clone_deepCopy() {
        Group g = new Group();
        g.add(new Point(0,0));
        g.add(new Line(0,0,1,1));
        Group c = g.clone();
        assertEquals(g,c);
        assertNotSame(g,c);
        assertNotSame(g.getFigures().get(0), c.getFigures().get(0));
    }

    @Test
    void toString_format() {
        Group g = new Group();
        g.add(new Point(0,0));
        g.add(new Line(0,0,1,1));
        String s = g.toString();
        assertTrue(s.startsWith("Group[") && s.contains("Point(0.0, 0.0)") && s.contains("Line["));
    }

    @Test
    void equals_detectsDifference() {
        Group g1 = new Group();
        g1.add(new Point(0,0));
        Group g2 = new Group();
        g2.add(new Point(1,1));
        assertNotEquals(g1,g2);
    }

    // ——— nowe testy dla branch coverage ——————————

    @Test
    void emptyGroup_cloneAndEquals() {
        Group g = new Group();
        Group c = g.clone();
        assertEquals(g, c);
        assertNotSame(g, c);
    }

    @Test
    void operations_onEmptyGroup_doNotThrow() {
        Group g = new Group();
        // sprawdzamy, że move/flip/rotate nie wyrzucają NPE
        assertDoesNotThrow(() -> {
            g.move(5,5);
            g.flip();
            g.rotate(30);
        });
    }

    @Test
    void equals_differentGroups_sameContent() {
        Group g1 = new Group();
        g1.add(new Point(0,0));

        Group g2 = new Group();
        g2.add(new Point(0,0));

        assertEquals(g1, g2);
    }

    @Test
    void toString_emptyGroup() {
        Group g = new Group();
        assertEquals("Group[]", g.toString());
    }

    @Test
    void toString_singleElement() {
        Group g = new Group();
        g.add(new Point(1,1));
        assertEquals("Group[Point(1.0, 1.0)]", g.toString());
    }

    @Test
    void toString_multipleElements() {
        Group g = new Group();
        g.add(new Point(1,1));
        g.add(new Point(2,2));
        String result = g.toString();
        assertEquals("Group[Point(1.0, 1.0), Point(2.0, 2.0)]", result);
    }

    // Additional tests specifically targeting branches

    @Test
    void equals_differentInstanceSameClass() {
        Group g1 = new Group();
        g1.add(new Point(1,1));

        // Another Group with different content
        Group g2 = new Group();
        g2.add(new Point(2,2));

        // This test hits the branch where instanceof passes but equals fails
        assertFalse(g1.equals(g2));
    }

    @Test
    void equals_groupWithDifferentFiguresSize() {
        Group g1 = new Group();
        g1.add(new Point(1,1));

        Group g2 = new Group();
        g2.add(new Point(1,1));
        g2.add(new Point(2,2));

        // This test hits another branch in figures.equals
        assertFalse(g1.equals(g2));
    }

    @Test
    void toString_iterateOverAllFigures() {
        Group g = new Group();
        Point p1 = new Point(1,1);
        Point p2 = new Point(2,2);
        Point p3 = new Point(3,3);

        g.add(p1);
        g.add(p2);
        g.add(p3);

        String result = g.toString();
        // Verify all points are in the string and properly comma-separated
        assertTrue(result.contains("Point(1.0, 1.0), Point(2.0, 2.0), Point(3.0, 3.0)"));
    }
}