package tests;

import logic.data.Notifications;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationsTest {


    @Test
    void getLimitMoneyDay() {
        Notifications notificacoes = new Notifications();
        assertEquals(0.0f, notificacoes.getLimitMoneyDay());
    }

    @Test
    void getLimitLossWeek() {
        Notifications notificacoes = new Notifications();
        assertEquals(0.0f, notificacoes.getLimitLossWeek());
    }

    @Test
    void getMinimumMoneyMonth() {
        Notifications notificacoes = new Notifications();
        assertEquals(0.0f, notificacoes.getMinimumMoneyMonth());
    }

    @Test
    void getReminderBetDay() {
        Notifications notificacoes = new Notifications();
        assertEquals(0.0f, notificacoes.getReminderBetDay());
    }

    @Test
    void isFlagLimitMoneyDay() {
        Notifications notificacoes = new Notifications();
        assertEquals(false, notificacoes.isFlagLimitMoneyDay());
    }

    @Test
    void isFlagLimitLossWeek() {
        Notifications notificacoes = new Notifications();
        assertEquals(false, notificacoes.isFlagLimitLossWeek());
    }

    @Test
    void isFlagMinimumMoneyMonth() {
        Notifications notificacoes = new Notifications();
        assertEquals(false, notificacoes.isFlagMinimumMoneyMonth());
    }

    @Test
    void isFlagReminderBetDay() {
        Notifications notificacoes = new Notifications();
        assertEquals(false, notificacoes.isFlagReminderBetDay());
    }

    @Test
    void isFlagResultsReminder() {
        Notifications notificacoes = new Notifications();
        assertEquals(false, notificacoes.isFlagResultsReminder());
    }

    @Test
    void setLimitMoneyDay() {
        Notifications notificacoes = new Notifications();
        notificacoes.setLimitMoneyDay(30.5f);
        assertEquals(30.5f, notificacoes.getLimitMoneyDay());
    }

    @Test
    void setLimitLossWeek() {
        Notifications notificacoes = new Notifications();
        notificacoes.setLimitLossWeek(47.5f);
        assertEquals(47.5f, notificacoes.getLimitLossWeek());
    }

    @Test
    void setMinimumMoneyMonth() {
        Notifications notificacoes = new Notifications();
        notificacoes.setMinimumMoneyMonth(25.5f);
        assertEquals(25.5f, notificacoes.getMinimumMoneyMonth());
    }

    @Test
    void setReminderBetDay() {
        Notifications notificacoes = new Notifications();
        notificacoes.setReminderBetDay(11.5f);
        assertEquals(11.5f, notificacoes.getReminderBetDay());
    }

    @Test
    void setFlagLimitMoneyDay() {
        Notifications notificacoes = new Notifications();
        notificacoes.setFlagLimitMoneyDay(true);
        assertEquals(true, notificacoes.isFlagLimitMoneyDay());
    }

    @Test
    void setFlagLimitLossWeek() {
        Notifications notificacoes = new Notifications();
        notificacoes.setFlagLimitLossWeek(true);
        assertEquals(true, notificacoes.isFlagLimitLossWeek());
    }

    @Test
    void setFlagMinimumMoneyMonth() {
        Notifications notificacoes = new Notifications();
        notificacoes.setFlagMinimumMoneyMonth(true);
        assertEquals(true, notificacoes.isFlagMinimumMoneyMonth());
    }

    @Test
    void setFlagReminderBetDay() {
        Notifications notificacoes = new Notifications();
        notificacoes.setFlagReminderBetDay(true);
        assertEquals(true, notificacoes.isFlagReminderBetDay());
    }

    @Test
    void setFlagResultsReminder() {
        Notifications notificacoes = new Notifications();
        notificacoes.setFlagResultsReminder(true);
        assertEquals(true, notificacoes.isFlagResultsReminder());
    }
}