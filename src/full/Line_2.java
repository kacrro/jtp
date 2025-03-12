package full;

import java.awt.*;

class Line_2 {
    private Point_2 start;
    private Point_2 end;

    public Line_2(Point_2 start, Point_2 end) {
    this.start = start;
    this.end = end;
    }

    public Line_2 (double x1, double y1, double x2, double y2) {
        this.start = new Point_2(x1, y1);
        this.end = new Point_2(x2, y2);
    }

    public void move (double dx, double dy) {
        start.move(dx, dy);
        end.move(dx, dy);
    }

    public void flip () {
        start.flip();
        end.flip();
    }

    public Point_2 getStart() {return start;}
    public Point_2 getEnd() {return end;}

    public String toString() {
        return "Line [" + start.toString() + " -> " + end.toString() + "]";
    }
}