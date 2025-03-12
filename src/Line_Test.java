import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Line_Test {

    @Test
    void move() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        Line line = new Line(p1, p2);
        final double old_p1_x = p1.getX();
        final double old_p1_y = p1.getY();
        final double old_p2_x = p2.getX();
        final double old_p2_y = p2.getY();
        line.move(1,1);
        double new_p1_x = p1.getX();
        double new_p1_y = p1.getY();
        double new_p2_x = p2.getX();
        double new_p2_y = p2.getY();
        assertTrue(new_p1_x==old_p1_x+1);
        assertTrue(new_p1_y==old_p1_y+1);
        assertTrue(new_p2_x==old_p2_x+1);
        assertTrue(new_p2_y==old_p2_y+1);
    }

    @Test
    void flip() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        Line line = new Line(p1, p2);
        final double old_p1_x = p1.getX();
        final double old_p1_y = p1.getY();
        final double old_p2_x = p2.getX();
        final double old_p2_y = p2.getY();
        line.flip();
        double new_p1_x = p1.getX();
        double new_p1_y = p1.getY();
        double new_p2_x = p2.getX();
        double new_p2_y = p2.getY();
        assertTrue(new_p1_x==-old_p1_x);
        assertTrue(new_p1_y==-old_p1_y);
        assertTrue(new_p2_x==-old_p2_x);
        assertTrue(new_p2_y==-old_p2_y);
    }
}