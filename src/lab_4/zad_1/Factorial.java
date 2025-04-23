package lab_4.zad_1;

public class Factorial {

    /**
     * Zwraca n! jako long.
     * @param n argument, musi być >= 0
     * @return silnia n!
     * @throws IllegalArgumentException gdy n < 0
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Silnia jest zdefiniowana tylko dla n >= 0: " + n);
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        // poprawne wywołania
        System.out.println("5! = " + factorial(5));   // 120
        System.out.println("0! = " + factorial(0));   // 1

        // przykład obsługi wyjątku
        try {
            factorial(-3);
        } catch (IllegalArgumentException ex) {
            System.out.println("Błąd: " + ex.getMessage());
        }
    }
}
