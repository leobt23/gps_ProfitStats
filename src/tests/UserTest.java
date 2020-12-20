
package tests;

import gps.EnumGenders;
import gps.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @org.junit.jupiter.api.Test
    public void getName() {
        User user = new User("Filipe", "a123@isec.pt", EnumGenders.MALE, 20, 0);
        assertEquals("Filipe", user.getName());
        assertTrue(user.getName().length() < 20);
    }

    @org.junit.jupiter.api.Test
    void setName() {
        User user = new User("Filipe", "a123@isec.pt", EnumGenders.MALE, 20, 0);
        user.setName("Leonardo");
        assertEquals("Leonardo", user.getName());
    }

    @org.junit.jupiter.api.Test
    void getEmail() {

    }

    @org.junit.jupiter.api.Test
    void setEmail() {
    }

    @org.junit.jupiter.api.Test
    void getGender() {
    }

    @org.junit.jupiter.api.Test
    void setGender() {
    }

    @org.junit.jupiter.api.Test
    void getAge() {
        User user = new User("Filipe", "a123@isec.pt", EnumGenders.MALE, 20, 0);
        assertTrue(user.getAge() > 0);
    }

    @org.junit.jupiter.api.Test
    void setAge() {
    }

    @org.junit.jupiter.api.Test
    void getTotalBets() {
    }

    @org.junit.jupiter.api.Test
    void setTotalBets() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}
