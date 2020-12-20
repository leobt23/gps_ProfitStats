package gps;

public class Bet {
    int numberOfGames, numberOfBets;
    String betRegisterDate;
    String betCloseDate;
    float totalValueBetted, possibleWinnings;
    String betName;

    public Bet(int numberOfGames, int numberOfBets, String betRegisterDate, String betCloseDate, float totalValueBetted, float possibleWinnings, String betName) {
        this.numberOfGames = numberOfGames;
        this.numberOfBets = numberOfBets;
        this.betRegisterDate = betRegisterDate;
        this.betCloseDate = betCloseDate;
        this.totalValueBetted = totalValueBetted;
        this.possibleWinnings = possibleWinnings;
        this.betName = betName;
    }

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
