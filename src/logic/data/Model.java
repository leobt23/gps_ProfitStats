package logic.data;

import logic.EnumBetStatus;
import logic.EnumWrongInputBetRegistry;
import logic.FileUtility;
import logic.states.*;
import logic.states.BetRegistry;
import logic.states.EnumStates;
import logic.states.IState;
import logic.states.Notifications;
import logic.states.Statistics;

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
        }
    }

    public String getBetName(int idx) {
        return data.getBetName(idx);
    }

    public Time getBetRegistryDate(int idx) {
        return data.getBetRegistryDate(idx);
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

    public String getUserEmail() {
        return data.getUserEmail();
    }
}
