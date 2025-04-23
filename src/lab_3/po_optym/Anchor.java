package lab_3.po_optym;

public class Anchor {
    private Element first;   // początek listy
    private Element last;    // koniec listy
    private int     size;    // liczba elementów

    public Anchor() {
        this.first = this.last = null;
        this.size  = 0;
    }

    // ——— STAŁE CZASOWO (O(1)) ——————————

    /** Zwraca true, gdy lista jest pusta. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Zwraca liczbę elementów. */
    public int size() {
        return size;
    }

    /** Pierwszy element (lub null). */
    public Element getFirst() {
        return first;
    }

    /** Ostatni element (lub null). */
    public Element getLast() {
        return last;
    }

    /** Wstawia nowy element z wartością x na początek listy. */
    public void insertAtTheFront(int x) {
        Element e = new Element(x);
        if (first == null) {
            first = last = e;
        } else {
            e.setNext(first);
            first.setPrev(e);
            first = e;
        }
        size++;
    }

    /** Wstawia nowy element z wartością x na koniec listy. */
    public void insertAtTheEnd(int x) {
        Element e = new Element(x);
        if (last == null) {
            first = last = e;
        } else {
            last.setNext(e);
            e.setPrev(last);
            last = e;
        }
        size++;
    }

    /** Usuwa pierwszy element (jeśli istnieje). */
    public void removeFirst() {
        if (first == null) return;
        if (first == last) {
            first = last = null;
        } else {
            first = first.getNext();
            first.setPrev(null);
        }
        size--;
    }

    /** Usuwa ostatni element (jeśli istnieje). */
    public void removeLast() {
        if (last == null) return;
        if (first == last) {
            first = last = null;
        } else {
            last = last.getPrev();
            last.setNext(null);
        }
        size--;
    }

    // ——— LINIOWE (O(n)) ——————————

    /**
     * Zwraca nową listę-klon tej listy.
     */
    public Anchor clone() {
        Anchor c = new Anchor();
        Element cur = first;
        while (cur != null) {
            c.insertAtTheEnd(cur.getVal());
            cur = cur.getNext();
        }
        return c;
    }

    /**
     * Odwraca kolejność elementów "in place".
     */
    public void revert() {
        Element cur = first;
        while (cur != null) {
            Element tmp = cur.getPrev();
            cur.setPrev(cur.getNext());
            cur.setNext(tmp);
            cur = cur.getPrev();  // bo next/prev już zamienione
        }
        // Zamiana wskaźników first <-> last
        Element tmp = first;
        first = last;
        last  = tmp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Element cur = first;
        while (cur != null) {
            sb.append(cur.getVal());
            if (cur.getNext() != null) sb.append(", ");
            cur = cur.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Anchor)) return false;
        Anchor other = (Anchor) o;
        if (this.size != other.size) return false;
        Element a = this.first, b = other.first;
        while (a != null) {
            if (a.getVal() != b.getVal()) return false;
            a = a.getNext();
            b = b.getNext();
        }
        return true;
    }
}
