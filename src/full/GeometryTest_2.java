package full;

public class GeometryTest_2 {
    public static void main(String[] args) {
        System.out.println("Test Klasy Point:");
        Point_2 p1 = new Point_2(2,3);
        System.out.println("Utworzono punkt w: "+p1);

        p1.move(1,1);
        System.out.println("Przesunięto punkt o wektor (1, 1), teraz znajduje się w "+p1);

        p1.flip();
        System.out.println("Po odbiciu względem początku układu: " + p1);

        System.out.println("\nTest klasy line");
        Point_2 p2 = new Point_2(1,1);
        Point_2 p3 = new Point_2(4,5);
        Line_2 line1 = new Line_2(p2,p3);
        System.out.println("Utworzona linia: "+line1);

        line1.move(2,2);
        System.out.println("Przesunięta linia: "+line1);

        line1.flip();
        System.out.println("\nPo odbiciu linia to "+line1);

        Line_2 line2 = new Line_2(0, 0, 2, 3);
        System.out.println("Utworzona linia: "+line2);

    }
}