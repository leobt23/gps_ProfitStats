package logic.data;

import logic.EnumBetStatus;
import logic.states.BetRegistry;
import logic.states.EnumStates;
import logic.states.IState;
import logic.states.Statistics;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Model {

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

    public List<String> moveToStatisctics() {
        events.clear();
        setState(new Statistics(data));
        return events;
    }

    public List<String> moveToBetRegistry() {
        events.clear();
        setState(new BetRegistry(data));
        return events;
    }
}
