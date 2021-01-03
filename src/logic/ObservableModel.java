package logic;

import logic.data.Model;
import logic.data.Time;
import logic.states.EnumStates;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ObservableModel {
    private Model model = new Model();
    private PropertyChangeSupport propertyChangeSupport;

    public ObservableModel(){
        propertyChangeSupport = new PropertyChangeSupport(model);
        try {
            model = (Model) FileUtility.retrieveModelFromFile();
            if (model == null) {
                model = new Model();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
        //TODO: Tratar excecao
        try {
            FileUtility.saveModelToFile(model);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    }
    public String getUserEmail() {
        return model.getUserEmail();
    }

    public String getUserName() { return model.getUserName(); }

    public String getUserAge() { return model.getUserAge();}

    public String getUserTotalBets() { return model.getUserTotalBets();}

    public String getUserGender() { return model.getUserGender();}

    public String getUserTotalProfit() { return model.getUserTotalProfit(); }

    public String getUserHightestWin() { return model.getUserHighestwin(); }
}
