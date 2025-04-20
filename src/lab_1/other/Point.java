package lab_1.other;

class Point {
    private double x;
    private double y;

    // Konstruktor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Metoda move - przesuwanie punktu o wektor (dx, dy)
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    // Metoda flip - odbicie punktu względem początku układu współrzędnych
    public void flip() {
        this.x = -this.x;
        this.y = -this.y;
    }

    // Gettery
    public double getX() {return x;}
    public double getY() {return y;}

    // Metoda toString zgodnie z wymaganiami
    public String toString() {
        return "lab_1.other.Point(" + x + ", " + y + ")";
    }

//    public double Rotate(double angle) {
//
//    }

}
