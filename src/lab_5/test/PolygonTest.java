package lab_5.test;

import lab_5.Point;
import lab_5.Polygon;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PolygonTest {

    @Test
    void rotate_polygon_90Degrees() {
        Polygon poly = new Polygon(List.of(
                new Point(1,0), new Point(0,1), new Point(-1,0)
        ));
        poly.rotate(90);
        assertEquals(List.of(
                new Point(0,1), new Point(-1,0), new Point(0,-1)
        ), poly.getVertices());
    }

    @Test
    void rotate_polygon_45Degrees() {
        Polygon poly = new Polygon(List.of(
                new Point(1,0), new Point(0,1), new Point(-1,0)
        ));
        poly.rotate(45);
        // Expected: (≈0.707, ≈0.707), (-0.707,≈0.707), (≈-0.707,≈-0.707)
        assertEquals(List.of(
                new Point(0.707, 0.707),
                new Point(-0.707, 0.707),
                new Point(-0.707, -0.707)
        ), poly.getVertices());
    }




    @Test
    void move_translatesAllVertices() {
        Polygon poly = new Polygon(List.of(
                new Point(0,0), new Point(1,0), new Point(1,1)
        ));
        poly.move(2,3);
        assertEquals(List.of(
                new Point(2,3), new Point(3,3), new Point(3,4)
        ), poly.getVertices());
    }

    @Test
    void flip_reflectsAllVertices() {
        Polygon poly = new Polygon(List.of(
                new Point(2,3), new Point(-1,1), new Point(0,0)
        ));
        poly.flip();
        assertEquals(List.of(
                new Point(-2,-3), new Point(1,-1), new Point(0,0)
        ), poly.getVertices());
    }

    @Test
    void clone_createsDeepCopy() {
        Polygon poly = new Polygon(List.of(
                new Point(0,0), new Point(1,1), new Point(2,2)
        ));
        Polygon c = poly.clone();
        assertEquals(poly, c);
        assertNotSame(poly, c);
        // wierzchołki są różne instancje
        assertNotSame(poly.getVertices().get(0), c.getVertices().get(0));
    }

    @Test
    void toString_listsVertices() {
        Polygon poly = new Polygon(List.of(
                new Point(0,0), new Point(0,1), new Point(1,1)
        ));
        String s = poly.toString();
        assertTrue(s.startsWith("Polygon[") && s.contains("Point(0.0, 0.0)")
                && s.endsWith("]"));
    }

    @Test
    void equals_detectsDifferentPolygons() {
        Polygon a = new Polygon(List.of(
                new Point(0,0), new Point(1,0), new Point(1,1)
        ));
        Polygon b = new Polygon(List.of(
                new Point(0,0), new Point(1,0), new Point(2,2)
        ));
        assertNotEquals(a, b);
    }
}
