package lab_4.zad_2;

public class Factorial_1 {

/**
     * Zwraca n! jako long.
     * @param n argument, musi być >= 0
     * @return silnia n!
     * @throws MyException gdy n < 0                // poprawione @throws
     */
    public static long factorial1(int n) throws MyException {
        if (n < 0) {
            throw new MyException("Silnia jest zdefiniowana tylko dla n >= 0: " + n);
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

//3 zadanie
/* 3) jaka jest różnica między IllegalArgumentException a MyException?
*
1. Hierarchia dziedziczenia:
   - `IllegalArgumentException` dziedziczy po `RuntimeException`
   - `MyException` dziedziczy bezpośrednio po `Exception`

2. Typ wyjątku:
   - `IllegalArgumentException` to wyjątek niekontrolowany
   - `MyException` to wyjątek kontrolowany
     (wymaga jawnej obsługi lub deklaracji w sygnaturze metody)

3. Obsługa:
   - `IllegalArgumentException` nie wymaga deklaracji w sygnaturze metody ani jawnej obsługi
   - `MyException` musi być:
     - zadeklarowany w sygnaturze metody (`throws MyException`)
     - jawnie obsłużony w bloku `try-catch`

4. Zastosowanie:
   - `IllegalArgumentException` jest standardowym wyjątkiem Javy używanym do sygnalizowania nieprawidłowych argumentów
   - `MyException` to własny, niestandardowy wyjątek stworzony na potrzeby konkretnej aplikacji
*
* */
//4 zadanie
/* 4) Przetestuj metodę factorial implementując metodę main tak zeby w main metoda factorial
*byla sprawdzana za jednym razem dla ciagu liczb od -3 do 5.
*/
//5 zadanie
/* użyj metody printStackTrace do pokazania zawartosci stosu wywołań w momencie rzucania wyjątku
*/
    public static void main(String[] args) {
        // Przetestujmy zarówno wartości ujemne, jak i poprawne:
        int[] testy = { -3, -2, -1, 0, 1, 2, 3, 4, 5 };
        for (int n : testy) {
            try {
                long f = factorial1(n);
                System.out.printf("%2d! = %d%n", n, f);
            } catch (MyException ex) {
                System.out.printf("Błąd dla %2d!: %s%n", n, ex.getMessage());
                ex.printStackTrace(); // 5) pokazuje stos wywołań
            }
        }
    }
}