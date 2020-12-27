package tests;

import logic.EnumBetStatus;
import logic.EnumBetStatus;
import logic.data.Bet;
import logic.data.Time;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BetTest {

    @Test
    void getBetId() {
      /*  Bet bet = new Bet (2,2,"10/10/2020", "12/10/2020", 1, 5, "betnr1");
        assertEquals(bet.getBetId(), conta);*/
    }

    @Test
    void getNumberOfGames() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        Time tempo2 = new Time(2020, 11,1, 23, 11,30,27);
        Bet bet = new Bet (2,2,tempo, tempo2, 1, 5, "betnr1", EnumBetStatus.LOST);
        assertEquals(bet.getNumberOfGames(), 2);
    }

    @Test
    void setNumberOfGames() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        Time tempo2 = new Time(2020, 11,1, 23, 11,30,27);
        Bet bet = new Bet (2,2,tempo, tempo2, 1, 5, "betnr1", EnumBetStatus.LOST);
        bet.setNumberOfGames(10);
        assertEquals(bet.getNumberOfGames(), 10);
    }

    @Test
    void getNumberOfBets() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        Time tempo2 = new Time(2020, 11,1, 23, 11,30,27);
        Bet bet = new Bet (2,2,tempo, tempo2, 1, 5, "betnr1", EnumBetStatus.LOST);
        assertEquals(bet.getNumberOfBets(), 2);
    }

    @Test
    void setNumberOfBets() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        Time tempo2 = new Time(2020, 11,1, 23, 11,30,27);
        Bet bet = new Bet (2,2,tempo, tempo2, 1, 5, "betnr1", EnumBetStatus.LOST);
        bet.setNumberOfBets(100);
        assertEquals( 100, bet.getNumberOfBets());
    }

    @Test
    void getBetRegisterDate() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        Time tempo2 = new Time(2020, 11,1, 23, 11,30,27);
        tempo2.getCurrentDate();
        Bet bet = new Bet (2,2,tempo, tempo2, 1, 5, "betnr1", EnumBetStatus.LOST);
        assertEquals(tempo, bet.getBetRegisterDate());
    }

    @Test
    void setBetRegisterDate() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        Time tempo2 = new Time(2020, 11,1, 23, 11,30,27);
        Bet bet = new Bet (2,2,tempo, tempo2, 1, 5, "betnr1", EnumBetStatus.LOST);
        Time tempo3 = new Time(2020, 10,1, 27, 21,30,00);
        bet.setBetRegisterDate(tempo3);
        assertEquals(tempo3, bet.getBetRegisterDate());
    }

    @Test
    void getBetCloseDate() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        Time tempo2 = new Time(2020, 11,1, 23, 11,30,27);
        Bet bet = new Bet (2,2,tempo, tempo2, 1, 5, "betnr1", EnumBetStatus.LOST);
        assertEquals(tempo2,bet.getBetCloseDate());
    }

    @Test
    void setBetCloseDate() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        Time tempo2 = new Time(2020, 11,1, 23, 11,30,27);
        Bet bet = new Bet (2,2,tempo, tempo2, 1, 5, "betnr1", EnumBetStatus.LOST);
        Time tempo3 = new Time(2021, 12,1, 27, 21,30,00);
        bet.setBetCloseDate(tempo3);
        assertEquals(tempo3, bet.getBetCloseDate());
    }

    @Test
    void getTotalValueBetted() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        Time tempo2 = new Time(2020, 11,1, 23, 11,30,27);
        Bet bet = new Bet (2,2,tempo, tempo2, 1, 5, "betnr1", EnumBetStatus.LOST);
        assertEquals(1,bet.getTotalValueBetted());
    }

    @Test
    void setTotalValueBetted() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        Time tempo2 = new Time(2020, 11,1, 23, 11,30,27);
        Bet bet = new Bet (2,2,tempo, tempo2, 1, 5, "betnr1", EnumBetStatus.LOST);
        bet.setTotalValueBetted(200);
        assertEquals(200,bet.getTotalValueBetted());
    }

    @Test
    void getPossibleWinnings() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        Time tempo2 = new Time(2020, 11,1, 23, 11,30,27);
        Bet bet = new Bet (2,2,tempo, tempo2, 1, 5, "betnr1", EnumBetStatus.LOST);
        assertEquals(5,bet.getPossibleWinnings());
    }

    @Test
    void setPossibleWinnings() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        Time tempo2 = new Time(2020, 11,1, 23, 11,30,27);
        Bet bet = new Bet (2,2,tempo, tempo2, 1, 5, "betnr1", EnumBetStatus.LOST);
        bet.setPossibleWinnings(200);
        assertEquals(200,bet.getPossibleWinnings());
    }

    @Test
    void getBetName() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        Time tempo2 = new Time(2020, 11,1, 23, 11,30,27);
        Bet bet = new Bet (2,2,tempo, tempo2, 1, 5, "betnr1", EnumBetStatus.LOST);
        assertEquals("betnr1",bet.getBetName());
    }

    @Test
    void setBetName() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        Time tempo2 = new Time(2020, 11,1, 23, 11,30,27);
        Bet bet = new Bet (2,2,tempo, tempo2, 1, 5, "betnr1", EnumBetStatus.LOST);
        bet.setBetName("betnr1000");
        assertEquals("betnr1000",bet.getBetName());
    }


    @Test
    void testToString() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        Time tempo2 = new Time(2020, 11,1, 23, 11,30,27);
        Bet bet = new Bet (2,2,tempo, tempo2, 1, 5, "betnr1", EnumBetStatus.LOST);
        assertEquals("Bet{"   +
                "numberOfGames="      + bet.getNumberOfGames() +
                ", numberOfBets="     + bet.getNumberOfBets() +
                ", betRegisterDate="  + bet.getBetRegisterDate() +
                ", betCloseDate="     + bet.getBetCloseDate() +
                ", totalValueBetted=" + bet.getTotalValueBetted() +
                ", possibleWinnings=" + bet.getPossibleWinnings() +
                ", betName='"         + bet.getBetName() + '\'' +
                '}',bet.toString());
    }


    @Test
    void getStatus() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        Time tempo2 = new Time(2020, 11,1, 23, 11,30,27);
        Bet bet = new Bet (2,2,tempo, tempo2, 1, 5, "betnr1", EnumBetStatus.LOST);
        assertEquals(EnumBetStatus.LOST, bet.getStatus());
    }

    @Test
    void setStatus() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        Time tempo2 = new Time(2020, 11,1, 23, 11,30,27);
        Bet bet = new Bet (2,2,tempo, tempo2, 1, 5, "betnr1", EnumBetStatus.LOST);
        bet.setStatus(EnumBetStatus.WON);
        assertEquals(EnumBetStatus.WON, bet.getStatus());
    }
}