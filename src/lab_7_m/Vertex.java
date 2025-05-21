package lab_7_m;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Vertex {

    private final int label;
    private final Set<Vertex> neighbours = new HashSet<>();

    /**
     * Tworzy nowy wierzchołek z podaną etykietą
     *
     * @param label etykieta wierzchołka
     */
    public Vertex(int label) {
        this.label = label;
    }

    /**
     * Dodaje krawędź skierowaną od bieżącego wierzchołka do v
     *
     * @param v wierzchołek docelowy
     */
    public void addEdge(Vertex v) {
        neighbours.add(v);
    }

    /**
     * Sprawdza, czy istnieje ścieżka skierowana od bieżącego wierzchołka do v
     *
     * @param v wierzchołek docelowy
     * @return true jeśli istnieje ścieżka, false w przeciwnym wypadku
     */
    public boolean connectedWith(Vertex v) {
        if (this == v) return false;

        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();

        visited.add(this);
        queue.add(this);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            if (current == v) {
                return true;
            }

            for (Vertex neighbour : current.neighbours) {
                if (visited.add(neighbour)) {
                    queue.add(neighbour);
                }
            }
        }

        return false;
    }

    /**
     * Znajduje wierzchołek o maksymalnej etykiecie połączony ścieżką skierowaną z bieżącym wierzchołkiem
     *
     * @return wierzchołek o maksymalnej etykiecie dostępny z bieżącego wierzchołka
     */
    public Vertex maximalConnected() {
        Vertex maximal = this;

        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();

        visited.add(this);
        queue.add(this);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            if (current.label > maximal.label) {
                maximal = current;
            }

            for (Vertex neighbour : current.neighbours) {
                if (visited.add(neighbour)) {
                    queue.add(neighbour);
                }
            }
        }

        return maximal;
    }

    /**
     * Znajduje najkrótszą ścieżkę między bieżącym wierzchołkiem a wierzchołkiem docelowym
     *
     * @param v wierzchołek docelowy
     * @return lista wierzchołków tworzących najkrótszą ścieżkę lub pustą listę, jeśli ścieżka nie istnieje
     */
    public List<Vertex> shortestPath(Vertex v) {
        if (this == v) {
            List<Vertex> path = new ArrayList<>();
            path.add(this);
            return path;
        }

        // Użycie algorytmu BFS do znalezienia najkrótszej ścieżki
        Map<Vertex, Vertex> predecessors = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();

        visited.add(this);
        queue.add(this);

        boolean found = false;

        while (!queue.isEmpty() && !found) {
            Vertex current = queue.poll();

            for (Vertex neighbour : current.neighbours) {
                if (visited.add(neighbour)) {
                    predecessors.put(neighbour, current);
                    queue.add(neighbour);

                    if (neighbour == v) {
                        found = true;
                        break;
                    }
                }
            }
        }

        // Jeśli znaleziono ścieżkę, odtwórz ją
        if (found) {
            List<Vertex> path = new ArrayList<>();
            Vertex current = v;

            while (current != null) {
                path.add(current);
                current = predecessors.get(current);
            }

            Collections.reverse(path);
            return path;
        }

        // Jeśli nie znaleziono ścieżki, zwróć pustą listę
        return new ArrayList<>();
    }

    /**
     * Sprawdza, czy wyjście z bieżącego wierzchołka prowadzi do pętli w grafie
     *
     * @return true jeśli istnieje pętla dostępna z bieżącego wierzchołka, false w przeciwnym wypadku
     */
    public boolean hasLoop() {
        Set<Vertex> visited = new HashSet<>();
        Set<Vertex> recursionStack = new HashSet<>();

        return hasLoopUtil(this, visited, recursionStack);
    }

    /**
     * Pomocnicza metoda rekurencyjna dla hasLoop()
     *
     * @param vertex aktualny wierzchołek
     * @param visited zbiór odwiedzonych wierzchołków
     * @param recursionStack zbiór wierzchołków w bieżącym wywołaniu rekurencyjnym
     * @return true jeśli znaleziono pętlę, false w przeciwnym wypadku
     */
    private boolean hasLoopUtil(Vertex vertex, Set<Vertex> visited, Set<Vertex> recursionStack) {
        // Oznacz bieżący wierzchołek jako odwiedzony i dodaj do stosu rekurencji
        visited.add(vertex);
        recursionStack.add(vertex);

        // Przetwarzaj wszystkie sąsiadujące wierzchołki
        for (Vertex neighbour : vertex.neighbours) {
            // Jeśli wierzchołek nie został odwiedzony
            if (!visited.contains(neighbour)) {
                if (hasLoopUtil(neighbour, visited, recursionStack)) {
                    return true;
                }
            }
            // Jeśli sąsiad jest w stosie rekurencji, znaleźliśmy pętlę
            else if (recursionStack.contains(neighbour)) {
                return true;
            }
        }

        // Usuń wierzchołek ze stosu rekurencji
        recursionStack.remove(vertex);
        return false;
    }

    /**
     * Sprawdza, czy istnieje ścieżka od bieżącego wierzchołka do wierzchołka v,
     * której wszystkie etykiety pośrednie należą do zbioru l
     *
     * @param l zbiór dopuszczalnych etykiet
     * @param v wierzchołek docelowy
     * @return true jeśli istnieje taka ścieżka, false w przeciwnym wypadku
     */
    public boolean connectedBy(Set<Integer> l, Vertex v) {
        // Jeśli wierzchołek docelowy jest taki sam jak bieżący, sprawdź czy jego etykieta jest w zbiorze
        if (this == v) {
            return l.contains(this.label);
        }

        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();

        // Dodaj bieżący wierzchołek do odwiedzonych tylko jeśli jego etykieta jest w zbiorze
        if (l.contains(this.label)) {
            visited.add(this);
            queue.add(this);
        }

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            if (current == v) {
                return true;
            }

            for (Vertex neighbour : current.neighbours) {
                // Dodaj sąsiada do kolejki tylko jeśli jego etykieta jest w zbiorze
                if (l.contains(neighbour.label) && visited.add(neighbour)) {
                    queue.add(neighbour);
                }
            }
        }

        return false;
    }

    /**
     * Zwraca etykietę wierzchołka
     *
     * @return etykieta wierzchołka
     */
    public int getLabel() {
        return label;
    }
}