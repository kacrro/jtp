package lab_3.bez_optym;

class Anchor {
    private Element first;

    public Anchor() {
        this.first = null;
    }

    public Element getFirst() {
        return first;
    }

    public void setFirst(Element first) {
        this.first = first;
    }

    // Metoda wstawiająca liczbę na początek listy
    public void insertAtTheFront(int x) {
        Element newElement = new Element(x);
        newElement.setNext(first);
        first = newElement;
    }

    // Metoda wstawiająca liczbę na koniec listy
    public void insertAtTheEnd(int x) {
        Element newElement = new Element(x);

        // Jeśli lista jest pusta, nowy element staje się pierwszym elementem
        if (first == null) {
            first = newElement;
            return;
        }

        // W przeciwnym przypadku, przechodzimy do ostatniego elementu
        Element current = first;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        // Dołączamy nowy element na końcu listy
        current.setNext(newElement);
    }

    // Metoda usuwająca pierwszy element listy
    public void removeFirst() {
        if (first != null) {
            first = first.getNext();
        }
    }

    // Metoda usuwająca ostatni element listy
    public void removeLast() {
        // Jeśli lista jest pusta, nic nie robimy
        if (first == null) {
            return;
        }

        // Jeśli lista ma tylko jeden element, usuwamy go
        if (first.getNext() == null) {
            first = null;
            return;
        }

        // W przeciwnym przypadku, przechodzimy do przedostatniego elementu
        Element current = first;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }

        // Usuwamy ostatni element
        current.setNext(null);
    }

    // Metoda zwracająca string reprezentujący daną listę
    @Override
    public String toString() {
        if (first == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Element current = first;

        while (current != null) {
            sb.append(current.getVal());

            if (current.getNext() != null) {
                sb.append(", ");
            }

            current = current.getNext();
        }

        sb.append("]");
        return sb.toString();
    }

    // Metoda sprawdzająca czy dwie listy zawierają dokładnie te same liczby w tym samym porządku
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Anchor other = (Anchor) o;

        // Porównujemy element po elemencie
        Element thisElem = this.first;
        Element otherElem = other.first;

        while (thisElem != null && otherElem != null) {
            if (thisElem.getVal() != otherElem.getVal()) {
                return false;
            }
            thisElem = thisElem.getNext();
            otherElem = otherElem.getNext();
        }

        // Jeśli obie listy dotarły do końca jednocześnie, są równe
        return thisElem == null && otherElem == null;
    }

    // Metoda tworząca głęboki klon listy
    @Override
    public Anchor clone() {
        Anchor clonedList = new Anchor();

        if (first == null) {
            return clonedList;
        }

        // Tworzymy pierwszy element klonowanej listy
        clonedList.first = new Element(first.getVal());

        // Klonujemy kolejne elementy
        Element originalCurrent = first;
        Element clonedCurrent = clonedList.first;

        while (originalCurrent.getNext() != null) {
            originalCurrent = originalCurrent.getNext();
            Element newElement = new Element(originalCurrent.getVal());
            clonedCurrent.setNext(newElement);
            clonedCurrent = clonedCurrent.getNext();
        }

        return clonedList;
    }

    // Metoda odwracająca porządek elementów na liście
    public void revert() {
        if (first == null || first.getNext() == null) {
            // Lista pusta lub ma tylko jeden element - nic nie robimy
            return;
        }

        Element prev = null;
        Element current = first;
        Element next = null;

        while (current != null) {
            next = current.getNext(); // Zapamiętujemy następny element
            current.setNext(prev);    // Odwracamy kierunek wskaźnika
            prev = current;           // Poprzedni staje się obecnym
            current = next;           // Przechodzimy do następnego elementu
        }

        first = prev; // Pierwszy element staje się ostatnim po odwróceniu
    }
}