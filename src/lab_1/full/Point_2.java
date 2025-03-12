package lab_1.full;

class Point_2 {
    private double x, y;
    public double getX() {return this.x;}
    public double getY() {return this.y;}

    public Point_2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void move (double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public void flip() {
        this.x = -this.x;
        this.y = -this.y;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}