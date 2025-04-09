package lab_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class zad_b {
    //Atrybut do przechowywania listy nazwisk
    private List<String> names;

    // konstruktor
    public zad_b() {
        this.names = new ArrayList<String>();   //string!
    }

    //dodawanie nowego nazwiska
    public void addName(String name) {
        this.names.add(name);
    }

    /*
    * Metodda losująca nazwisko z listy i usuwająca je
    * Jeśli pusta zwraca null lub mozna dodać obsługę wyjątku
    * */
    public String choose(){
        if (names.isEmpty()) {
            System.out.println("List is already empty");
            return null;
        }
        Random rand = new Random();
        int index = rand.nextInt(names.size());
        return names.remove(index);
    }

    //zwraca zawartość listy
    public List<String> getAllNames() {
        return names;
    }

    //uzycie w mainie
    public static void main(String[] args) {

        zad_b names = new zad_b();

        //dodawanie do listy
        names.addName("John");
        names.addName("Jane");
        names.addName("Zosia");
        names.addName("Adam");
        names.addName("Ala");
        System.out.println(names.getAllNames());

        //losujemy nazwisko
        String choosen = names.choose();
        System.out.println("1) We have choosen this guy/girl: "+choosen);

        // sprawdzamy co zostało w liście
        System.out.println(names.getAllNames());

        //Losujemy ponownie
        String choosen2 = names.choose();
        System.out.println("2) We have choosen this guy/girl: "+choosen2);

        // sprawdzamy co zostało w liscie
        System.out.println(names.getAllNames());


    }


}
