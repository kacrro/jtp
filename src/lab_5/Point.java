package lab_5;

import java.util.Objects;

public class Point implements Figur {
    private double x,y;

    public Point(double x, double y) {
        this.x = x; this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    @Override
    public void move(double dx, double dy) {
        x += dx; y += dy;
    }

    @Override
    public void flip() {
        x = -x; y = -y;
        if (x == 0.0) x = 0.0;
        if (y == 0.0) y = 0.0;
    }

    @Override
    public void rotate(double angleDegrees) {
        double rad = Math.toRadians(angleDegrees);
        double cos = Math.cos(rad), sin = Math.sin(rad);
        double newX = x * cos - y * sin;
        double newY = x * sin + y * cos;
        // zaokrąglamy do 3 miejsc po przecinku:
        x = Math.round(newX * 1000.0) / 1000.0;
        y = Math.round(newY * 1000.0) / 1000.0;
    }

    @Override
    public Point clone() {
        return new Point(x,y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point p)) return false;
        return Double.compare(p.x, x)==0
                && Double.compare(p.y, y)==0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}
