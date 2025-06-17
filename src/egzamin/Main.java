package egzamin;

// Plik: Main.java

import java.util.ArrayList;
import java.util.List;

class Data {
    private int day, month, year;

    public Data(int day, int month, int year) {
        if (year < 0 || month < 1 || month > 12 || day < 1 || day > 30) {
            throw new IllegalArgumentException(
                    "Niepoprawna data: " + day + "/" + month + "/" + year);
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int toDays() {
        return year * 360 + (month - 1) * 30 + (day - 1);
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}

class Towar {
    private String name;
    private double price;
    private Data expiryDate;

    public Towar(String name, double price, Data expiryDate) {
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public int wazny(Data d) {
        int diff = expiryDate.toDays() - d.toDays();
        return diff < 0 ? -1 : diff;
    }

    @Override
    public String toString() {
        return name + " (cena: " + price + ", ważny do: " + expiryDate + ")";
    }

    public String getName() {
        return name;
    }
}

class Magazyn {
    private List<Towar> towary = new ArrayList<>();

    public void add(Towar t) {
        towary.add(t);
    }

    public List<Towar> przeterminowane(Data d) {
        List<Towar> wynik = new ArrayList<>();
        for (Towar t : towary) {
            if (t.wazny(d) == -1) {
                wynik.add(t);
            }
        }
        return wynik;
    }
}

public class Main {
    public static void main(String[] args) {
        Data today = new Data(15, 6, 2025);

        Towar mlek   = new Towar("Mleko", 2.50, new Data(10, 6, 2025));
        Towar chleb  = new Towar("Chleb", 3.00, new Data(20, 6, 2025));
        Towar ser    = new Towar("Ser",   5.00, new Data(1, 7, 2025));

        List<Towar> all = List.of(mlek, chleb, ser);

        Magazyn mag = new Magazyn();
        for (Towar t : all) {
            mag.add(t);
        }

        System.out.println("Dziś: " + today);
        System.out.println("\nPrzeterminowane towaru:");
        for (Towar t : mag.przeterminowane(today)) {
            System.out.println("  " + t);
        }

        System.out.println("\nPozostałe dni ważności:");
        for (Towar t : all) {
            int days = t.wazny(today);
            if (days >= 0) {
                System.out.printf("  %s: %d dni%n", t.getName(), days);
            }
        }
    }
}
