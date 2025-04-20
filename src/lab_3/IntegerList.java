package lab_3;

public class IntegerList {
    public static void main(String[] args) {
        Anchor list = new Anchor();
        System.out.println("Lista na początku: \n"+list);
        //testowanie metod
        list.insertAtTheFront(3);
        list.insertAtTheFront(2);
        list.insertAtTheFront(1);

        System.out.println("Po dodaniu elementow 1, 2, 3 na poczatek: \n"+list);

        list.insertAtTheBack(4);
        list.insertAtTheBack(5);
        list.insertAtTheBack(6);

        System.out.println("\nPo dodaniu elementow 4, 5, 6, na koniec: \n" + list);
        list.removeLast();
        System.out.println("\nPo usunięciu jednej liczby z konca: \n" + list);

        list.removeFirst();
        System.out.println("\nPo usunięciu jednej liczby z początku: \n" + list);



    }


}
