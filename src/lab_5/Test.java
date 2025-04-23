package lab_5;

import lab_5.Group;
import lab_5.Line;
import lab_5.Point;
import lab_5.Polygon;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println("=== Test Point ===");
        Point p1 = new Point(1, 2);
        System.out.println("Original p1:      " + p1);
        Visualizer.show("Point – original", Arrays.asList(p1.clone()));

        p1.move(3, -1);
        System.out.println("After move(3,-1): " + p1);
        Visualizer.show("Point – after move", Arrays.asList(p1.clone()));

        p1.flip();
        System.out.println("After flip():     " + p1);
        Visualizer.show("Point – after flip", Arrays.asList(p1.clone()));

        // ---- LINE ----
        System.out.println("\n=== Test Line ===");
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        Line line = new Line(a, b);
        System.out.println("Original line:      " + line);
        Visualizer.show("Line – original", Arrays.asList(line.clone()));

        line.move(2, 3);
        System.out.println("After move(2,3):    " + line);
        Visualizer.show("Line – after move", Arrays.asList(line.clone()));

        line.flip();
        System.out.println("After flip():       " + line);
        Visualizer.show("Line – after flip", Arrays.asList(line.clone()));

        // ---- POLYGON ----
        System.out.println("\n=== Test Polygon ===");
        Polygon poly = new Polygon(Arrays.asList(
                new Point(0, 0),
                new Point(1, 0),
                new Point(1, 1),
                new Point(0, 1)
        ));
        System.out.println("Original polygon:      " + poly);
        Visualizer.show("Polygon – original", Arrays.asList(poly.clone()));

        poly.move(1, 1);
        System.out.println("After move(1,1):       " + poly);
        Visualizer.show("Polygon – after move", Arrays.asList(poly.clone()));

        poly.flip();
        System.out.println("After flip():          " + poly);
        Visualizer.show("Polygon – after flip", Arrays.asList(poly.clone()));

        // ---- GROUP ----
        System.out.println("\n=== Test Group ===");
        Group group1 = new Group();
        group1.add(new Point(2, 3));
        group1.add(new Line(
                new Point(2, 3),
                new Point(4, 5)
        ));
        group1.add(new Polygon(Arrays.asList(
                new Point(0, 0),
                new Point(0, 2),
                new Point(2, 2)
        )));
        System.out.println("Original group1:    " + group1);
        Visualizer.show("Group – original", Arrays.asList(group1.clone()));

        group1.move(-2, -3);
        System.out.println("After move(-2,-3):  " + group1);
        Visualizer.show("Group – after move", Arrays.asList(group1.clone()));

        group1.flip();
        System.out.println("After flip():       " + group1);
        Visualizer.show("Group – after flip", Arrays.asList(group1.clone()));
    }
}
