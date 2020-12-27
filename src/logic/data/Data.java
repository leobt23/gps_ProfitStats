package logic.data;

import logic.EnumBetStatus;
import logic.EnumWrongInputBetRegistry;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Data {
    private User user;
    private ArrayList<EnumWrongInputBetRegistry> wrongInputBetRegistry;

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
        return user.betsHistory.getBets().get(idx).getBetName();
    }

    public Time getBetRegistryDate(int idx) {
        return user.betsHistory.getBets().get(idx).getBetRegisterDate();
    }

    public int getBetNumberOfGames(int idx) {
        return user.betsHistory.getBets().get(idx).getNumberOfGames();
    }

    public int getBetNumberOfBets(int idx) {
        return user.betsHistory.getBets().get(idx).getNumberOfBets();
    }

    public float getBetValueBetted(int idx) {
        return user.betsHistory.getBets().get(idx).getTotalValueBetted();
    }

    public float getBetPossibleWinnings(int idx) {
        return user.betsHistory.getBets().get(idx).getPossibleWinnings();
    }

    public EnumBetStatus getBetStatus(int idx) {
        return user.betsHistory.getBets().get(idx).getStatus();
    }

    public int getBetId(int idx) {
        return user.betsHistory.getBets().get(idx).getBetId();
    }

    public Time getBetCloseDate(int idx) {
        return user.betsHistory.getBets().get(idx).getBetCloseDate();
    }

    public void setBetStatus(int betId, EnumBetStatus status) {
        user.betsHistory.getBets().forEach(
                b -> {
                    if(b.getBetId() == betId) {
                        b.setStatus(status);
                    }
                }
        );
    }

    public boolean verifyInputBetRegistry(String numOfGamesBettedValue, LocalDate registDateValue, LocalDate closeDateValue, String totalValueBettedValue, String possibleWinningsValue, String numberOfBetsValue, String betNameValue, EnumBetStatus enumBetStatus) {
        boolean flag=true;
        wrongInputBetRegistry.clear();
        if(numOfGamesBettedValue.equals("")||numOfGamesBettedValue==null){

        }
        else {
            int numberOfGamesBets = Integer.parseInt(numOfGamesBettedValue);
            if (numberOfGamesBets < 0 || numberOfGamesBets > 100) {
                wrongInputBetRegistry.add(EnumWrongInputBetRegistry.NUMBER_OF_GAMES_BETTED);
                flag = false;
            }
        }
        if(registDateValue.compareTo(closeDateValue)>0){
            wrongInputBetRegistry.add(EnumWrongInputBetRegistry.BET_CLOSE_DATE);
            flag = false;
        }
        float totalValueBetted = Float.parseFloat(totalValueBettedValue);
        if(totalValueBetted<0.10||totalValueBetted>100000){
            wrongInputBetRegistry.add(EnumWrongInputBetRegistry.TOTAL_VALUE_BETTED);
            flag = false;
        }
        float possibleWinnings = Float.parseFloat(possibleWinningsValue);
        if(possibleWinnings<0.10||possibleWinnings>100000){
            wrongInputBetRegistry.add(EnumWrongInputBetRegistry.POSSIBLE_WINNINGS);
            flag = false;
        }
        if(numberOfBetsValue.equals("")||numberOfBetsValue==null){

        }
        else {
            int numberOfBets = Integer.parseInt(numberOfBetsValue);
            if (numberOfBets < 0) {
                wrongInputBetRegistry.add(EnumWrongInputBetRegistry.NUMBER_OF_BETS);
                flag = false;
            }
        }
        if(betNameValue.length()>20||betNameValue.length()<1){
            wrongInputBetRegistry.add(EnumWrongInputBetRegistry.BET_NAME);
            flag = false;
        }
        if(enumBetStatus==null){
            wrongInputBetRegistry.add(EnumWrongInputBetRegistry.RESULT);
            flag = false;
        }
        return flag;
    }
    public ArrayList<EnumWrongInputBetRegistry> getWrongInputBetRegistry(){
        return wrongInputBetRegistry;
    }
}
