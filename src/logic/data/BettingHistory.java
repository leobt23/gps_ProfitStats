package logic.data;
import logic.EnumBetStatus;

import java.util.ArrayList;

public class BettingHistory {
    ArrayList<Bet> bets = new ArrayList<>();
    float percentWins = 0.0f, percentLosses = 0.0f;
    float moneyStats = 0.0f;

    public BettingHistory( ) { }

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

    public boolean addBetToHistory(Bet aux){
        if(bets.add(aux))
            return true;
        else
            return false;
    }

    public boolean changeBetInHistory(int id, int ngames, int nbets, String betRDate, String betCDate,
                                      float totalValueB, float possibleW, String nameBet, EnumBetStatus status){
        for(int i=0; i<bets.size(); i++){
            if(bets.get(i).getBetId() == id){
                bets.get(i).setNumberOfGames(ngames);
                bets.get(i).setNumberOfBets(nbets);
                bets.get(i).setBetRegisterDate(betRDate);
                bets.get(i).setBetCloseDate(betCDate);
                bets.get(i).setTotalValueBetted(totalValueB);
                bets.get(i).setPossibleWinnings(possibleW);
                bets.get(i).setBetName(nameBet);
                bets.get(i).setStatus(status);
                return true;
            }
        }
        return false;
    }

    public Bet findBet(int id){

        if(bets.isEmpty())
            return null;

        for(int i=0; i < bets.size(); i++){
            if(bets.get(i).getBetId() == id)
                return bets.get(i);
        }

        return null;
    }

    public void removeBet(int idBet) {
        if(findBet(idBet) != null){
            bets.remove(findBet(idBet));
        }
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

