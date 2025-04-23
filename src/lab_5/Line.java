package lab_5;

import java.util.Objects;

public class Line implements Figur {
    private Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end   = end;
    }

    public Line(double x1,double y1,double x2,double y2) {
        this(new Point(x1,y1), new Point(x2,y2));
    }

    public Point getStart() { return start; }
    public Point getEnd()   { return end;   }

    @Override
    public void move(double dx, double dy) {
        start.move(dx,dy);
        end  .move(dx,dy);
    }

    @Override
    public void flip() {
        start.flip();
        end  .flip();
    }

    @Override
    public void rotate(double angleDegrees) {
        start.rotate(angleDegrees);
        end  .rotate(angleDegrees);
    }

    @Override
    public Line clone() {
        return new Line(start.clone(), end.clone());
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (!(o instanceof Line l)) return false;
        return start.equals(l.start)
                && end  .equals(l.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start,end);
    }

    @Override
    public String toString() {
        return "Line[" + start + " -> " + end + "]";
    }
}
