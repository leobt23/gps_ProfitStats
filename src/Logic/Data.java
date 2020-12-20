package Logic;

import gps.BettingHistory;
import gps.Time;
import gps.User;

public class Data {
    User user;
    BettingHistory bettingHistory;
    Time time;
    public Data(User user, BettingHistory bettingHistory, Time time){
        this.user = user;
        this.bettingHistory = bettingHistory;
        this.time = time;
    }

}
