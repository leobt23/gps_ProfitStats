
package tests;

import logic.data.EnumGenders;
import logic.data.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;


class UserTest {

    @Test
    public void getName() {
        User user = new User("Bet1", "a123@isec.pt", EnumGenders.MALE, 20, 0);
        assertEquals("Bet1", user.getName());
        assertTrue(user.getName().length() < 21);
    }

    @Test
    void setName() {
        User user = new User("Filipe", "a123@isec.pt", EnumGenders.MALE, 20, 0);
        user.setName("Leonardo");
        assertEquals("Leonardo", user.getName());
        assertNotEquals("Leonildo", user.getName());
        assertTrue(user.getName().length() < 21);
        assertTrue(user.getName().length() > 0);
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
        user.setGender(EnumGenders.FEMALE);
        assertEquals(EnumGenders.FEMALE, user.getGender());
        user.setGender(EnumGenders.OTHER);
        assertEquals(EnumGenders.OTHER, user.getGender());
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
        User user = new User("Filipe", "a123@isec.pt", EnumGenders.MALE, 20, 0);
        assertTrue(user.getTotalBets() >= 0);
    }

}
