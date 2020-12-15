package tests;

import gps.EnumGenders;
import gps.User;
import org.junit.Test;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void getName() {
        User user = new User("Filipe", "a123@isec.pt", EnumGenders.MALE, 20, 0);
        Assert.assertEquals("Filipe", user.getName());
    }

    @org.testng.annotations.Test
    void setName() {
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