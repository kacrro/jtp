package lab_3.po_optym.testy;

import lab_3.po_optym.Element;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    // ——— konstruktor i getVal() ——————————

    @Test
    void constructor_shouldSetValueAndNullLinks_case1() {
        Element e = new Element(42);
        assertEquals(42, e.getVal());
        assertNull(e.getNext());
        assertNull(e.getPrev());
    }

    @Test
    void constructor_shouldSetValueAndNullLinks_case2() {
        Element e = new Element(-7);
        assertEquals(-7, e.getVal());
        assertNull(e.getNext());
        assertNull(e.getPrev());
    }

    // ——— setVal()/getVal() ——————————

    @Test
    void setVal_shouldUpdateValue_positive() {
        Element e = new Element(0);
        e.setVal(100);
        assertEquals(100, e.getVal());
    }

    @Test
    void setVal_shouldUpdateValue_negative() {
        Element e = new Element(5);
        e.setVal(-55);
        assertEquals(-55, e.getVal());
    }

    // ——— setNext()/getNext() ——————————

    @Test
    void setNext_getNext_singleLink() {
        Element a = new Element(1);
        Element b = new Element(2);
        a.setNext(b);
        assertSame(b, a.getNext());
        assertNull(b.getNext());
    }

    @Test
    void setNext_getNext_overwriteLink() {
        Element a = new Element(1);
        Element b = new Element(2);
        Element c = new Element(3);
        a.setNext(b);
        assertSame(b, a.getNext());
        a.setNext(c);
        assertSame(c, a.getNext());
    }

    // ——— setPrev()/getPrev() ——————————

    @Test
    void setPrev_getPrev_singleLink() {
        Element a = new Element(1);
        Element b = new Element(2);
        b.setPrev(a);
        assertSame(a, b.getPrev());
        assertNull(a.getPrev());
    }

    @Test
    void setPrev_getPrev_overwriteLink() {
        Element a = new Element(1);
        Element b = new Element(2);
        Element c = new Element(3);
        b.setPrev(a);
        assertSame(a, b.getPrev());
        b.setPrev(c);
        assertSame(c, b.getPrev());
    }
}
