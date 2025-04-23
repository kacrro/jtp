package lab_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group implements Figur {
    private List<Figur> figures = new ArrayList<>();

    /** Dodaje figurę do grupy */
    public void add(Figur f) {
        figures.add(f);
    }

    /** Zwraca listę figur (shallow copy listy, figury nieklonowane) */
    public List<Figur> getFigures() {
        return new ArrayList<>(figures);
    }

    @Override
    public void move(double dx, double dy) {
        for (Figur f: figures) f.move(dx,dy);
    }

    @Override
    public void flip() {
        for (Figur f: figures) f.flip();
    }

    @Override
    public void rotate(double angleDegrees) {
        for (Figur f: figures) f.rotate(angleDegrees);
    }

    @Override
    public Group clone() {
        Group g2 = new Group();
        for (Figur f: figures) g2.add(f.clone());
        return g2;
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (!(o instanceof Group g)) return false;
        return figures.equals(g.figures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(figures);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Group[");
        for (int i=0;i<figures.size();i++){
            sb.append(figures.get(i));
            if (i<figures.size()-1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
