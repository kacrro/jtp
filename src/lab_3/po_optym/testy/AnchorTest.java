package lab_3.po_optym.testy;

import lab_3.po_optym.Anchor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnchorTest {

    private Anchor list;

    @BeforeEach
    void setUp() {
        list = new Anchor();
    }

    // ——— isEmpty() & size() ——————————

    @Test
    void newList_shouldBeEmptyAndSizeZero() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void afterInserts_listNotEmptyAndSizeCorrect() {
        list.insertAtTheFront(1);
        list.insertAtTheEnd(2);
        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
    }

    // ——— getFirst() & getLast() ——————————

    @Test
    void getFirstAndGetLast_onEmpty_shouldReturnNulls() {
        assertNull(list.getFirst());
        assertNull(list.getLast());
    }

    @Test
    void getFirstAndGetLast_afterInserts_shouldReturnCorrectElements() {
        list.insertAtTheFront(10);
        list.insertAtTheEnd(20);
        assertEquals(10, list.getFirst().getVal());
        assertEquals(20, list.getLast().getVal());
    }

    // ——— insertAtTheFront() ——————————

    @Test
    void insertAtTheFront_onEmpty_shouldSetFirstAndLast() {
        list.insertAtTheFront(5);
        assertEquals(1, list.size());
        assertEquals(5, list.getFirst().getVal());
        assertEquals(5, list.getLast().getVal());
    }

    @Test
    void insertAtTheFront_onNonEmpty_shouldUpdateFirstOnly() {
        list.insertAtTheFront(1);
        list.insertAtTheFront(2);
        assertEquals(2, list.getFirst().getVal());
        assertEquals(1, list.getLast().getVal());
        assertEquals(2, list.size());
    }

    // ——— insertAtTheEnd() ——————————

    @Test
    void insertAtTheEnd_onEmpty_shouldSetFirstAndLast() {
        list.insertAtTheEnd(7);
        assertEquals(1, list.size());
        assertEquals(7, list.getFirst().getVal());
        assertEquals(7, list.getLast().getVal());
    }

    @Test
    void insertAtTheEnd_onNonEmpty_shouldUpdateLastOnly() {
        list.insertAtTheFront(1);
        list.insertAtTheEnd(2);
        list.insertAtTheEnd(3);
        assertEquals(1, list.getFirst().getVal());
        assertEquals(3, list.getLast().getVal());
        assertEquals(3, list.size());
    }

    // ——— removeFirst() ——————————

    @Test
    void removeFirst_onEmpty_shouldDoNothing() {
        list.removeFirst();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void removeFirst_onMultiple_shouldRemoveHead() {
        list.insertAtTheEnd(1);
        list.insertAtTheEnd(2);
        list.removeFirst();
        assertEquals(2, list.getFirst().getVal());
        assertEquals(1, list.size());
    }

    // ——— removeLast() ——————————

    @Test
    void removeLast_onEmpty_shouldDoNothing() {
        list.removeLast();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void removeLast_onMultiple_shouldRemoveTail() {
        list.insertAtTheEnd(1);
        list.insertAtTheEnd(2);
        list.removeLast();
        assertEquals(1, list.getLast().getVal());
        assertEquals(1, list.size());
    }

    // ——— clone() ——————————

    @Test
    void clone_onEmpty_shouldReturnEmptyList() {
        Anchor cloned = list.clone();
        assertTrue(cloned.isEmpty());
        assertNotSame(list, cloned);
    }

    @Test
    void clone_onNonEmpty_shouldDeepCopy() {
        list.insertAtTheEnd(1);
        list.insertAtTheEnd(2);
        Anchor cloned = list.clone();
        assertEquals(list, cloned);
        assertNotSame(list, cloned);
        assertNotSame(list.getFirst(), cloned.getFirst());
    }

    // ——— revert() ——————————

    @Test
    void revert_onEmptyOrSingle_shouldDoNothing() {
        list.revert();  // pusty
        assertTrue(list.isEmpty());
        list.insertAtTheEnd(1);
        list.revert();  // jeden element
        assertEquals(1, list.getFirst().getVal());
    }

    @Test
    void revert_onMultiple_shouldReverseOrder() {
        list.insertAtTheEnd(1);
        list.insertAtTheEnd(2);
        list.insertAtTheEnd(3);
        list.revert();
        assertEquals(3, list.getFirst().getVal());
        assertEquals(1, list.getLast().getVal());
    }

    // ——— toString() ——————————

    @Test
    void toString_onEmptyAndSingleAndMultiple() {
        assertEquals("[]", list.toString());
        list.insertAtTheEnd(1);
        assertEquals("[1]", list.toString());
        list.insertAtTheEnd(2);
        assertEquals("[1, 2]", list.toString());
    }

    @Test
    void toString_containsCommasAndBracketsCorrectly() {
        list.insertAtTheFront(3);
        list.insertAtTheFront(2);
        list.insertAtTheFront(1);
        String s = list.toString();
        assertTrue(s.startsWith("[") && s.endsWith("]"));
        assertTrue(s.contains("1, 2") && s.contains("2, 3"));
    }

    // ——— equals() ——————————

    @Test
    void equals_sameContent_shouldReturnTrue() {
        list.insertAtTheEnd(1);
        list.insertAtTheEnd(2);
        Anchor other = new Anchor();
        other.insertAtTheEnd(1);
        other.insertAtTheEnd(2);
        assertTrue(list.equals(other));
    }

    @Test
    void equals_differentContentOrSize_shouldReturnFalse() {
        list.insertAtTheEnd(1);
        Anchor other = new Anchor();
        other.insertAtTheEnd(2);
        assertFalse(list.equals(other));
        list.insertAtTheEnd(3);
        other.insertAtTheEnd(3);
        assertFalse(list.equals(other));  // pierwszy element różny
    }
}
