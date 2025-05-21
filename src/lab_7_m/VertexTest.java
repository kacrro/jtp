package lab_7_m;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VertexTest {

    @Test
    void connectedWith1() {
        Vertex v1 = new Vertex(1);

        assertFalse(v1.connectedWith(v1));
    }

    @Test
    void connectedWith2() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);

        assertFalse(v1.connectedWith(v2));
    }

    @Test
    void connectedWith3() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);

        v1.addEdge(v2);

        assertTrue(v1.connectedWith(v2));
    }

    @Test
    void connectedWith4() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(2);

        v1.addEdge(v2);

        assertFalse(v1.connectedWith(v3));
    }

    @Test
    void connectedWith5() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);

        v1.addEdge(v2);

        assertTrue(v1.connectedWith(v2));
        assertFalse(v2.connectedWith(v1));
    }

    @Test
    void connectedWith6() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);

        v1.addEdge(v2);
        v2.addEdge(v1);
        v2.addEdge(v3);

        assertTrue(v1.connectedWith(v3));
    }

    @Test
    void maximalConnected1() {
        Vertex v1 = new Vertex(1);

        assertEquals(v1, v1.maximalConnected());
    }

    @Test
    void maximalConnected2() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);

        v1.addEdge(v2);

        assertEquals(v2, v1.maximalConnected());
    }

    @Test
    void maximalConnected3() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);

        v1.addEdge(v2);
        v2.addEdge(v1);
        v2.addEdge(v3);

        assertEquals(v3, v1.maximalConnected());
    }

    @Test
    void shortestPath1() {
        // Test ścieżki do samego siebie
        Vertex v1 = new Vertex(1);

        List<Vertex> path = v1.shortestPath(v1);

        assertEquals(1, path.size());
        assertEquals(v1, path.get(0));
    }

    @Test
    void shortestPath2() {
        // Test braku ścieżki
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);

        List<Vertex> path = v1.shortestPath(v2);

        assertTrue(path.isEmpty());
    }

    @Test
    void shortestPath3() {
        // Test prostej ścieżki
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);

        v1.addEdge(v2);

        List<Vertex> path = v1.shortestPath(v2);

        assertEquals(2, path.size());
        assertEquals(v1, path.get(0));
        assertEquals(v2, path.get(1));
    }

    @Test
    void shortestPath4() {
        // Test wyboru najkrótszej ścieżki
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);

        // Ścieżka 1: v1 -> v2 -> v4
        v1.addEdge(v2);
        v2.addEdge(v4);

        // Ścieżka 2: v1 -> v3 -> v2 -> v4
        v1.addEdge(v3);
        v3.addEdge(v2);

        List<Vertex> path = v1.shortestPath(v4);

        assertEquals(3, path.size());
        assertEquals(v1, path.get(0));
        assertEquals(v2, path.get(1));
        assertEquals(v4, path.get(2));
    }

    @Test
    void hasLoop1() {
        // Test braku pętli
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);

        v1.addEdge(v2);
        v2.addEdge(v3);

        assertFalse(v1.hasLoop());
    }

    @Test
    void hasLoop2() {
        // Test pętli bezpośredniej
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);

        v1.addEdge(v2);
        v2.addEdge(v1);

        assertTrue(v1.hasLoop());
    }

    @Test
    void hasLoop3() {
        // Test pętli pośredniej
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);

        v1.addEdge(v2);
        v2.addEdge(v3);
        v3.addEdge(v1);

        assertTrue(v1.hasLoop());
    }

    @Test
    void hasLoop4() {
        // Test pętli własnej
        Vertex v1 = new Vertex(1);

        v1.addEdge(v1);

        assertTrue(v1.hasLoop());
    }

    @Test
    void hasLoop5() {
        // Test braku pętli w grafie z wieloma wierzchołkami
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);

        v1.addEdge(v2);
        v1.addEdge(v3);
        v2.addEdge(v4);
        v3.addEdge(v4);

        assertFalse(v1.hasLoop());
    }

    @Test
    void connectedBy1() {
        // Test gdy ścieżka nie istnieje
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);

        Set<Integer> l = new HashSet<>();
        l.add(1);
        l.add(2);

        assertFalse(v1.connectedBy(l, v2));
    }

    @Test
    void connectedBy2() {
        // Test gdy ścieżka istnieje i etykiety są w zbiorze
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);

        v1.addEdge(v2);

        Set<Integer> l = new HashSet<>();
        l.add(1);
        l.add(2);

        assertTrue(v1.connectedBy(l, v2));
    }

    @Test
    void connectedBy3() {
        // Test gdy ścieżka istnieje, ale etykieta pośredniego wierzchołka nie jest w zbiorze
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);

        v1.addEdge(v2);
        v2.addEdge(v3);

        Set<Integer> l = new HashSet<>();
        l.add(1);
        l.add(3);

        assertFalse(v1.connectedBy(l, v3));
    }

    @Test
    void connectedBy4() {
        // Test gdy ścieżka do samego siebie
        Vertex v1 = new Vertex(1);

        Set<Integer> l = new HashSet<>();
        l.add(1);

        assertTrue(v1.connectedBy(l, v1));
    }

    @Test
    void connectedBy5() {
        // Test gdy ścieżka do samego siebie, ale etykieta nie jest w zbiorze
        Vertex v1 = new Vertex(1);

        Set<Integer> l = new HashSet<>();
        l.add(2);

        assertFalse(v1.connectedBy(l, v1));
    }

    @Test
    void connectedBy6() {
        // Test gdy istnieje alternatywna ścieżka przez wierzchołki z etykietami w zbiorze
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);

        v1.addEdge(v2);
        v2.addEdge(v4);
        v1.addEdge(v3);
        v3.addEdge(v4);

        Set<Integer> l = new HashSet<>();
        l.add(1);
        l.add(3);
        l.add(4);

        assertTrue(v1.connectedBy(l, v4));
    }

    @Test
    void getLabel() {
        Vertex v1 = new Vertex(42);
        assertEquals(42, v1.getLabel());
    }
}