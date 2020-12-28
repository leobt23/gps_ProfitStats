package tests;

import jdk.jshell.Snippet;
import logic.EnumBetStatus;
import logic.data.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestBettingHistory {

    @Test
    void changeBetInHistory() {
        Time time = new Time(2021,1, 1, 1, 1,1,1);
        Time time1 = new Time(2022,2, 2, 2, 2,2,2);
        Time time2 = new Time(2023,3, 3, 3, 3,3,3);
        Time time3 = new Time(2024,4, 4, 4, 4,4,4);
        Bet bet = new Bet(2, 2, time, time1, 2, 4, "bet1", EnumBetStatus.WON);
        Bet bet2 = new Bet(2, 2, time, time1, 2, 4, "bet2", EnumBetStatus.WON);
        BettingHistory a = new BettingHistory() ;
        a.addBetToHistory(bet);
        a.addBetToHistory(bet2);
        a.changeBetInHistory(1, 3,3,time2, time3, 3, 5, "bet3", EnumBetStatus.LOST);
        assertEquals(1, bet2.getBetId());
        assertEquals(3, bet2.getNumberOfGames());
        assertEquals(3, bet2.getNumberOfBets());
        assertEquals(time2, bet2.getBetRegisterDate());
        assertEquals(time3, bet2.getBetCloseDate());
        assertEquals(3, bet2.getTotalValueBetted());
        assertEquals(5, bet2.getPossibleWinnings());
        assertEquals("bet3", bet2.getBetName());
        assertEquals(EnumBetStatus.LOST, bet2.getStatus());

        a.changeBetInHistory(-1, 80,80,time2, time3, -5, -5, "bet3sssssssssssssssssssssssssssassssssssss", EnumBetStatus.LOST);
        assertEquals(1, bet2.getBetId());
        assertEquals(3, bet2.getNumberOfGames());
        assertEquals(3, bet2.getNumberOfBets());
        assertEquals(time2, bet2.getBetRegisterDate());
        assertEquals(time3, bet2.getBetCloseDate());
        assertEquals(3, bet2.getTotalValueBetted());
        assertEquals(5, bet2.getPossibleWinnings());
        assertEquals("bet3", bet2.getBetName());
        assertEquals(EnumBetStatus.LOST, bet2.getStatus());
    }

    @Test
    void findBet() {
        Time time = new Time(2021,1, 1, 1, 1,1,1);
        Time time1 = new Time(2022,2, 2, 2, 2,2,2);
        Time time2 = new Time(2023,3, 3, 3, 3,3,3);
        Time time3 = new Time(2024,4, 4, 4, 4,4,4);
        Bet bet = new Bet(2, 2, time, time1, 2, 4, "bet1", EnumBetStatus.WON);
        Bet bet2 = new Bet(2, 2, time, time1, 2, 4, "bet2", EnumBetStatus.WON);
        BettingHistory a = new BettingHistory() ;
        a.addBetToHistory(bet);
        a.addBetToHistory(bet2);
        assertEquals(bet2 ,a.findBet(1));
        assertNotEquals(bet2 ,a.findBet(0));

    }

    @Test
    void removeBet() {
        Time time = new Time(2021,1, 1, 1, 1,1,1);
        Time time1 = new Time(2022,2, 2, 2, 2,2,2);
        Time time2 = new Time(2023,3, 3, 3, 3,3,3);
        Time time3 = new Time(2024,4, 4, 4, 4,4,4);
        Bet bet = new Bet(2, 2, time, time1, 2, 4, "bet1", EnumBetStatus.WON);
        Bet bet2 = new Bet(2, 2, time, time1, 2, 4, "bet2", EnumBetStatus.WON);
        BettingHistory a = new BettingHistory() ;
        a.addBetToHistory(bet);
        a.addBetToHistory(bet2);
        a.removeBet(1);
        assertEquals(null ,a.findBet(1));

    }
}
