package logic;

import logic.data.Data;
import logic.data.Time;
import logic.states.EnumStates;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;
import java.util.List;

public class ObservableModel {

    //TODO: Errado -> nao guarda o objeto Data mas sim um objeto que engloba a data, por exemplo Model
    private Data data = new Data();

    private PropertyChangeSupport propertyChangeSupport;

    public ObservableModel(){
        //TODO: Mudar para observar o Model
        propertyChangeSupport = new PropertyChangeSupport(data);
    }

    private void fireEvents(List<String> events) {
        events.forEach(e -> propertyChangeSupport.firePropertyChange(e, null, null));
    }

    public void addPropertyChangeListener(String property, PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.addPropertyChangeListener(property, propertyChangeListener);
    }

    public int getNumberOfBets(){
        return 0;
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
//        return model.getState();
        return null;
    }

    public boolean verifyInputBetRegistry(String numOfGamesBettedValue, LocalDate registDateValue, LocalDate closeDateValue, String totalValueBettedValue, String possibleWinningsValue, String numberOfBetsValue, String betNameValue, EnumBetStatus enumBetStatus) {
        return data.verifyInputBetRegistry(numOfGamesBettedValue,registDateValue,closeDateValue,totalValueBettedValue,possibleWinningsValue,numberOfBetsValue,betNameValue,enumBetStatus);
    }
}
