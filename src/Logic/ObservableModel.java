package logic;

import logic.data.Data;

public class ObservableModel {

    private Data data;

    public ObservableModel(){}

    public int getNumberOfBets(){
        return 0;
    }

    public String getBetId(int idx) {
        return data.getBetName(idx);
    }

    public String getBetRegistryDate(int idx) {
        return data.getBetRegistryDate(idx);
    }

    public String getBetNumberOfGames(int idx) {
        return data.getBetNumberOfGames(idx);
    }

    public String getBetNumberOfBets(int idx) {
        return data.getBetNumberOfBets(idx);
    }

    public String getBetValueBetted(int idx) {
        return data.getBetValueBetted(idx);
    }

    public String getBetPossibleWinnings(int idx) {
        return data.getBetPossibleWinnings(idx);
    }

    public String getBetStatus(int idx) {
        return data.getBetStatus(idx);
    }

}
