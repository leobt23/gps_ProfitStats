package logic.data;

import logic.EnumBetStatus;
import logic.EnumWrongInputBetRegistry;
import logic.EnumWrongInputUserProfile;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Data implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private User user;
    private ArrayList<EnumWrongInputBetRegistry> wrongInputBetRegistry = new ArrayList<>();
    private ArrayList<EnumWrongInputNotifications> wrongInputNotifications = new ArrayList<>();
    private Integer betsIdCounter;

    /*public Data(User user, BettingHistory bettingHistory, Time time){
        this.user = user;
        this.bettingHistory = bettingHistory;
        this.time = time;
    }*/

    public Data() {
        user = new User("", "", EnumGenders.OTHER, 18, 0);
        betsIdCounter = 1;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBetName(int idx) {
        return user.betsHistory.getBets().get(idx).getBetName();
    }

    public Time getBetRegistryDate(int idx) {
        return user.betsHistory.getBets().get(idx).getBetRegisterDate();
    }
    public String getBetRegistryDateWithBars(int idx) {
        return user.betsHistory.getBets().get(idx).getBetRegisterDateWithBars();
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
    public String getBetCloseDateWithBars(int idx) {
        return user.betsHistory.getBets().get(idx).getBetCloseDateWithBars();
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

    public List<EnumWrongInputUserProfile> editProfile(String userName, String email, String age, EnumGenders gender) {
        List<EnumWrongInputUserProfile> wrongInput = new ArrayList<>();

        if (userName != null) {
            if (userName.length() < 1 || userName.length() > 20) {
                wrongInput.add(EnumWrongInputUserProfile.USER_NAME);
            }
            else {
                user.setName(userName);
            }
        }

        if (email != null) {
            if (!email.contains("@") || email.length() < 5) {
                wrongInput.add(EnumWrongInputUserProfile.EMAIL);
            }
            else {
                user.setEmail(email);
            }
        }

        if (age != null) {
            try {
                int intAge = Integer.parseInt(age);
                if (intAge < 18 || intAge > 120) {
                    wrongInput.add(EnumWrongInputUserProfile.AGE);
                }
                else {
                    user.setAge(intAge);
                }
            }
            catch (NumberFormatException e) {
                wrongInput.add(EnumWrongInputUserProfile.AGE);
            }
        }

        user.setGender(gender);

        return wrongInput;
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
    public ArrayList<EnumWrongInputNotifications> getWrongInputNotifications(){
        return wrongInputNotifications;
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

        Bet bet = new Bet( betsIdCounter++, numOfGamesBetted,numberOfBets,registDate,closeDate,totalValueBetted,possibleWinnings,betNameValue,enumBetStatus);
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

    public void deleteBet(int idx) {
        for(int i= 0; i<user.betsHistory.bets.size();i++) {
            if(user.betsHistory.bets.get(i).getBetId()==idx) {
                user.betsHistory.bets.remove(i);
                System.out.println("chega ao remove");
            }
        }
    }

    public void deleteBetByIdx(int idx) {
        user.betsHistory.bets.remove(idx);
    }

    public String getUserEmail() {
        return user.email;
    }

    public String getUserName() { return user.name; }

    public String getUserAge() { return "" + user.age; }

    public String getUserTotalBets() { return "" + user.getTotalBets(); }

    public String getUserGender() { return "" + user.gender;}

    public String getUserTotalProfits() { return "" + user.getTotalProfit(); }

    public String getUserHighestWin() { return "" + user.getHighestWinValue();}

    public void editBet(int idx,String numOfGamesBettedValue, LocalDate registDateValue, LocalDate closeDateValue, String totalValueBettedValue, String possibleWinningsValue, String numberOfBetsValue, String betNameValue, EnumBetStatus enumBetStatus) {
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
        user.betsHistory.bets.get(idx).setNumberOfGames(numOfGamesBetted);
        user.betsHistory.bets.get(idx).setNumberOfBets(numberOfBets);
        user.betsHistory.bets.get(idx).setBetRegisterDate(registDate);
        user.betsHistory.bets.get(idx).setBetCloseDate(closeDate);
        user.betsHistory.bets.get(idx).setTotalValueBetted(totalValueBetted);
        user.betsHistory.bets.get(idx).setPossibleWinnings(possibleWinnings);
        user.betsHistory.bets.get(idx).setBetName(betNameValue);
        user.betsHistory.bets.get(idx).setStatus(enumBetStatus);

    }

    /*public void setBetStaticId() {
        if(user.betsHistory.bets.size()<1)
            return;
        user.betsHistory.bets.get(user.betsHistory.bets.size()-1).setStatic(user.betsHistory.bets.get(user.betsHistory.bets.size()-1).betId+1);
    }*/


    public float getLimitMoneyDay() {return user.notification.getLimitMoneyDay(); }

    public float getLimitLossWeek() { return user.notification.getLimitLossWeek(); }

    public float getMinimumMoneyMonth() { return user.notification.getMinimumMoneyMonth(); }

    public float getReminderBetDay() { return user.notification.getReminderBetDay(); }

    public boolean getFlagLimitMoneyDay() { return user.notification.isFlagLimitMoneyDay(); }

    public boolean getFlagLimitLossWeek() { return user.notification.isFlagLimitLossWeek(); }

    public boolean getFlagMinimumMoneyMonth() { return user.notification.isFlagMinimumMoneyMonth(); }

    public boolean getFlagReminderBetDay() { return user.notification.isFlagReminderBetDay(); }

    public boolean getFlagResultsReminder() { return user.notification.isFlagResultsReminder(); }

    public void setLimitMoneyDay(float value) {user.notification.setLimitMoneyDay(value); }

    public void setLimitLossWeek(float value) {user.notification.setLimitLossWeek(value); }

    public void setMinimumMoneyMonth(float value) { user.notification.setMinimumMoneyMonth(value); }

    public void setReminderBetDay(float value) { user.notification.setReminderBetDay(value); }

    public void setFlagLimitMoneyDay(boolean value) { user.notification.setFlagLimitMoneyDay(value); }

    public void setFlagLimitLossWeek(boolean value) { user.notification.setFlagLimitLossWeek(value); }

    public void setFlagMinimumMoneyMonth(boolean value) { user.notification.setFlagMinimumMoneyMonth(value); }

    public void setFlagReminderBetDay(boolean value) { user.notification.setFlagReminderBetDay(value); }

    public void setFlagResultsReminder(boolean value) { user.notification.setFlagResultsReminder(value); }

    public boolean verifyInputNotifications(String limitMoneyDay, String limitLossWeek, String minimumMoneyMonth, String reminderBetDay) {
        boolean flag=true;
        if(wrongInputNotifications!=null)
            wrongInputNotifications.clear();
        if(limitMoneyDay.equals("")||limitMoneyDay==null){

        }
        else {
            try {
                float limitMoneyDayValue = Float.parseFloat(limitMoneyDay);
                if (limitMoneyDayValue < 0) {
                    wrongInputNotifications.add(EnumWrongInputNotifications.LIM_MONEY_BET_DAY);
                    flag = false;
                }
            }catch (NumberFormatException e){
                wrongInputNotifications.add(EnumWrongInputNotifications.LIM_MONEY_BET_DAY);
                flag = false;
            }
        }

        if(limitLossWeek.equals("")||limitLossWeek==null){

        }
        else {
            try {
                float limitLossWeekValue = Float.parseFloat(limitLossWeek);
                if (limitLossWeekValue < 0) {
                    wrongInputNotifications.add(EnumWrongInputNotifications.LIM_LOSS_WEEK);
                    flag = false;
                }
            }catch (NumberFormatException e){
                wrongInputNotifications.add(EnumWrongInputNotifications.LIM_LOSS_WEEK);
                flag = false;
            }
        }
        if(minimumMoneyMonth.equals("")||minimumMoneyMonth==null){

        }
        else {
            try {
                float minimumMoneyMonthValue = Float.parseFloat(minimumMoneyMonth);
                if (minimumMoneyMonthValue < 0) {
                    wrongInputNotifications.add(EnumWrongInputNotifications.MIN_BET_WEEK);
                    System.out.println("aqui");
                    flag = false;
                }
            }catch (NumberFormatException e){
                wrongInputNotifications.add(EnumWrongInputNotifications.MIN_BET_WEEK);
                flag = false;
            }
        }
        if(reminderBetDay.equals("")||reminderBetDay==null){

        }
        else {
            try {
                float reminderBetDayValue = Float.parseFloat(reminderBetDay);
                if (reminderBetDayValue < 0) {
                    wrongInputNotifications.add(EnumWrongInputNotifications.REMINDER_BET_DAY);
                    flag = false;
                }
            }catch (NumberFormatException e){
                wrongInputNotifications.add(EnumWrongInputNotifications.REMINDER_BET_DAY);
                flag = false;
            }
        }
        return flag;
    }
}
