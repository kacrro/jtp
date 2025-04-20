package lab_3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    @Test
    void constructor_shouldInitializeValueAndNullLinks() {
        Element e = new Element(42);
        assertEquals(42, e.getVal(), "Konstruktor powinien ustawić val");
        assertNull(e.getNext(), "Konstruktor powinien ustawić next na null");
        assertNull(e.getPrev(), "Konstruktor powinien ustawić prev na null");
    }

    @Test
    void settersAndGetters_shouldWorkCorrectly() {
        Element e1 = new Element(1);
        Element e2 = new Element(2);

        e1.setVal(100);
        assertEquals(100, e1.getVal(), "setVal/getVal nie działają");

        e1.setNext(e2);
        assertSame(e2, e1.getNext(), "setNext/getNext nie działają");

        e2.setPrev(e1);
        assertSame(e1, e2.getPrev(), "setPrev/getPrev nie działają");
    }
}
