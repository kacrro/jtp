package lab_5;

public interface Figur extends Cloneable {
    /** przesuwa figurę o (dx, dy) */
    void move(double dx, double dy);
    /** odbija figurę względem początku układu (0,0) */
    void flip();
    /** obraca figurę o podany kąt (w stopniach) wokół (0,0) */
    void rotate(double angleDegrees);
    /** zwraca głęboką kopię figury */
    Figur clone();
}
