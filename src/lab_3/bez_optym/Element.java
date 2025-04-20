package lab_3.bez_optym;

//ostatni podpunkt zrobic w oddzielnej klasie ?
//przynajmniej 2 testy dla kazdej metody
class Element {
    private int val;
    private Element next;

    public Element(int val) {
        this.val = val;
        this.next = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }
}