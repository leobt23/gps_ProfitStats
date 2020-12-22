package logic.data;

import logic.Status;

public class Bet {
    int numberOfGames, numberOfBets;
    static int contador = 0;
    int betId;
    String betRegisterDate;
    String betCloseDate;
    float totalValueBetted, possibleWinnings;
    String betName;
    Status result;

    public Bet(int numberOfGames, int numberOfBets, String betRegisterDate, String betCloseDate,
               float totalValueBetted, float possibleWinnings, String betName, Status result) {
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

    public String getBetRegisterDate() {
        return betRegisterDate;
    }

    public void setBetRegisterDate(String betRegisterDate) {
        this.betRegisterDate = betRegisterDate;
    }

    public String getBetCloseDate() {
        return betCloseDate;
    }

    public void setBetCloseDate(String betCloseDate) {
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

    public void registBetDate(String date){
        if(date == null){
            Time tAux = null;
            betRegisterDate = tAux.getCurrentDate();
        }
        else
            betRegisterDate = date;
    }

    public Status getStatus() {
        return result;
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

