package gps;
import java.util.ArrayList;

public class BettingHistory {
    ArrayList<Bet> bets = new ArrayList<>();
    float percentWins, percentLosses;
    float moneyStats;

    public BettingHistory(ArrayList<Bet> bets, float percentWins, float percentLosses, float moneyStats) {
        this.bets = bets;
        this.percentWins = percentWins;
        this.percentLosses = percentLosses;
        this.moneyStats = moneyStats;
    }

    public ArrayList<Bet> getBets() {
        return bets;
    }

    public void setBets(ArrayList<Bet> bets) {
        this.bets = bets;
    }

    public float getPercentWins() {
        return percentWins;
    }

    public void setPercentWins(float percentWins) {
        this.percentWins = percentWins;
    }

    public float getPercentLosses() {
        return percentLosses;
    }

    public void setPercentLosses(float percentLosses) {
        this.percentLosses = percentLosses;
    }

    public float getMoneyStats() {
        return moneyStats;
    }

    public void setMoneyStats(float moneyStats) {
        this.moneyStats = moneyStats;
    }

    @Override
    public String toString() {
        return "BettingHistory{" +
                "bets=" + bets +
                ", percentWins=" + percentWins +
                ", percentLosses=" + percentLosses +
                ", moneyStats=" + moneyStats +
                '}';
    }
}
