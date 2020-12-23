
package tests;

import logic.data.EnumGenders;
import logic.data.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


class UserTest {

    @Test
    public void getName() {
        User user = new User("Filipe", "a123@isec.pt", EnumGenders.MALE, 20, 0);
        assertEquals("Filipe", user.getName());
    }

    @Test
    void setName() {
        User user = new User("Filipe", "a123@isec.pt", EnumGenders.MALE, 20, 0);
        user.setName("Leonardo");
        assertEquals("Leonardo", user.getName());
        assertTrue(user.getName().length() < 20);
        assertTrue(user.getName().length() > 1);
    }

    @Test
    void getEmail() {
        User user = new User("Filipe", "a123@isec.pt", EnumGenders.MALE, 20, 0);
        assertEquals(user.getEmail(), "a123@isec.pt");
        assertTrue(user.getEmail().contains("@"));
    }

    @Test
    void setEmail() {
        User user = new User("Filipe", "a123@isec.pt", EnumGenders.MALE, 20, 0);
        user.setEmail("a321@hotmail.com");
        assertEquals(user.getEmail(), "a321@hotmail.com");
        assertTrue(user.getEmail().contains("@"));
    }

    @Test
    void getGender() {
        User user = new User("Filipe", "a123@isec.pt", EnumGenders.MALE, 20, 0);
        assertEquals(EnumGenders.MALE, user.getGender());
    }

    @Test
    void setGender() {
        User user = new User("Filipe", "a123@isec.pt", EnumGenders.MALE, 20, 0);
        assertTrue(user.getAge() > 0);
        assertEquals(20, user.getAge());
    }

    @Test
    void getAge() {
        User user = new User("Filipe", "a123@isec.pt", EnumGenders.MALE, 20, 0);
        assertTrue(user.getAge() > 0);
        assertEquals(20, user.getAge());

    }

    @Test
    void setAge() {
        User user = new User("Filipe", "a123@isec.pt", EnumGenders.MALE, 20, 0);
        user.setAge(30);
        assertTrue(user.getAge() < 120);
        assertTrue(user.getAge() > 18);
    }

    @Test
    void getTotalBets() {

    }

    @Test
    void testToString() {

    }
}
