package lab_7_m;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
    void connectedBy7() {
        // Test gdy etykieta początkowego wierzchołka nie należy do zbioru
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);

        v1.addEdge(v2);

        Set<Integer> l = new HashSet<>();
        // Celowo NIE dodajemy etykiety 1 do zbioru
        l.add(2);

        // To powinno spowodować wejście do warunku if (l.contains(this.label)) z wynikiem false
        assertFalse(v1.connectedBy(l, v2));
    }

    @Test
    void connectedBy8() {
        // Test gdy etykieta początkowego wierzchołka należy do zbioru,
        // ale etykieta sąsiada nie należy do zbioru
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);

        v1.addEdge(v2);
        v2.addEdge(v3);

        Set<Integer> l = new HashSet<>();
        l.add(1);
        // Celowo NIE dodajemy etykiety 2 do zbioru
        l.add(3);

        // To powinno spowodować wejście do warunku if (l.contains(neighbour.label)) z wynikiem false
        assertFalse(v1.connectedBy(l, v3));
    }

    @Test
    void connectedBy9() {
        // Test gdy wszystkie etykiety są w zbiorze
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);

        v1.addEdge(v2);
        v2.addEdge(v3);

        Set<Integer> l = new HashSet<>();
        l.add(1);
        l.add(2);
        l.add(3);

        assertTrue(v1.connectedBy(l, v3));
    }

    @Test
    void connectedBy10() {
        // Test dla pierwszego warunku - etykieta początkowego wierzchołka JEST w zbiorze
        Vertex v1 = new Vertex(5);
        Vertex v2 = new Vertex(10);

        v1.addEdge(v2);

        Set<Integer> l = new HashSet<>();
        l.add(5); // Dodajemy etykietę początkowego wierzchołka
        l.add(10);

        // To powinno spowodować wejście do warunku if (l.contains(this.label)) z wynikiem true
        assertTrue(v1.connectedBy(l, v2));
    }

    @Test
    void connectedBy11() {
        // Test dla drugiego warunku - etykieta sąsiada JEST w zbiorze
        Vertex v1 = new Vertex(5);
        Vertex v2 = new Vertex(10);
        Vertex v3 = new Vertex(15);

        v1.addEdge(v2);
        v2.addEdge(v3);

        Set<Integer> l = new HashSet<>();
        l.add(5);
        l.add(10); // Dodajemy etykietę sąsiada
        l.add(15);

        // To powinno spowodować wejście do warunku if (l.contains(neighbour.label)) z wynikiem true
        assertTrue(v1.connectedBy(l, v3));
    }

    @Test
    void connectedBy12() {
        // Test dla obu warunków razem z bardziej skomplikowanym grafem
        Vertex v1 = new Vertex(100);
        Vertex v2 = new Vertex(200);
        Vertex v3 = new Vertex(300);
        Vertex v4 = new Vertex(400);

        v1.addEdge(v2);
        v1.addEdge(v3); // Dodajemy dodatkową krawędź
        v2.addEdge(v4);
        v3.addEdge(v4);

        Set<Integer> l = new HashSet<>();
        l.add(100); // Etykieta początkowego wierzchołka
        l.add(300); // Etykieta jednego z sąsiadów
        l.add(400); // Etykieta końcowego wierzchołka
        // Celowo NIE dodajemy etykiety 200

        // Powinno znaleźć ścieżkę przez v1 -> v3 -> v4
        assertTrue(v1.connectedBy(l, v4));
    }

    @Test
    void connectedBy13() {
        // Test dla warunku visited.add(neighbour) zwracającego false
        // (gdy sąsiad został już odwiedzony)
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);

        // Tworzymy cykl w grafie
        v1.addEdge(v2);
        v2.addEdge(v3);
        v3.addEdge(v1); // Krawędź powrotna

        Set<Integer> l = new HashSet<>();
        l.add(1);
        l.add(2);
        l.add(3);

        // Ten test wymusi przejście przez wierzchołek v1 dwukrotnie
        // ale v1 będzie już odwiedzony, więc visited.add() zwróci false
        assertTrue(v1.connectedBy(l, v3));
    }

    @Test
    void connectedBy14() {
        // Test dla warunku visited.add(neighbour) zwracającego false
        // z bardziej złożonym grafem
        Vertex v1 = new Vertex(10);
        Vertex v2 = new Vertex(20);
        Vertex v3 = new Vertex(30);
        Vertex v4 = new Vertex(40);

        // Tworzymy graf z wieloma ścieżkami i cyklami
        v1.addEdge(v2);
        v2.addEdge(v3);
        v3.addEdge(v4);
        v1.addEdge(v3); // Bezpośrednia krawędź do v3
        v2.addEdge(v1); // Krawędź powrotna do v1

        Set<Integer> l = new HashSet<>();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);

        // Ten test wymusi ponowne odwiedzenie niektórych wierzchołków,
        // co spowoduje, że visited.add() zwróci false
        assertTrue(v1.connectedBy(l, v4));
    }

    @Test
    void getLabel() {
        Vertex v1 = new Vertex(42);
        assertEquals(42, v1.getLabel());
    }

    @Test
    void testShortestPathWhenNoConnectionShouldReturnEmpty_andCoverFalseBranch() {
        // Graf: A→B, A→C, B→C, cel D poza grafem
        Vertex a = new Vertex(1);
        Vertex b = new Vertex(2);
        Vertex c = new Vertex(3);
        Vertex d = new Vertex(4);  // D niepodłączone nigdzie

        a.addEdge(b);
        a.addEdge(c);
        b.addEdge(c);

        // 1) visited = {A}; queue = [A]
        // 2) z A wrzucamy B i C (visited.add==true)
        // 3) z B próbujemy dodać C ponownie (visited.add==false) → pokrywa branch false!
        // 4) nigdzie nie znajdziemy D, dostaniemy pustą listę
        List<Vertex> path = a.shortestPath(d);
        assertTrue(path.isEmpty(), "Brak ścieżki do wierzchołka D – powinno zwrócić pustą listę");
    }

    @Test
    void testShortestPathTwoHopsShouldReturnFullChain() {
        // Graf prosty 1→2→3
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);

        v1.addEdge(v2);
        v2.addEdge(v3);

        // Nie ma bezpośredniego v1→v3, więc ścieżka to [v1, v2, v3]
        List<Vertex> path = v1.shortestPath(v3);
        assertEquals(
                Arrays.asList(v1, v2, v3),
                path,
                "Najkrótsza ścieżka powinna zawierać kolejno v1, v2, v3"
        );
    }
}