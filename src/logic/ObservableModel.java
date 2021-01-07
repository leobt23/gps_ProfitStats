package logic;

import logic.data.EnumGenders;
import logic.data.EnumWrongInputNotifications;
import logic.data.Model;
import logic.data.Time;
import logic.states.EnumStates;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ObservableModel {
    private Model model = new Model();
    private PropertyChangeSupport propertyChangeSupport;

    public ObservableModel(){
        propertyChangeSupport = new PropertyChangeSupport(model);
        model = (Model) FileUtility.retrieveModelFromFile();
        if (model == null) {
            model = new Model();
        }
    }

    private void fireEvents(List<String> events) {
        events.forEach(e -> propertyChangeSupport.firePropertyChange(e, null, null));
    }

    public void addPropertyChangeListener(String property, PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.addPropertyChangeListener(property, propertyChangeListener);
    }

    public int getNumberOfBets(){
        return model.getNumberOfBets();
    }

    public String getBetName(int idx) {
        return model.getBetName(idx);
    }

    public Time getBetRegistryDate(int idx) {
        return model.getBetRegistryDate(idx);
    }

    public String getBetRegistryDateWithBars(int idx) {
        return model.getBetRegistryDateWithBars(idx);
    }

    public int getBetNumberOfGames(int idx) {
        return model.getBetNumberOfGames(idx);
    }

    public int getBetNumberOfBets(int idx) {
        return model.getBetNumberOfBets(idx);
    }

    public float getBetValueBetted(int idx) {
        return model.getBetValueBetted(idx);
    }

    public float getBetPossibleWinnings(int idx) {
        return model.getBetPossibleWinnings(idx);
    }

    public EnumBetStatus getBetStatus(int idx) {
        return model.getBetStatus(idx);
    }

    public int getBetId(int idx) {
        return model.getBetId(idx);
    }

    public Time getBetCloseDate(int idx) {
        return model.getBetCloseDate(idx);
    }

    public String getBetCloseDateWithBars(int idx) {
        return model.getBetCloseDateWithBars(idx);
    }

    public void setBetStatus(int betId, EnumBetStatus enumBetStatus) {
        model.setBetStatus(betId, enumBetStatus);
        FileUtility.saveModelToFile(model);
    }

    public EnumStates getState() {
        return model.getState();
    }

    public boolean verifyInputBetRegistry(String numOfGamesBettedValue, LocalDate registDateValue, LocalDate closeDateValue, String totalValueBettedValue, String possibleWinningsValue, String numberOfBetsValue, String betNameValue, EnumBetStatus enumBetStatus) {
        return model.verifyInputBetRegistry(numOfGamesBettedValue,registDateValue,closeDateValue,totalValueBettedValue,possibleWinningsValue,numberOfBetsValue,betNameValue,enumBetStatus);
    }
    public ArrayList<EnumWrongInputBetRegistry> getWrongInputBetRegistry(){
        return model.getWrongInputBetRegistry();
    }

    public void addNewBet(String numOfGamesBettedValue, LocalDate registDateValue, LocalDate closeDateValue, String totalValueBettedValue, String possibleWinningsValue, String numberOfBetsValue, String betNameValue, EnumBetStatus enumBetStatus) {
        model.addNewBet(numOfGamesBettedValue,registDateValue,
                closeDateValue,totalValueBettedValue,possibleWinningsValue,
                numberOfBetsValue,betNameValue, enumBetStatus);
        FileUtility.saveModelToFile(model);
    }

    public float getTotalProfit() {
        return model.getTotalProfit();
    }

    public void moveToStatistics() {
        fireEvents(model.moveToStatistics());
    }

    public void moveToBetRegistry() {
        fireEvents(model.moveToBetRegistry());
    }
    public void moveToNotifications() { fireEvents(model.moveToNotifications()); }

    public ArrayList<Integer> numberOfBetsMonth() {
        return model.numberOfBetsMonth();
    }

    public ArrayList<Float> getWonMoneyCurrentMonth() {
        return model.getWonMoneyCurrentMonth();
    }

    public float getHighestWin() {
        return model.getHighestWin();
    }

    public ArrayList<Float> getLostMoneyCurrentMonth() {
        return model.getLostMoneyCurrentMonth();
    }

    public String getBestMonth() {
        return model.getBestMonth();
    }

    public float getWinningPercentage() {
        return model.getWinningPercentage();
    }

    public void moveToUserProfile() {
        fireEvents(model.moveToUserProfile());
    }

    public void moveToBetsHistory() {
        fireEvents(model.moveToBetsHistory());
    }

    public void deleteBet(int idx) {
        model.deleteBet(idx);
    }

    public void deleteBetByIdx(int idx) {
        model.deleteBetByIdx(idx);
        FileUtility.saveModelToFile(model);
    }

    public String getUserEmail() { return model.getUserEmail(); }

    public String getUserName() { return model.getUserName(); }

    public String getUserAge() { return model.getUserAge();}

    public String getUserTotalBets() { return model.getUserTotalBets();}

    public String getUserGender() { return model.getUserGender();}

    public String getUserTotalProfit() { return model.getUserTotalProfit(); }

    public String getUserHightestWin() { return model.getUserHighestwin(); }

    public void editBet(int idx, String numOfGamesBettedValue, LocalDate registDateValue, LocalDate closeDateValue, String totalValueBettedValue, String possibleWinningsValue, String numberOfBetsValue, String betNameValue, EnumBetStatus enumBetStatus) {
        model.editBet(idx,numOfGamesBettedValue,registDateValue,
                closeDateValue,totalValueBettedValue,possibleWinningsValue,
                numberOfBetsValue,betNameValue, enumBetStatus);
        FileUtility.saveModelToFile(model);
    }

    public List<EnumWrongInputUserProfile> editProfile(String userName, String email, String age, EnumGenders gender) {
        List<EnumWrongInputUserProfile> wrongInput = model.editProfile(userName, email, age, gender);
        FileUtility.saveModelToFile(model);
        return wrongInput;
    }

    public float getLimitMoneyBettedToday() { return model.getLimitMoneyBettedToday(); }

    public float getLimitLossWeek() { return model.getLimitLossWeek(); }

    public float getMinBettedMoneyWeek() { return model.getMinBettedMoneyWeek(); }

    public float getReminderToBetDay() { return model.getReminderToBetDay(); }

    public boolean getLimitMoneyBettedTodayFlag() { return model.getLimitMoneyBettedTodayFlag(); }

    public boolean getLimitLossWeekFlag() { return model.getLimitLossWeekFlag(); }

    public boolean getMinBettedMoneyWeekFlag() { return model.getMinBettedMoneyWeekFlag(); }

    public boolean getReminderToBetDayFlag() { return model.getReminderToBetDayFlag(); }

    public boolean getResultsNotificationReminder() { return model.getResultsNotificationReminder(); }

    public void setLimitMoneyDay(float value) {model.setLimitMoneyDay(value); }

    public void setLimitLossWeek(float value) {model.setLimitLossWeek(value); }

    public void setMinimumMoneyMonth(float value) { model.setMinimumMoneyMonth(value); }

    public void setReminderBetDay(float value) { model.setReminderBetDay(value); }

    public void setFlagLimitMoneyDay(boolean value) {
        if(value)
             model.setFlagLimitMoneyDay(value);
        else{
            model.setLimitMoneyDay(0.0f);
            model.setFlagLimitMoneyDay(value);
        }
    }

    public void setFlagLimitLossWeek(boolean value) {
        if(value)
            model.setFlagLimitLossWeek(value);
        else{
            model.setLimitLossWeek(0.0f);
            model.setFlagLimitLossWeek(value);
        }
    }

    public void setFlagMinimumMoneyMonth(boolean value) {
        if(value)
            model.setFlagMinimumMoneyMonth(value);
        else{
            model.setMinimumMoneyMonth(0.0f);
            model.setFlagMinimumMoneyMonth(value);
        }
    }

    public void setFlagReminderBetDay(boolean value) {
        if(value)
            model.setFlagReminderBetDay(value);
        else{
            model.setFlagReminderBetDay(value);
            model.setReminderBetDay(0.0f);
        }
    }

    public void setFlagResultsReminder(boolean value) { model.setFlagResultsReminder(value); }

    public boolean verifyInputNotifications(String limitMoneyDay, String limitLossWeek, String minimumMoneyMonth, String reminderBetDay) {
        return model.verifyInputNotifications(limitMoneyDay,limitLossWeek,minimumMoneyMonth,reminderBetDay);
    }
    public ArrayList<EnumWrongInputNotifications> getWrongInputNotifications() {
        return model.getWrongInputNotifications();
    }
    public void saveModel(){
        FileUtility.saveModelToFile(model);
    }
    public boolean getNotificationRemindMinBetDay(){ return model.getNotificationRemindMinBetDay();}
    public boolean toggleResultsReminderNotification(){ return model.toggleResultsReminderNotification();}
}
