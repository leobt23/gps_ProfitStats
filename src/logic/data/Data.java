package logic.data;

import logic.Status;

public class Data {
    private User user;

    /*public Data(User user, BettingHistory bettingHistory, Time time){
        this.user = user;
        this.bettingHistory = bettingHistory;
        this.time = time;
    }*/

    public Data() {

    }

    public void setUser(User user) {
        this.user = user;
    }

    //TODO: fazer funções
    public String getBetName(int idx) {
        return "";
    }

    public String getBetRegistryDate(int idx) {
        return "";
    }

    public String getBetNumberOfGames(int idx) {
        return "";
    }

    public String getBetNumberOfBets(int idx) {
        return "";
    }

    public String getBetValueBetted(int idx) {
        return "";
    }

    public String getBetPossibleWinnings(int idx) {
        return "";
    }

    public Status getBetStatus(int idx) {
        return null;
    }

    public int getBetId(int idx) {
        return -1;
    }

    public String getBetCloseDate(int idx) {
        return "";
    }

    public void setBetStatus(int betId, Status status) {

    }
}
