package es.upm.miw.devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;
    private ArrayList<Fraction> fractions;

    @BeforeEach
    void setUp(){
        fractions = new ArrayList<>(Arrays.asList(
                new Fraction(1, 2),
                new Fraction(3, 4)
        ));
        user = new User("1","Jiale","Wang", fractions);
    }

    @Test
    void testConstructorAndGetters(){
        assertEquals("1",user.getId());
        assertEquals("Jiale",user.getName());
        assertEquals("Wang",user.getFamilyName());
        assertEquals(2, user.getFractions().size());
        assertEquals(1, user.getFractions().get(0).getNumerator());
        assertEquals(2, user.getFractions().get(0).getDenominator());
    }

    @Test
    void testSetters(){
        user.setName("Jiale2");
        user.setFamilyName("Wang2");

        assertEquals("Jiale2",user.getName());
        assertEquals("Wang2",user.getFamilyName());
    }

    @Test
    void testGetFullName(){
        assertEquals("Jiale Wang",user.fullName());
    }

    @Test
    void testGetInitials(){
        assertEquals("J.",user.initials());
    }

    @Test
    void testSetFractions() {
        List<Fraction> newFractions = new ArrayList<>();
        newFractions.add(new Fraction(5, 6));
        user.setFractions(newFractions);

        assertEquals(1, user.getFractions().size());
        assertEquals(5, user.getFractions().get(0).getNumerator());
        assertEquals(6, user.getFractions().get(0).getDenominator());
    }

    @Test
    void testAddFraction() {
        Fraction f = new Fraction(7, 8);
        user.addFraction(f);

        assertEquals(3, user.getFractions().size());
        assertTrue(user.getFractions().contains(f));
    }

    @Test
    void testInitialsWithSingleCharacterName() {
        User u = new User("2", "Z", "Brown", new ArrayList<>());
        assertEquals("Z.", u.initials());
    }

    @Test
    void testToString() {
        String result = user.toString();
        assertTrue(result.contains("id='1'"));
        assertTrue(result.contains("name='Jiale'"));
        assertTrue(result.contains("familyName='Wang'"));
        assertTrue(result.contains("fractions=["));
        assertTrue(result.contains("numerator=1"));
        assertTrue(result.contains("denominator=2"));
    }

    @Test
    void testEmptyConstructor() {
        User emptyUser = new User();
        assertNull(emptyUser.getId());
        assertNull(emptyUser.getName());
        assertNull(emptyUser.getFamilyName());
        assertNotNull(emptyUser.getFractions());
        assertTrue(emptyUser.getFractions().isEmpty());
    }

}
