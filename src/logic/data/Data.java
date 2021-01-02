package logic.data;

import logic.EnumBetStatus;
import logic.EnumWrongInputBetRegistry;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Locale;

public class Data implements Serializable {

    private static final long serialVersionUID = 1L;

    private User user;
    private ArrayList<EnumWrongInputBetRegistry> wrongInputBetRegistry = new ArrayList<>();
//    BettingHistory bettingHistory = new BettingHistory();

    /*public Data(User user, BettingHistory bettingHistory, Time time){
        this.user = user;
        this.bettingHistory = bettingHistory;
        this.time = time;
    }*/

    public Data() {
        user = new User("", "", EnumGenders.OTHER, 18, 0);
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
        if(wrongInputBetRegistry!=null)
            wrongInputBetRegistry.clear();
        if(numOfGamesBettedValue.equals("")||numOfGamesBettedValue==null){

        }
        else {
            try {
                int numberOfGamesBets = Integer.parseInt(numOfGamesBettedValue);
                if (numberOfGamesBets < 0 || numberOfGamesBets > 100) {
                    wrongInputBetRegistry.add(EnumWrongInputBetRegistry.NUMBER_OF_GAMES_BETTED);
                    flag = false;
                }
            }catch (NumberFormatException e){
                wrongInputBetRegistry.add(EnumWrongInputBetRegistry.NUMBER_OF_GAMES_BETTED);
                flag = false;
            }
        }
        if(registDateValue.compareTo(closeDateValue)>0){
            wrongInputBetRegistry.add(EnumWrongInputBetRegistry.BET_CLOSE_DATE);
            flag = false;
        }
        try {
            float totalValueBetted = Float.parseFloat(totalValueBettedValue);
            if (totalValueBetted < 0.10 || totalValueBetted > 100000) {
                wrongInputBetRegistry.add(EnumWrongInputBetRegistry.TOTAL_VALUE_BETTED);
                flag = false;
            }
            }catch (NumberFormatException e){
                wrongInputBetRegistry.add(EnumWrongInputBetRegistry.TOTAL_VALUE_BETTED);
                flag = false;
            }
        try {
            float possibleWinnings = Float.parseFloat(possibleWinningsValue);
            if (possibleWinnings < 0.10 || possibleWinnings > 100000) {
                wrongInputBetRegistry.add(EnumWrongInputBetRegistry.POSSIBLE_WINNINGS);
                flag = false;
            }
        }catch (NumberFormatException e){
            wrongInputBetRegistry.add(EnumWrongInputBetRegistry.POSSIBLE_WINNINGS);
            flag = false;
        }
        if(numberOfBetsValue.equals("")||numberOfBetsValue==null){

        }
        else {
            try {
                int numberOfBets = Integer.parseInt(numberOfBetsValue);
                if (numberOfBets < 0) {
                    wrongInputBetRegistry.add(EnumWrongInputBetRegistry.NUMBER_OF_BETS);
                    flag = false;
                }
            }catch (NumberFormatException e){
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

    public void addNewBet(String numOfGamesBettedValue, LocalDate registDateValue, LocalDate closeDateValue, String totalValueBettedValue, String possibleWinningsValue, String numberOfBetsValue, String betNameValue, EnumBetStatus enumBetStatus) {
        int numOfGamesBetted,numberOfBets;
        float totalValueBetted,possibleWinnings;
        Time registDate,closeDate;
        if(numOfGamesBettedValue.equals("")||numOfGamesBettedValue==null){
            numOfGamesBetted=1;
        }
        else{
            numOfGamesBetted=Integer.parseInt(numOfGamesBettedValue);
        }
        if(numberOfBetsValue.equals("")||numberOfBetsValue==null){
            numberOfBets=1;
        }
        else{
            numberOfBets=Integer.parseInt(numberOfBetsValue);
        }
        totalValueBetted = Float.parseFloat(totalValueBettedValue);
        possibleWinnings = Float.parseFloat(possibleWinningsValue);
        WeekFields weekFieldsRegistDate = WeekFields.of(Locale.getDefault());

        registDate = new Time(registDateValue.getYear(),registDateValue.getMonthValue(),registDateValue.get(weekFieldsRegistDate.weekOfWeekBasedYear()),registDateValue.getDayOfMonth());
        closeDate = new Time(closeDateValue.getYear(),closeDateValue.getMonthValue(),closeDateValue.get(weekFieldsRegistDate.weekOfWeekBasedYear()),closeDateValue.getDayOfMonth());

        Bet bet = new Bet(numOfGamesBetted,numberOfBets,registDate,closeDate,totalValueBetted,possibleWinnings,betNameValue,enumBetStatus);
        user.betsHistory.addBetToHistory(bet);
    }

    public float getTotalProfit() {
        return user.getTotalProfit();
    }

    public ArrayList<Integer> numberOfBetsMonth() {
        return user.numberOfBetsMonth();
    }

    public ArrayList<Float> getWonMoneyCurrentMonth() {
        return user.getWonMoneyCurrentMonth();
    }

    public float getHighestWin() {
        return user.getHighestWinValue();
    }

    public ArrayList<Float> getLostMoneyCurrentMonth() {
        return user.getLostMoneyCurrentMonth();
    }

    public String getBestMonth() {
        return user.getBestMonth();
    }

    public float getWinningPercentage() {
        return user.getWinningPercentage();
    }

    public int getNumberOfBets() {
        return user.betsHistory.bets.size();
    }
}
