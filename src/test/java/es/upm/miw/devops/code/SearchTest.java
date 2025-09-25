package es.upm.miw.devops.code;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {

    Search search;

    @BeforeEach
    void setUp(){
        search = new Search();
    }

    //Test for findFractionMultiplicationByUserFamilyName (2)
    @Test
    void testFindFractionMultiplicationByUserFamilyNameTorres(){
        Fraction result =search.findFractionMultiplicationByUserFamilyName("Torres");
        assertEquals( 0, result.getNumerator());
        assertEquals(0, result.getDenominator());
    }

    @Test
    void testFindFractionMultiplicationByUserFamilyNameBlanco(){
        Fraction result =search.findFractionMultiplicationByUserFamilyName("Blanco");
        assertEquals( 0, result.getNumerator());
        assertEquals(-360, result.getDenominator());
    }

    @Test
    void testFindFractionMultiplicationByUserFamilyNameLópez(){
        Fraction result =search.findFractionMultiplicationByUserFamilyName("López");
        assertEquals( 12, result.getNumerator());
        assertEquals(-240, result.getDenominator());
    }

    @Test
    void testFindFractionMultiplicationByUserFamilyNameFernandez(){
        Fraction result =search.findFractionMultiplicationByUserFamilyName("Fernandez");
        assertEquals( 0, result.getNumerator());
        assertEquals(1, result.getDenominator());
    }

}
