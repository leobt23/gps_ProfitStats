package logic.data;

import java.io.Serial;
import java.io.Serializable;

public class Notifications implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    float limitMoneyDay, limitLossWeek, minimumMoneyMonth, reminderBetDay;
    boolean flagLimitMoneyDay, flagLimitLossWeek, flagMinimumMoneyMonth, flagReminderBetDay, flagResultsReminder;

    public Notifications() {
        this.limitMoneyDay = 0.0f;
        this.limitLossWeek = 0.0f;
        this.minimumMoneyMonth = 0.0f;
        this.reminderBetDay = 0.0f;
        this.flagLimitMoneyDay = false;
        this.flagLimitLossWeek = false;
        this.flagMinimumMoneyMonth = false;
        this.flagReminderBetDay = false;
        this.flagResultsReminder = false;
    }

    public float getLimitMoneyDay() {
        return limitMoneyDay;
    }

    public float getLimitLossWeek() {
        return limitLossWeek;
    }

    public float getMinimumMoneyMonth() {
        return minimumMoneyMonth;
    }

    public float getReminderBetDay() {
        return reminderBetDay;
    }

    public boolean isFlagLimitMoneyDay() {
        return flagLimitMoneyDay;
    }

    public boolean isFlagLimitLossWeek() {
        return flagLimitLossWeek;
    }

    public boolean isFlagMinimumMoneyMonth() {
        return flagMinimumMoneyMonth;
    }

    public boolean isFlagReminderBetDay() {
        return flagReminderBetDay;
    }

    public boolean isFlagResultsReminder() {
        return flagResultsReminder;
    }

    public void setLimitMoneyDay(float limitMoneyDay) {
        this.limitMoneyDay = limitMoneyDay;
    }

    public void setLimitLossWeek(float limitLossWeek) {
        this.limitLossWeek = limitLossWeek;
    }

    public void setMinimumMoneyMonth(float minimumMoneyMonth) {
        this.minimumMoneyMonth = minimumMoneyMonth;
    }

    public void setReminderBetDay(float reminderBetDay) {
        this.reminderBetDay = reminderBetDay;
    }

    public void setFlagLimitMoneyDay(boolean flagLimitMoneyDay) {
        this.flagLimitMoneyDay = flagLimitMoneyDay;
    }

    public void setFlagLimitLossWeek(boolean flagLimitLossWeek) {
        this.flagLimitLossWeek = flagLimitLossWeek;
    }

    public void setFlagMinimumMoneyMonth(boolean flagMinimumMoneyMonth) {
        this.flagMinimumMoneyMonth = flagMinimumMoneyMonth;
    }

    public void setFlagReminderBetDay(boolean flagReminderBetDay) {
        this.flagReminderBetDay = flagReminderBetDay;
    }

    public void setFlagResultsReminder(boolean flagResultsReminder) {
        this.flagResultsReminder = flagResultsReminder;
    }


}
