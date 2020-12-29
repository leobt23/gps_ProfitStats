
package tests;

import logic.data.Bet;
import logic.data.EnumGenders;
import logic.data.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
        user.setName("Leonardo Rafael Amado Brito");
        assertEquals("Leonardo", user.getName());
        user.setName(null);
        assertEquals("Leonardo", user.getName());
        user.setName("");
        assertEquals("Leonardo", user.getName());

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
    }

    @Test
    void getAge() {
        User user = new User("Filipe", "a123@isec.pt", EnumGenders.MALE, 20, 0);
        assertEquals(20, user.getAge());

    }

    @Test
    void setAge() {
        User user = new User("Filipe", "a123@isec.pt", EnumGenders.MALE, 20, 0);
        user.setAge(30);
        assertEquals(30, user.getAge());
        user.setAge(300);
        assertEquals(30, user.getAge());
        user.setAge(17);
        assertEquals(30, user.getAge());
    }

  /*  @Test
    void getTotalBets() {
        User user = new User("Filipe", "a123@isec.pt", EnumGenders.MALE, 20, 2);
        Bet bet1 = new Bet(2, 2, "10/12/2021", "11/12/2021", 2, 4, "bet1", Status.WON);
        Bet bet2 = new Bet(2, 2, "10/12/2021", "11/12/2021", 2, 4, "bet1", Status.WON);
        assertEquals(2, user.getTotalBets());
    }
   */
}
