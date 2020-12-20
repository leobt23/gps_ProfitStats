package logic.data;

public class Data {
    private User user;
    private BettingHistory bettingHistory;

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

    public void setBettingHistory(BettingHistory bettingHistory) {
        this.bettingHistory = bettingHistory;
    }

    public String getBetName(int idx) {

        return "";
    }
}
