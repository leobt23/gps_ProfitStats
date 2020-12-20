import logic.data.BettingHistory;
import logic.data.Time;
import logic.data.User;

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
