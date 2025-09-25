package es.upm.miw.devops.code;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

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

    //Test for 6
    @Test
    void testFindDecimalImproperFractionByUserNameFernandez(){
        List<Double> result = search.findDecimalImproperFractionByUserName("Oscar").toList();
        assertEquals(2, result.size());
        assertTrue(result.contains(2.0));
        assertTrue(result.contains(-0.5));
    }

    @Test
    void testFindDecimalImproperFractionByUserNamePaula(){
        List<Double> result = search.findDecimalImproperFractionByUserName("Paula").toList();
        assertEquals(1, result.size());
        assertTrue(result.contains(Double.POSITIVE_INFINITY));
    }

}
