package lab_7_m;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Vertex {

    private final int label;
    private final Set<Vertex> neighbours = new HashSet<>();

    public Vertex(int label) {
        this.label = label;
    }

    public void addEdge(Vertex v) {
        neighbours.add(v);
    }

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
}
