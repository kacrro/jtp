package lab_3;

public class IntegerList {
    public static void main(String[] args) {
        Anchor list = new Anchor();

        // Dodajemy na początek
        list.insertAtTheFront(3);
        list.insertAtTheFront(2);
        list.insertAtTheFront(1);
        System.out.println("Po dodaniu na początek: " + list);

        // Dodajemy na koniec
        list.insertAtTheEnd(4);
        list.insertAtTheEnd(5);
        System.out.println("Po dodaniu na koniec:   " + list);

        // Usuwamy z przodu i z tyłu
        list.removeFirst();
        System.out.println("Po removeFirst():      " + list);

        list.removeLast();
        System.out.println("Po removeLast():       " + list);

        // Klonowanie i porównanie
        Anchor list2 = new Anchor();
        list2.insertAtTheFront(3);
        list2.insertAtTheFront(2);
        list2.insertAtTheEnd(4);

        Anchor list3 = list2.clone();
        System.out.println("Oryginał:              " + list2);
        System.out.println("Klon:                  " + list3);
        System.out.println("Równe?                 " + list2.equals(list3));

        // Odwracanie klona
        list3.revert();
        System.out.println("Po revert klona:       " + list3);
        System.out.println("Równe po revert?       " + list2.equals(list3));
    }
}
