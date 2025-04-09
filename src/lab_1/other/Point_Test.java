package lab_1.other;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class Point_Test {

    @Test
    void move() {
        Point p1 = new Point(0, 0);
        final double old_p1_x = p1.getX();
        final double old_p1_y = p1.getY();
        p1.move(1,1);
        double new_p1_x = p1.getX();
        double new_p1_y = p1.getY();
        assertTrue(new_p1_x==old_p1_x+1);
        assertTrue(new_p1_y==old_p1_y+1);
    }

    @Test
    void flip() {
        Point p1 = new Point(0, 0);
        final double old_p1_x = p1.getX();
        final double old_p1_y = p1.getY();
        p1.flip();
        double new_p1_x = p1.getX();
        double new_p1_y = p1.getY();
        assertTrue(new_p1_x==-old_p1_x);
        assertTrue(new_p1_y==-old_p1_y);
    }
}