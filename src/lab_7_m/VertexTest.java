package lab_7_m;

import org.junit.jupiter.api.Test;

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
}
