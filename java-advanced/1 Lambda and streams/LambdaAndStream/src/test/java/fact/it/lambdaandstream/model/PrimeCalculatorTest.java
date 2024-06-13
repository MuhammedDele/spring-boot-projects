package fact.it.lambdaandstream.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeCalculatorTest {

    @Test
    void isPrime() {
        PrimeCalculator pc = new PrimeCalculator();
        assertTrue(pc.isPrime(2));
        assertFalse(pc.isPrime(0));
        assertFalse(pc.isPrime(1));

    }

    @Test
    void getListOfAllNumbersUntil() {
        PrimeCalculator pc = new PrimeCalculator();
        List<Integer> numbers = Arrays.asList(0,1,2,3,4,5);
        assertEquals(numbers,pc.getListOfAllNumbersUntil(0,5));

    }

    @Test
    void getAllPrimesUntil() {
        PrimeCalculator pc = new PrimeCalculator();
        List<Integer> numbers = Arrays.asList(2,3,5,7);
        assertEquals(numbers,pc.getAllPrimesUntil(7));
    }
}