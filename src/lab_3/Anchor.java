package lab_3;

public class Anchor {
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

    //metoda wstawiająca liczbę na początek listy
    public void insertAtTheFront(int InsertedNumber) {
        Element newElement = new Element(InsertedNumber);
        newElement.setNext(first);
        first = newElement;
    }

    //metoda wstawiająca liczbę na koniec listy
    public void insertAtTheBack(int InsertedNumber) {
        Element newElement = new Element(InsertedNumber);

        if (first == null) {
            first = newElement;
            return;
        }


        //W przeciwnym przypadku przechodzimy do ostatniego elementu
        Element current = first;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        //Dołączamy nowy element na koncu listy
        current.setNext(newElement);
    }

    // metoda usuwajaca pierwszy element listy
    public void removeFirst(){
        if (first != null) {
            first = first.getNext();
        }
    }

    // metoda usuwajaca ostatni element listy
    public void removeLast() {
    //jesli lista jest pusta
        if (first == null) {
            return;
        }

        // Jeśli lista ma tylko jeden element, ustawiamy first na null.
        if (first.getNext() == null) {
            first = null;
            return;
        }

        // Znajdujemy przedostatni element.
        Element current = first;
        // Pętla zatrzyma się, gdy current będzie wskazywać na przedostatni element, czyli element, którego next ma ostatni element.
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        // Ustawiamy next przedostatniego elementu na null, przez co ostatni element zostaje usunięty.
        current.setNext(null);
    }



    //Metoda zwracająca string reprezentujący daną listę.
    @Override
    public String toString() {
        if (first == null) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        Element current = first;

        while (current != null) {
            builder.append(current.getVal());
            if (current.getNext() != null) {
            builder.append(", ");
            }

            current = current.getNext();
        }
        builder.append("]");
        return builder.toString();
    }
}
