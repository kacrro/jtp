package lab_2;
//napisane troszke inaczej bardziej po mojemu
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class zad_b_2 {

    //lista
    private List<String> names;

    //konstruktor
    public zad_b_2() {
        names = new ArrayList<String>();
    }

    //dodawanie
    public void addName (String name) {
        names.add(name);
    }

    //losowanie
    public String choose(){
    if (names.isEmpty()) {
        System.out.println("list is empty");
        return null;
    }
        Random rand  = new Random();
        int index = rand.nextInt(names.size());
        return names.remove(index);
    }

    //zwracanie calej listy
    public List<String> getNames() {
        return names;
    }
    public static void main(String[] args) {

        zad_b_2 names = new zad_b_2();
        names.addName("a");
        names.addName("ab");
        names.addName("abc");
        names.addName("abcd");
        names.addName("abcde");
        System.out.println("Lista imion:\n "+names.getNames());
        String choosen = names.choose();
        System.out.println("Wybrane imie:\n "+choosen);
        //names.addName(choosen);
        System.out.println("Czy imie zostało usunięte ? lista:\n"+names.getNames());

    }


    //zwracanie main


}
