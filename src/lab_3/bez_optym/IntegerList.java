package lab_3.bez_optym;

public class IntegerList {
    public static void main(String[] args) {
        Anchor list = new Anchor();

        // Testowanie metod
        list.insertAtTheFront(3);
        list.insertAtTheFront(2);
        list.insertAtTheFront(1);

        System.out.println("Po dodaniu elementów na początek: " + list);

        list.insertAtTheEnd(4);
        list.insertAtTheEnd(5);

        System.out.println("Po dodaniu elementów na koniec: " + list);

        list.removeFirst();
        System.out.println("Po usunięciu pierwszego elementu: " + list);

        list.removeLast();
        System.out.println("Po usunięciu ostatniego elementu: " + list);

        // Testowanie dodatkowych metod
        Anchor list2 = new Anchor();
        list2.insertAtTheFront(3);
        list2.insertAtTheFront(2);
        list2.insertAtTheEnd(4);

        Anchor list3 = list2.clone();
        System.out.println("Oryginalna lista: " + list2);
        System.out.println("Sklonowana lista: " + list3);
        System.out.println("Czy listy są równe? " + list2.equals(list3));

        list3.revert();
        System.out.println("Po odwróceniu sklonowanej listy: " + list3);
        System.out.println("Czy listy są równe po odwróceniu? " + list2.equals(list3));
    }
}