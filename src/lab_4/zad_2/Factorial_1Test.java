package lab_4.zad_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Factorial1Test {

    @Test
    void factorial1_negativeArguments_shouldThrowMyException() {
        int[] negatives = { -3, -2, -1 };
        for (int n : negatives) {
            try {
                // jeśli nie zostanie rzucony wyjątek – test ma nie powieść się
                Factorial_1.factorial1(n);
                fail("Expected MyException for n = " + n);
            } catch (MyException ex) {
                // OK – spodziewamy się MyException
                assertTrue(ex.getMessage().contains("n >= 0"));
            }
        }
    }

    @Test
    void factorial1_nonNegativeArguments_shouldReturnCorrectResults() {
        // każda para: {n, oczekiwany wynik}
        int[][] cases = {
                { 0, 1 },
                { 1, 1 },
                { 2, 2 },
                { 3, 6 },
                { 4, 24 },
                { 5, 120 },
                { 6, 720 }
        };

        for (int[] c : cases) {
            int n = c[0];
            long expected = c[1];
            try {
                long actual = Factorial_1.factorial1(n);
                assertEquals(expected, actual, "Incorrect factorial for n = " + n);
            } catch (MyException ex) {
                fail("Did not expect MyException for n = " + n);
            }
        }
    }
}
