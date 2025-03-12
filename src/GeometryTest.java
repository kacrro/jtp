
// Klasa testowa
public class GeometryTest {
    public static void main(String[] args) {
        // Test klasy Point
        System.out.println("Test klasy Point:");
        Point p1 = new Point(2, 3);
        System.out.println("Utworzony punkt: " + p1);

        p1.move(1, -2);
        System.out.println("Po przesunięciu o wektor (1, -2): " + p1);

        p1.flip();
        System.out.println("Po odbiciu względem początku układu: " + p1);

        // Test klasy Line
        System.out.println("\nTest klasy Line:");
        Point p2 = new Point(1, 1);
        Point p3 = new Point(4, 5);
        Line line1 = new Line(p2, p3);
        System.out.println("Utworzona linia: " + line1);

        line1.move(2, 2);
        System.out.println("Po przesunięciu o wektor (2, 2): " + line1);

        line1.flip();
        System.out.println("Po odbiciu względem początku układu: " + line1);

        // Test konstruktora alternatywnego
        Line line2 = new Line(0, 0, 3, 4);
        System.out.println("\nLinia utworzona z współrzędnych: " + line2);
    }
}