package lab_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Polygon implements Figur {
    private List<Point> vertices;

    public Polygon(List<Point> vertices) {
        if (vertices.size()<3)
            throw new IllegalArgumentException("Polygon needs ≥3 vertices");
        // deep copy
        this.vertices = new ArrayList<>();
        for (Point p: vertices) this.vertices.add(p.clone());
    }

    /** Zwraca kopię listy wierzchołków */
    public List<Point> getVertices() {
        List<Point> copy = new ArrayList<>();
        for (Point p: vertices) copy.add(p.clone());
        return copy;
    }

    @Override
    public void move(double dx,double dy) {
        for (Point p: vertices) p.move(dx,dy);
    }

    @Override
    public void flip() {
        for (Point p: vertices) p.flip();
    }

    @Override
    public void rotate(double angleDegrees) {
        for (Point p: vertices) p.rotate(angleDegrees);
    }

    @Override
    public Polygon clone() {
        return new Polygon(this.vertices);
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (!(o instanceof Polygon p)) return false;
        return vertices.equals(p.vertices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertices);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Polygon[");
        for (int i=0;i<vertices.size();i++){
            sb.append(vertices.get(i));
            if (i<vertices.size()-1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
