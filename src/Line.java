
// Klasa reprezentująca linię w przestrzeni dwuwymiarowej
class Line {
    private Point start;
    private Point end;

    // Konstruktor
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // Konstruktor z współrzędnymi
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    // Metoda move - przesuwanie linii o wektor (dx, dy)
    public void move(double dx, double dy) {
        start.move(dx, dy);
        end.move(dx, dy);
    }

    // Metoda flip - odbicie linii względem początku układu współrzędnych
    public void flip() {
        start.flip();
        end.flip();
    }

    // Gettery
    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    // Metoda toString zgodnie z wymaganiami
    public String toString() {
        return "Line[" + start.toString() + " -> " + end.toString() + "]";
    }
}
