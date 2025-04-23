package lab_3.po_optym;

public class Element {
    private int val;
    private Element next;
    private Element prev;    // dodatkowy wskaźnik do poprzednika

    public Element(int val) {
        this.val  = val;
        this.next = null;
        this.prev = null;
    }

    public int getVal()             { return val; }
    public void setVal(int val)     { this.val = val; }

    public Element getNext()        { return next; }
    public void setNext(Element n)  { this.next = n; }

    public Element getPrev()        { return prev; }
    public void setPrev(Element p)  { this.prev = p; }
}
