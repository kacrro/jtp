package lab_3;

public class Element {
    private int val;
    private Element next;

    //konstruktor
    public Element(int val) {
        this.val = val;
        this.next = null; // wartość początkowa
    }

    //gettery
    public int getVal() {
        return val;
    }
    public Element getNext() {
        return next;
    }

    //settery
    public void setVal(int val) {
        this.val = val;
    }
    public void setNext(Element next) {
        this.next = next;
    }


}
