package logic.data;

import logic.EnumBetStatus;

import java.io.Serializable;

public class Bet implements Serializable {

    private static final long serialVersionUID = 1L;

    int numberOfGames, numberOfBets;
    static int contador = 0;
    int betId;
    Time betRegisterDate;
    Time betCloseDate;
    float totalValueBetted, possibleWinnings;
    String betName;
    EnumBetStatus result;

    public Bet(int numberOfGames, int numberOfBets, Time betRegisterDate, Time betCloseDate, float totalValueBetted, float possibleWinnings, String betName,EnumBetStatus result) {
        this.betId = contador;
        this.numberOfGames = numberOfGames;
        this.numberOfBets = numberOfBets;
        this.betRegisterDate = betRegisterDate;
        this.betCloseDate = betCloseDate;
        this.totalValueBetted = totalValueBetted;
        this.possibleWinnings = possibleWinnings;
        this.betName = betName;
        contador++;
        this.result = result;
    }

    public int getBetId(){return betId; }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public int getNumberOfBets() {
        return numberOfBets;
    }

    public void setNumberOfBets(int numberOfBets) {
        this.numberOfBets = numberOfBets;
    }

    public Time getBetRegisterDate() {
        return betRegisterDate;
    }

    public void setBetRegisterDate(Time date) {
        if(date == null){
            Time tAux = null;
            betRegisterDate = tAux;
        }
        else
            betRegisterDate = date;
    }

    public Time getBetCloseDate() {
        return betCloseDate;
    }

    public void setBetCloseDate(Time betCloseDate) {
        this.betCloseDate = betCloseDate;
    }

    public float getTotalValueBetted() {
        return totalValueBetted;
    }

    public void setTotalValueBetted(float totalValueBetted) {
        this.totalValueBetted = totalValueBetted;
    }

    public float getPossibleWinnings() {
        return possibleWinnings;
    }

    public void setPossibleWinnings(float possibleWinnings) {
        this.possibleWinnings = possibleWinnings;
    }

    public String getBetName() {
        return betName;
    }

    public void setBetName(String betName) {
        this.betName = betName;
    }


    public EnumBetStatus getStatus() {
        return result;
    }

    public void setStatus(EnumBetStatus status) {
        this.result = status;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "numberOfGames=" + numberOfGames +
                ", numberOfBets=" + numberOfBets +
                ", betRegisterDate=" + betRegisterDate +
                ", betCloseDate=" + betCloseDate +
                ", totalValueBetted=" + totalValueBetted +
                ", possibleWinnings=" + possibleWinnings +
                ", betName='" + betName + '\'' +
                '}';
    }
}

