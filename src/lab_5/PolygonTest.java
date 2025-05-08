// src/test/java/lab_1/other/PolygonTest.java
package lab_5;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class PolygonTest {

    @Test
    void equals_selfAndNullAndDifferentSize() {
        Polygon a = new Polygon(List.of(
                new Point(0,0), new Point(1,0), new Point(1,1)
        ));
        assertTrue(a.equals(a));
        assertFalse(a.equals(null));
        assertFalse(a.equals("foo"));
        // różna liczba wierzchołków
        Polygon b = new Polygon(List.of(
                new Point(0,0), new Point(1,0), new Point(1,1), new Point(0,1)
        ));
        assertFalse(a.equals(b));
    }

    @Test
    void move_translatesVertices() {
        Polygon poly = new Polygon(List.of(
                new Point(0,0), new Point(1,0), new Point(1,1)
        ));
        poly.move(2,3);
        assertEquals(List.of(
                new Point(2,3), new Point(3,3), new Point(3,4)
        ), poly.getVertices());
    }

    @Test
    void flip_reflectsVertices() {
        Polygon poly = new Polygon(List.of(
                new Point(2,3), new Point(-1,1), new Point(0,0)
        ));
        poly.flip();
        assertEquals(List.of(
                new Point(-2,-3), new Point(1,-1), new Point(0,0)
        ), poly.getVertices());
    }

    @Test
    void rotate_90Degrees() {
        Polygon poly = new Polygon(List.of(
                new Point(1,0), new Point(0,1), new Point(-1,0)
        ));
        poly.rotate(90);
        assertEquals(List.of(
                new Point(0,1), new Point(-1,0), new Point(0,-1)
        ), poly.getVertices());
    }

    @Test
    void rotate_45Degrees() {
        Polygon poly = new Polygon(List.of(
                new Point(1,0), new Point(0,1), new Point(-1,0)
        ));
        poly.rotate(45);
        assertEquals(List.of(
                new Point(0.707,0.707),
                new Point(-0.707,0.707),
                new Point(-0.707,-0.707)
        ), poly.getVertices());
    }

    @Test
    void clone_deepCopy() {
        Polygon poly = new Polygon(List.of(
                new Point(0,0), new Point(1,1), new Point(2,2)
        ));
        Polygon c = poly.clone();
        assertEquals(poly, c);
        assertNotSame(poly, c);
        assertNotSame(poly.getVertices().get(0), c.getVertices().get(0));
    }

    @Test
    void toString_format() {
        Polygon poly = new Polygon(List.of(
                new Point(0,0), new Point(0,1), new Point(1,1)
        ));
        String s = poly.toString();
        assertTrue(s.startsWith("Polygon[") && s.contains("Point(0.0, 0.0)") && s.endsWith("]"));
    }

    @Test
    void equals_detectsDifference() {
        Polygon a = new Polygon(List.of(
                new Point(0,0), new Point(1,0), new Point(1,1)
        ));
        Polygon b = new Polygon(List.of(
                new Point(0,0), new Point(1,0), new Point(2,2)
        ));
        assertNotEquals(a,b);
    }

    // ——— nowe testy dla branch coverage ——————————

    @Test
    void constructor_withTooFewVertices_throws() {
        List<Point> twoPoints = List.of(new Point(0,0), new Point(1,1));
        assertThrows(IllegalArgumentException.class, () -> new Polygon(twoPoints));
    }

    @Test
    void getVertices_returnsIndependentCopy() {
        List<Point> verts = new ArrayList<>();
        verts.add(new Point(0,0));
        verts.add(new Point(1,0));
        verts.add(new Point(1,1));
        Polygon poly = new Polygon(verts);

        List<Point> copy = poly.getVertices();
        // zmiana w copy nie wpływa na oryginał
        copy.get(0).move(5,5);
        assertEquals(new Point(0,0), poly.getVertices().get(0));
    }

    @Test
    void equals_differentPolygons_sameVertices() {
        Polygon a = new Polygon(List.of(
                new Point(0,0), new Point(1,0), new Point(1,1)
        ));
        Polygon b = new Polygon(List.of(
                new Point(0,0), new Point(1,0), new Point(1,1)
        ));
        assertEquals(a, b);
        assertNotSame(a, b);
    }

    @Test
    void toString_singleVertex() {
        // Creating a polygon with minimum vertices (3)
        Polygon poly = new Polygon(List.of(
                new Point(0,0), new Point(1,0), new Point(1,1)
        ));
        String s = poly.toString();

        // Test that both commas are present for separating vertices
        assertTrue(s.contains(", "));

        // Test the complete string format
        assertEquals("Polygon[Point(0.0, 0.0), Point(1.0, 0.0), Point(1.0, 1.0)]", s);
    }

    @Test
    void toString_multipleVertices() {
        // Creating a polygon with more than 3 vertices
        Polygon poly = new Polygon(List.of(
                new Point(0,0), new Point(1,0), new Point(1,1), new Point(0,1)
        ));

        // Check the complete string format
        assertEquals("Polygon[Point(0.0, 0.0), Point(1.0, 0.0), Point(1.0, 1.0), Point(0.0, 1.0)]",
                poly.toString());
    }

    // Additional tests specifically targeting branches

    @Test
    void equals_nonPolygonInstance() {
        Polygon poly = new Polygon(List.of(
                new Point(0,0), new Point(1,0), new Point(1,1)
        ));
        // Test with a different type that is not a Polygon
        Object obj = new Object();
        assertFalse(poly.equals(obj));
    }

    @Test
    void equals_differentVerticesList() {
        Polygon a = new Polygon(List.of(
                new Point(0,0), new Point(1,0), new Point(1,1)
        ));

        // Same number of vertices but different coordinates
        Polygon b = new Polygon(List.of(
                new Point(5,5), new Point(6,0), new Point(6,6)
        ));

        assertFalse(a.equals(b));
    }

    @Test
    void toString_exactThreeVertices() {
        Polygon poly = new Polygon(List.of(
                new Point(0,0), new Point(1,0), new Point(0,1)
        ));

        String result = poly.toString();
        // Make sure comma separators are handled correctly
        assertEquals("Polygon[Point(0.0, 0.0), Point(1.0, 0.0), Point(0.0, 1.0)]", result);
    }

    @Test
    void toString_manyVertices() {
        // Create polygon with many vertices to test all comma placement branches
        Polygon poly = new Polygon(List.of(
                new Point(0,0), new Point(1,0), new Point(2,0),
                new Point(2,1), new Point(1,1), new Point(0,1)
        ));

        String result = poly.toString();
        // Verify all vertices are included with proper formatting
        assertTrue(result.contains("Point(0.0, 0.0), Point(1.0, 0.0), Point(2.0, 0.0), " +
                "Point(2.0, 1.0), Point(1.0, 1.0), Point(0.0, 1.0)"));
    }
}