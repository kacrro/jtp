package egzamin;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Jeden plik z klasami: Klub, Drużyna, Gracz.
 * Zamiast własnego wyjątku używamy NoSuchElementException (unchecked).
 */

public class Main {
    public static void main(String[] args) {
        Klub klub = new Klub("FC Example");
        Drużyna a = new Drużyna("Drużyna A");
        Drużyna b = new Drużyna("Drużyna B");
        klub.getDrużyny().add(a);
        klub.getDrużyny().add(b);

        Gracz jan = new Gracz("Jan", klub);
        Gracz ola = new Gracz("Ola", klub);

        // Jan należy do A i B, Ola do żadnej → rzuci wyjątek
        System.out.println("Jan należy do: " + jan.nalezyDoDruzyn());
        System.out.println("Ola należy do: " + ola.nalezyDoDruzyn());
    }
}

class Klub {
    private String nazwa;
    private List<Drużyna> drużyny = new ArrayList<>();

    public Klub(String nazwa) {
        this.nazwa = nazwa;
    }
    public String getNazwa()         { return nazwa; }
    public List<Drużyna> getDrużyny(){ return drużyny; }
    @Override public String toString(){ return nazwa; }
}

class Drużyna {
    private String nazwa;
    private List<Gracz> gracze = new ArrayList<>();

    public Drużyna(String nazwa) {
        this.nazwa = nazwa;
    }
    public String getNazwa()        { return nazwa; }
    public List<Gracz> getGracze()  { return gracze; }
    @Override public String toString(){ return nazwa; }
}

class Gracz {
    private String imię;
    private Klub klub;

    public Gracz(String imię, Klub klub) {
        this.imię = imię;
        this.klub = klub;
    }

    /**
     * Zwraca listę drużyn, w których jest ten gracz.
     * Jeśli nie należy do żadnej, rzuca NoSuchElementException.
     */
    public List<Drużyna> nalezyDoDruzyn() {
        List<Drużyna> wynik = new ArrayList<>();
        for (Drużyna d : klub.getDrużyny()) {
            if (d.getGracze().contains(this)) {
                wynik.add(d);
            }
        }
        if (wynik.isEmpty()) {
            throw new NoSuchElementException(
                    imię + " nie należy do żadnej drużyny w klubie " + klub);
        }
        return wynik;
    }

    @Override public String toString() {
        return imię;
    }
}