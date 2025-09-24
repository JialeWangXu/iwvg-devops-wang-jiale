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
    void testIsProper(){
        assertTrue(new Fraction(1,2).isProper());
        assertFalse(new Fraction(3,2).isProper());
        assertFalse(new Fraction(2,2).isProper());
    }

    @Test
    void testIsImProper(){
        assertTrue(new Fraction(3,2).isImproper());
        assertFalse(new Fraction(1,2).isImproper());
        assertFalse(new Fraction(2,2).isProper());
    }

    @Test
    void testIsEquivalent(){
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        Fraction f3 = new Fraction(3, 4);
        assertTrue(f1.isEquivalent(f2));
        assertFalse(f1.isEquivalent(f3));
    }

    @Test
    void testAdd() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        Fraction result = f1.add(f2);
        // 1/2 + 1/3 = 3/6 + 2/6 = 5/6
        assertEquals(5, result.getNumerator());
        assertEquals(6, result.getDenominator());
    }

    @Test
    void testMultiply() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(3, 4);
        Fraction result = f1.multiply(f2);
        // 2/3 * 3/4 = 6/12
        assertEquals(6, result.getNumerator());
        assertEquals(12, result.getDenominator());
    }

    @Test
    void testDivide() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(3, 4);
        Fraction result = f1.divide(f2);
        // 2/3 ÷ 3/4 = 2/3 * 4/3 = 8/9
        assertEquals(8, result.getNumerator());
        assertEquals(9, result.getDenominator());
    }

    @Test
    void testDivideByZeroFractionThrows() {
        Fraction f1 = new Fraction(1, 2);
        Fraction zero = new Fraction(0, 1);
        assertThrows(ArithmeticException.class, () -> f1.divide(zero));
    }

    @Test
    void testToString() {
        Fraction fraction = new Fraction(7, 8);
        String result = fraction.toString();
        assertTrue(result.contains("numerator=7"));
        assertTrue(result.contains("denominator=8"));
    }
}
