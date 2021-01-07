package logic.data;

import logic.EnumBetStatus;
import logic.EnumWrongInputBetRegistry;
import logic.EnumWrongInputUserProfile;
import logic.states.Notifications;
import logic.states.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Model implements Serializable {

    private static final long serialVersionUID = 1L;

    private Data data;
    private IState state;
    private List<String> events;

    public Model() {
        data = new Data();
        state = new BetRegistry(data);
        events = new ArrayList<>();
    }

    private void setState(IState next) {
        IState previous = state;
        state = next;
        if (previous != next) {
            events.add(PropertyChanges.STATE_CHANGE);
            events.add(PropertyChanges.ALERT_REMINDER);
        }
    }

    public String getBetName(int idx) {
        return data.getBetName(idx);
    }

    public Time getBetRegistryDate(int idx) {
        return data.getBetRegistryDate(idx);
    }

    public String getBetRegistryDateWithBars(int idx) {
        return data.getBetRegistryDateWithBars(idx);
    }

    public int getBetNumberOfGames(int idx) {
        return data.getBetNumberOfGames(idx);
    }

    public int getBetNumberOfBets(int idx) {
        return data.getBetNumberOfBets(idx);
    }

    public float getBetValueBetted(int idx) {
        return data.getBetValueBetted(idx);
    }

    public float getBetPossibleWinnings(int idx) {
        return data.getBetPossibleWinnings(idx);
    }

    public EnumBetStatus getBetStatus(int idx) {
        return data.getBetStatus(idx);
    }

    public int getBetId(int idx) {
        return data.getBetId(idx);
    }

    public Time getBetCloseDate(int idx) {
        return data.getBetCloseDate(idx);
    }
    public String getBetCloseDateWithBars(int idx) {
        return data.getBetCloseDateWithBars(idx);
    }

    public void setBetStatus(int betId, EnumBetStatus enumBetStatus) {
        data.setBetStatus(betId, enumBetStatus);
    }

    public EnumStates getState() {
        return state.getState();
    }

    public boolean verifyInputBetRegistry(String numOfGamesBettedValue, LocalDate registDateValue, LocalDate closeDateValue, String totalValueBettedValue, String possibleWinningsValue, String numberOfBetsValue, String betNameValue, EnumBetStatus enumBetStatus) {
        return data.verifyInputBetRegistry(numOfGamesBettedValue,registDateValue,closeDateValue,totalValueBettedValue,possibleWinningsValue,numberOfBetsValue,betNameValue,enumBetStatus);
    }

    public void addNewBet(String numOfGamesBettedValue, LocalDate registDateValue, LocalDate closeDateValue, String totalValueBettedValue, String possibleWinningsValue, String numberOfBetsValue, String betNameValue, EnumBetStatus enumBetStatus) {
        data.addNewBet(numOfGamesBettedValue,registDateValue,
                closeDateValue,totalValueBettedValue,possibleWinningsValue,
                numberOfBetsValue,betNameValue, enumBetStatus);
    }

    public float getTotalProfit() {
        return data.getTotalProfit();
    }

    public List<String> moveToStatistics() {
        events.clear();
        setState(new Statistics(data));
        return events;
    }

    public List<String> moveToBetRegistry() {
        events.clear();
        setState(new BetRegistry(data));
        return events;
    }

    public List<String> moveToUserProfile() {
        events.clear();
        setState(new UserProfile(data));
        return events;
    }

    public List<String> moveToNotifications() {
        events.clear();
        setState(new Notifications(data));
        return events;
    }

    public ArrayList<EnumWrongInputBetRegistry> getWrongInputBetRegistry() {
        return data.getWrongInputBetRegistry();
    }
    public ArrayList<EnumWrongInputNotifications> getWrongInputNotifications() {
        return data.getWrongInputNotifications();
    }

    public ArrayList<Integer> numberOfBetsMonth() {
        return data.numberOfBetsMonth();
    }

    public ArrayList<Float> getWonMoneyCurrentMonth() {
        return data.getWonMoneyCurrentMonth();
    }

    public float getHighestWin() {
        return data.getHighestWin();
    }

    public ArrayList<Float> getLostMoneyCurrentMonth() {
        return data.getLostMoneyCurrentMonth();
    }

    public String getBestMonth() {
        return data.getBestMonth();
    }

    public float getWinningPercentage() {
        return data.getWinningPercentage();
    }

    public List<String> moveToBetsHistory() {
        events.clear();
        setState(new BetsHistory(data));
        return events;
    }

    public int getNumberOfBets() {
        return data.getNumberOfBets();
    }

    public void deleteBet(int idx) {
        data.deleteBet(idx);
    }

    public void deleteBetByIdx(int idx) {
        data.deleteBetByIdx(idx);
    }

    public String getUserEmail() {
        return data.getUserEmail();
    }

    public String getUserName() { return data.getUserName(); }

    public String getUserAge() { return data.getUserAge();}

    public String getUserTotalBets() { return data.getUserTotalBets();}

    public String getUserGender() { return data.getUserGender(); }

    public String getUserTotalProfit() { return data.getUserTotalProfits(); }

    public String getUserHighestwin() { return data.getUserHighestWin(); }

    public void editBet(int idx, String numOfGamesBettedValue, LocalDate registDateValue, LocalDate closeDateValue, String totalValueBettedValue, String possibleWinningsValue, String numberOfBetsValue, String betNameValue, EnumBetStatus enumBetStatus) {
        data.editBet(idx,numOfGamesBettedValue,registDateValue,
                closeDateValue,totalValueBettedValue,possibleWinningsValue,
                numberOfBetsValue,betNameValue, enumBetStatus);
    }

//    public void setBetStatidId() {
//        data.setBetStaticId();
//    }

    public List<EnumWrongInputUserProfile> editProfile(String userName, String email, String age, EnumGenders gender) {
        return data.editProfile(userName, email, age, gender);
    }

    public float getLimitMoneyBettedToday() {return data.getLimitMoneyDay(); }

    public float getLimitLossWeek() { return data.getLimitLossWeek(); }

    public float getMinBettedMoneyWeek() { return data.getMinimumMoneyMonth(); }

    public float getReminderToBetDay() { return data.getReminderBetDay(); }

    public boolean getLimitMoneyBettedTodayFlag() { return data.getFlagLimitMoneyDay(); }

    public boolean getLimitLossWeekFlag() { return data.getFlagLimitLossWeek(); }

    public boolean getMinBettedMoneyWeekFlag() { return data.getFlagMinimumMoneyMonth(); }

    public boolean getReminderToBetDayFlag() { return data.getFlagReminderBetDay(); }

    public boolean getResultsNotificationReminder() { return data.getFlagResultsReminder(); }

    public void setLimitMoneyDay(float value) { data.setLimitMoneyDay(value); }

    public void setLimitLossWeek(float value) { data.setLimitLossWeek(value); }

    public void setMinimumMoneyMonth(float value) { data.setMinimumMoneyMonth(value); }

    public void setReminderBetDay(float value) { data.setReminderBetDay(value); }

    public void setFlagLimitMoneyDay(boolean value) { data.setFlagLimitMoneyDay(value); }

    public void setFlagLimitLossWeek(boolean value) { data.setFlagLimitLossWeek(value); }

    public void setFlagMinimumMoneyMonth(boolean value) { data.setFlagMinimumMoneyMonth(value); }

    public void setFlagReminderBetDay(boolean value) { data.setFlagReminderBetDay(value); }

    public void setFlagResultsReminder(boolean value) { data.setFlagResultsReminder(value); }

    public boolean verifyInputNotifications(String limitMoneyDay, String limitLossWeek, String minimumMoneyMonth, String reminderBetDay) {
        return data.verifyInputNotifications(limitMoneyDay,limitLossWeek,minimumMoneyMonth,reminderBetDay);
    }
    public boolean getNotificationRemindMinBetDay(){ return data.getNotificationRemindMinBetDay();}
    public boolean toggleResultsReminderNotification(){ return data.toggleResultsReminderNotification();}

    public void setShown(boolean shown) {
        data.setShown(shown);
    }
    public boolean getShown(){
        return  data.getShow();
    }
    public LocalDate getNotificationDate(){
        return data.getNotificationDate();
    }

    public boolean verifyLimitMoneyBettedToday(float valueBetted) {
        return data.verifyLimitMoneyBettedToday(valueBetted);
    }

    public boolean verifyLimitLossWeek() {
        return data.verifyLimitLossWeek();
    }

    public float getLimitMoneyBettedDay() {
        return data.getLimitMoneyBettedDay();
    }
}
