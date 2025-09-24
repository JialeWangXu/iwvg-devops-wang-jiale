package es.upm.miw.devops.code;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {

    @Test
    void testConstructorWithParameters(){
        Fraction fraction = new Fraction(3,4);
        assertEquals(3,fraction.getNumerator());
        assertEquals(4,fraction.getDenominator());
    }

    @Test
    void testCOnstructorWithoutParameters(){
        Fraction fraction = new Fraction();
        assertEquals(1,fraction.getNumerator());
        assertEquals(1,fraction.getDenominator());
    }

    @Test
    void testSettersAndGetters() {
        Fraction fraction = new Fraction(2, 5);
        fraction.setNumerator(7);
        fraction.setDenominator(9);
        assertEquals(7, fraction.getNumerator());
        assertEquals(9, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        Fraction fraction = new Fraction(1, 2);
        assertEquals(0.5, fraction.decimal(), 1e-9);
    }

    @Test
    void testDecimalWithNegativeValues() {
        Fraction fraction = new Fraction(-3, 2);
        assertEquals(-1.5, fraction.decimal(), 1e-9);

        fraction = new Fraction(3, -2);
        assertEquals(-1.5, fraction.decimal(), 1e-9);

        fraction = new Fraction(-3, -2);
        assertEquals(1.5, fraction.decimal(), 1e-9);
    }

    @Test
    void testDecimalDivisionByZero() {
        Fraction fraction = new Fraction(5, 0);
        assertEquals(Double.POSITIVE_INFINITY,fraction.decimal());
    }

    @Test
    void testToString() {
        Fraction fraction = new Fraction(7, 8);
        String result = fraction.toString();
        assertTrue(result.contains("numerator=7"));
        assertTrue(result.contains("denominator=8"));
    }
}
