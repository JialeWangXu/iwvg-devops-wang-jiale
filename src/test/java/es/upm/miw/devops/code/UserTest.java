package es.upm.miw.devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    void setUp(){
        user = new User("1","Jiale","Wang");
    }

    @Test
    void testConstructorAndGetters(){
        assertEquals("1",user.getId());
        assertEquals("Jiale",user.getName());
        assertEquals("Wang",user.getFamilyName());
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
    void testInitialsWithSingleCharacterName() {
        User u = new User("2", "Z", "Brown");
        assertEquals("Z.", u.initials());
    }

    @Test
    void testToString() {
        String toString = user.toString();
        assertTrue(toString.contains("id='1'"));
        assertTrue(toString.contains("name='Jiale'"));
        assertTrue(toString.contains("familyName='Wang'"));
    }

    @Test
    void testEmptyConstructor() {
        User emptyUser = new User();
        assertNull(emptyUser.getId());
        assertNull(emptyUser.getName());
        assertNull(emptyUser.getFamilyName());
    }

}
