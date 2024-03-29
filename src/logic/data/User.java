package logic.data;

import logic.EnumBetStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import java.util.ArrayList;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    String name, email, bestMonth;
    EnumGenders gender;
    int age, totalBets;
    float totalProfit, winningPercentage;
    BettingHistory betsHistory;
    Notifications notification;

    public User(String name, String email, EnumGenders gender, int age, int totalBets) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.totalBets = totalBets;
        this.betsHistory = new BettingHistory();
        this.notification = new Notifications();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnumGenders getGender() {
        return gender;
    }

    public void setGender(EnumGenders gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTotalBets() {
        return betsHistory.bets.size();
    }

    public void setTotalBets(int totalBets) {
        this.totalBets = totalBets;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", totalBets=" + totalBets +
                '}';
    }

    public boolean registerBet(int ngames, int nbets, Time betRDate, Time betCDate,
                               float totalValueB, float possibleW, String nameBet, EnumBetStatus betResult) {

        Bet newBet = new Bet(ngames, nbets, betRDate, betCDate, totalValueB, possibleW, nameBet, betResult);
        if (betsHistory.addBetToHistory(newBet))
            return true;
        else
            return false;
    }

    public boolean changeBet(int idBet, int ngames, int nbets, Time betRDate, Time betCDate,
                             float totalValueB, float possibleW, String nameBet, EnumBetStatus status) {

        if (betsHistory.findBet(idBet) != null) {
            betsHistory.changeBetInHistory(idBet, ngames, nbets, betRDate, betCDate, totalValueB, possibleW, nameBet, status);
            return true;
        }

        return false;
    }

    public void removeBet(int idBet) {
        betsHistory.removeBet(idBet);
    }

    public void getBets() {
        for (int i = 0; i < betsHistory.getBets().size(); i++) {
            System.out.println("ID = " + betsHistory.getBets().get(i).getBetId() + " Nome da aposta: " + betsHistory.getBets().get(i).getBetName() + "");
        }
    }
//
    public String getBestMonth() {
        ArrayList<Float> arrayMeses = new ArrayList<>(12);
        float max = 0.0f;
        int pos = 0;

        for(int i=0; i < 12; i++)
            arrayMeses.add(0.0f);

        for(int i=0; i < betsHistory.bets.size(); i++){
            if(betsHistory.bets.get(i).betRegisterDate.month == 1 && betsHistory.bets.get(i).result == EnumBetStatus.WON)
                arrayMeses.set(1,arrayMeses.get(1) + betsHistory.bets.get(i).possibleWinnings);
            else if(betsHistory.bets.get(i).betRegisterDate.month == 1 && betsHistory.bets.get(i).result == EnumBetStatus.LOST)
                arrayMeses.set(1,arrayMeses.get(1) - betsHistory.bets.get(i).totalValueBetted);

            if(betsHistory.bets.get(i).betRegisterDate.month == 2 && betsHistory.bets.get(i).result == EnumBetStatus.WON)
                arrayMeses.set(2,arrayMeses.get(2) + betsHistory.bets.get(i).possibleWinnings);
            else if(betsHistory.bets.get(i).betRegisterDate.month == 2 && betsHistory.bets.get(i).result == EnumBetStatus.LOST)
                arrayMeses.set(2,arrayMeses.get(2) - betsHistory.bets.get(i).totalValueBetted);

            if(betsHistory.bets.get(i).betRegisterDate.month == 3 && betsHistory.bets.get(i).result == EnumBetStatus.WON)
                arrayMeses.set(3,arrayMeses.get(3) + betsHistory.bets.get(i).possibleWinnings);
            else if(betsHistory.bets.get(i).betRegisterDate.month == 3 && betsHistory.bets.get(i).result == EnumBetStatus.LOST)
                arrayMeses.set(3,arrayMeses.get(3) - betsHistory.bets.get(i).possibleWinnings);

            if(betsHistory.bets.get(i).betRegisterDate.month == 4 && betsHistory.bets.get(i).result == EnumBetStatus.WON)
                arrayMeses.set(4,arrayMeses.get(4) + betsHistory.bets.get(i).possibleWinnings);
            else if(betsHistory.bets.get(i).betRegisterDate.month == 4 && betsHistory.bets.get(i).result == EnumBetStatus.LOST)
                arrayMeses.set(4,arrayMeses.get(4) - betsHistory.bets.get(i).possibleWinnings);

            if(betsHistory.bets.get(i).betRegisterDate.month == 5 && betsHistory.bets.get(i).result == EnumBetStatus.WON)
                arrayMeses.set(5,arrayMeses.get(5) + betsHistory.bets.get(i).possibleWinnings);
            else if(betsHistory.bets.get(i).betRegisterDate.month == 5 && betsHistory.bets.get(i).result == EnumBetStatus.LOST)
                arrayMeses.set(5,arrayMeses.get(5) - betsHistory.bets.get(i).possibleWinnings);

            if(betsHistory.bets.get(i).betRegisterDate.month == 6 && betsHistory.bets.get(i).result == EnumBetStatus.WON)
                arrayMeses.set(6,arrayMeses.get(6) + betsHistory.bets.get(i).possibleWinnings);
            else if(betsHistory.bets.get(i).betRegisterDate.month == 6 && betsHistory.bets.get(i).result == EnumBetStatus.LOST)
                arrayMeses.set(6,arrayMeses.get(6) - betsHistory.bets.get(i).possibleWinnings);

            if(betsHistory.bets.get(i).betRegisterDate.month == 7 && betsHistory.bets.get(i).result == EnumBetStatus.WON)
                arrayMeses.set(7,arrayMeses.get(7) + betsHistory.bets.get(i).possibleWinnings);
            else if(betsHistory.bets.get(i).betRegisterDate.month == 7 && betsHistory.bets.get(i).result == EnumBetStatus.LOST)
                arrayMeses.set(7,arrayMeses.get(7) - betsHistory.bets.get(i).possibleWinnings);

            if(betsHistory.bets.get(i).betRegisterDate.month == 8 && betsHistory.bets.get(i).result == EnumBetStatus.WON)
                arrayMeses.set(8,arrayMeses.get(8) + betsHistory.bets.get(i).possibleWinnings);
            else if(betsHistory.bets.get(i).betRegisterDate.month == 8 && betsHistory.bets.get(i).result == EnumBetStatus.LOST)
                arrayMeses.set(8,arrayMeses.get(8) - betsHistory.bets.get(i).possibleWinnings);

            if(betsHistory.bets.get(i).betRegisterDate.month == 9 && betsHistory.bets.get(i).result == EnumBetStatus.WON)
                arrayMeses.set(9,arrayMeses.get(9) + betsHistory.bets.get(i).possibleWinnings);
            else if(betsHistory.bets.get(i).betRegisterDate.month == 9 && betsHistory.bets.get(i).result == EnumBetStatus.LOST)
                arrayMeses.set(9,arrayMeses.get(9) - betsHistory.bets.get(i).possibleWinnings);

            if(betsHistory.bets.get(i).betRegisterDate.month == 10 && betsHistory.bets.get(i).result == EnumBetStatus.WON)
                arrayMeses.set(10,arrayMeses.get(10) + betsHistory.bets.get(i).possibleWinnings);
            else if(betsHistory.bets.get(i).betRegisterDate.month == 10 && betsHistory.bets.get(i).result == EnumBetStatus.LOST)
                arrayMeses.set(10,arrayMeses.get(10) - betsHistory.bets.get(i).possibleWinnings);

            if(betsHistory.bets.get(i).betRegisterDate.month == 11 && betsHistory.bets.get(i).result == EnumBetStatus.WON)
                arrayMeses.set(11,arrayMeses.get(11) + betsHistory.bets.get(i).possibleWinnings);
            else if(betsHistory.bets.get(i).betRegisterDate.month == 11 && betsHistory.bets.get(i).result == EnumBetStatus.LOST)
                arrayMeses.set(11,arrayMeses.get(11) - betsHistory.bets.get(i).possibleWinnings);

            if(betsHistory.bets.get(i).betRegisterDate.month == 12 && betsHistory.bets.get(i).result == EnumBetStatus.WON)
                arrayMeses.set(12,arrayMeses.get(12) + betsHistory.bets.get(i).possibleWinnings);
            else if(betsHistory.bets.get(i).betRegisterDate.month == 12 && betsHistory.bets.get(i).result == EnumBetStatus.LOST)
                arrayMeses.set(12,arrayMeses.get(12) - betsHistory.bets.get(i).possibleWinnings);
        }

        for(int i=0; i < arrayMeses.size(); i++)
            if(arrayMeses.get(i) > max) {
                max = arrayMeses.get(i);
                pos = i;
            }

        if(pos == 1)
             bestMonth = "Janeiro";
        if(pos == 2)
            bestMonth = "Feveiro";
        if(pos == 3)
            bestMonth = "Março";
        if(pos == 4)
            bestMonth = "Abril";
        if(pos == 5)
            bestMonth = "Maio";
        if(pos == 6)
            bestMonth = "Junho";
        if(pos == 7)
            bestMonth = "Julho";
        if(pos == 8)
            bestMonth = "Agosto";
        if(pos == 9)
            bestMonth = "Setembro";
        if(pos == 10)
            bestMonth = "Outubro";
        if(pos == 11)
            bestMonth = "Novembro";
        if(pos == 12)
            bestMonth = "Dezembro";
//
        return bestMonth;
    }

    public ArrayList<Integer> numberOfBetsMonth(){
        ArrayList<Integer> arrayMeses = new ArrayList<>(12);

        for(int i=0; i < 12; i++)
            arrayMeses.add(0);

        for(int i=0; i < betsHistory.bets.size(); i++){
            if(betsHistory.bets.get(i).betRegisterDate.month == 1)
                arrayMeses.set(0,arrayMeses.get(0) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 2)
                arrayMeses.set(1,arrayMeses.get(1) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 3)
                arrayMeses.set(2,arrayMeses.get(2) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 4)
                arrayMeses.set(3,arrayMeses.get(3) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 5)
                arrayMeses.set(4,arrayMeses.get(4) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 6)
                arrayMeses.set(5,arrayMeses.get(5) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 7)
                arrayMeses.set(6,arrayMeses.get(6) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 8)
                arrayMeses.set(7,arrayMeses.get(7) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 9)
                arrayMeses.set(8,arrayMeses.get(8) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 10)
                arrayMeses.set(9,arrayMeses.get(9) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 11)
                arrayMeses.set(10,arrayMeses.get(10) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 12)
                arrayMeses.set(11,arrayMeses.get(11) + 1);
        }

        return arrayMeses;
    }

    public ArrayList<Float> getWonMoneyCurrentMonth(){
        ArrayList<Float> arraySemanas = new ArrayList<>(4);

        for(int i=0; i < 4; i++)
            arraySemanas.add(0.0f);

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();

        for(int i=0; i < betsHistory.bets.size(); i++){
            if(betsHistory.bets.get(i).betRegisterDate.day >= 1 && betsHistory.bets.get(i).betRegisterDate.day <= 7
                    && betsHistory.bets.get(i).betRegisterDate.month == month && betsHistory.bets.get(i).result == EnumBetStatus.WON){
                arraySemanas.set(0, arraySemanas.get(0) + betsHistory.bets.get(i).possibleWinnings);
            }

            if(betsHistory.bets.get(i).betRegisterDate.day >= 8 && betsHistory.bets.get(i).betRegisterDate.day <= 14
                    && betsHistory.bets.get(i).betRegisterDate.month == month && betsHistory.bets.get(i).result == EnumBetStatus.WON){
                arraySemanas.set(1, arraySemanas.get(1) + betsHistory.bets.get(i).possibleWinnings);
            }

            if(betsHistory.bets.get(i).betRegisterDate.day >= 15 && betsHistory.bets.get(i).betRegisterDate.day <= 21
                    && betsHistory.bets.get(i).betRegisterDate.month == month && betsHistory.bets.get(i).result == EnumBetStatus.WON){
                arraySemanas.set(2, arraySemanas.get(2) + betsHistory.bets.get(i).possibleWinnings);
            }

            if(betsHistory.bets.get(i).betRegisterDate.day >= 22 && betsHistory.bets.get(i).betRegisterDate.day <= 31
                    && betsHistory.bets.get(i).betRegisterDate.month == month && betsHistory.bets.get(i).result == EnumBetStatus.WON){
                arraySemanas.set(3, arraySemanas.get(3) + betsHistory.bets.get(i).possibleWinnings);
            }

        }
        return arraySemanas;
    }

    public ArrayList<Float> getLostMoneyCurrentMonth(){
        ArrayList<Float> arraySemanas = new ArrayList<>(4);

        for(int i=0; i < 4; i++)
            arraySemanas.add(0.0f);

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();

        for(int i=0; i < betsHistory.bets.size(); i++){
            if(betsHistory.bets.get(i).betRegisterDate.day >= 1 && betsHistory.bets.get(i).betRegisterDate.day <= 7
                    && betsHistory.bets.get(i).betRegisterDate.month == month){
                arraySemanas.set(0, arraySemanas.get(0) - betsHistory.bets.get(i).totalValueBetted);
            }

            if(betsHistory.bets.get(i).betRegisterDate.day >= 8 && betsHistory.bets.get(i).betRegisterDate.day <= 14
                    && betsHistory.bets.get(i).betRegisterDate.month == month){
                arraySemanas.set(1, arraySemanas.get(1) - betsHistory.bets.get(i).totalValueBetted);
            }

            if(betsHistory.bets.get(i).betRegisterDate.day >= 15 && betsHistory.bets.get(i).betRegisterDate.day <= 21
                    && betsHistory.bets.get(i).betRegisterDate.month == month){
                arraySemanas.set(2, arraySemanas.get(2) - betsHistory.bets.get(i).totalValueBetted);
            }

            if(betsHistory.bets.get(i).betRegisterDate.day >= 22 && betsHistory.bets.get(i).betRegisterDate.day <= 31
                    && betsHistory.bets.get(i).betRegisterDate.month == month){
                arraySemanas.set(3, arraySemanas.get(3) - betsHistory.bets.get(i).totalValueBetted);
            }
        }
        return arraySemanas;
    }

    public ArrayList<Float> getLostMoneyCurrentWeek(){
        ArrayList<Float> arraySemanas = new ArrayList<>(4);

        for(int i=0; i < 4; i++)
            arraySemanas.add(0.0f);

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();

        for(int i=0; i < betsHistory.bets.size(); i++){
            float moneyWon = betsHistory.bets.get(i).getStatus() == EnumBetStatus.WON ?
                    betsHistory.bets.get(i).possibleWinnings : 0f;
            if(betsHistory.bets.get(i).betRegisterDate.day >= 1 && betsHistory.bets.get(i).betRegisterDate.day <= 7
                    && betsHistory.bets.get(i).betRegisterDate.month == month){
                arraySemanas.set(0, arraySemanas.get(0) + moneyWon - betsHistory.bets.get(i).totalValueBetted);
            }

            if(betsHistory.bets.get(i).betRegisterDate.day >= 8 && betsHistory.bets.get(i).betRegisterDate.day <= 14
                    && betsHistory.bets.get(i).betRegisterDate.month == month){
                arraySemanas.set(1, arraySemanas.get(1) + moneyWon - betsHistory.bets.get(i).totalValueBetted);
            }

            if(betsHistory.bets.get(i).betRegisterDate.day >= 15 && betsHistory.bets.get(i).betRegisterDate.day <= 21
                    && betsHistory.bets.get(i).betRegisterDate.month == month){
                arraySemanas.set(2, arraySemanas.get(2) + moneyWon - betsHistory.bets.get(i).totalValueBetted);
            }

            if(betsHistory.bets.get(i).betRegisterDate.day >= 22 && betsHistory.bets.get(i).betRegisterDate.day <= 31
                    && betsHistory.bets.get(i).betRegisterDate.month == month){
                arraySemanas.set(3, arraySemanas.get(3) + moneyWon - betsHistory.bets.get(i).totalValueBetted);
            }
        }
        return arraySemanas;
    }

    public float getTotalProfit() {
        totalProfit = 0;
        for(int i=0; i < betsHistory.getBets().size(); i++){
            if(betsHistory.getBets().get(i).result == EnumBetStatus.WON)
                totalProfit += betsHistory.getBets().get(i).possibleWinnings;
            totalProfit -= betsHistory.getBets().get(i).totalValueBetted;
        }

        return totalProfit;
    }

    public float getHighestWinValue() {
        float highestWinValue = 0f;
        for(int i=0; i < betsHistory.bets.size(); i++){
            if(betsHistory.bets.get(i).result == EnumBetStatus.WON)
                if(betsHistory.bets.get(i).possibleWinnings > highestWinValue)
                    highestWinValue = betsHistory.bets.get(i).possibleWinnings;
        }

        return highestWinValue;
    }

    public float getWinningPercentage() {
        int wins = 0, losses = 0;
        for (Bet bet : betsHistory.getBets()) {
            if (bet.result == EnumBetStatus.WON) {
                wins++;
            }
            else if(bet.result == EnumBetStatus.LOST) {
                losses++;
            }
        }
        winningPercentage = (float) wins/(wins+losses)*100;
        if (winningPercentage != winningPercentage) //To evaluate if percentage is NaN
            return 0.0f;
        return winningPercentage;
    }

    public void setBestMonth(String bestMonth) {
        this.bestMonth = bestMonth;
    }

    public void setTotalProfit(float totalProfit) {
        this.totalProfit = totalProfit;
    }

    // NOTIFICATIONS LOGIC

    public boolean verifyLimitMoneyBettedToday(float valueBetted){
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        Date date = calendar.getTime();
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        int day = calendar.get(Calendar.DATE);
        float totalValueBettedToday = valueBetted;

        if(notification.isFlagLimitMoneyDay()) {
            for (Bet bet : betsHistory.getBets()) {
                if (bet.betRegisterDate.day == day && bet.betRegisterDate.month == month && bet.betRegisterDate.year == year) {
                    totalValueBettedToday += bet.totalValueBetted;
                }
            }

            if (totalValueBettedToday >= notification.limitMoneyDay)
                return true;
        }

        return false;
    }

    public boolean verifyLimitLossWeek(){
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        Date date = calendar.getTime();
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        int day = calendar.get(Calendar.DATE);

        ArrayList<Float> arraySemanas;
        arraySemanas = getLostMoneyCurrentMonth();
        for(int i=0; i < 4; i++)
            System.out.println(arraySemanas.get(i));

        arraySemanas = getLostMoneyCurrentMonth();
        for(int i=0; i < 4; i++)
            arraySemanas.set(i, -arraySemanas.get(i));

        if(notification.isFlagLimitLossWeek()) {
            if (day >= 1 && day <= 7)
                if (arraySemanas.get(0) >= notification.limitLossWeek)
                    return true;

            if (day >= 8 && day <= 14)
                if (arraySemanas.get(1) >= notification.limitLossWeek)
                    return true;

            if (day >= 15 && day <= 21)
                if (arraySemanas.get(2) >= notification.limitLossWeek)
                    return true;

            if (day >= 22 && day <= 31)
                if (arraySemanas.get(3) >= notification.limitLossWeek)
                    return true;
        }
        return false;
    }

    public boolean verifyMinBettedWeek(){
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        Date date = calendar.getTime();
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        int day = calendar.get(Calendar.DATE);

        ArrayList<Float> arraySemanas = getLostMoneyCurrentMonth();

        if(notification.isFlagMinimumMoneyMonth() == true) {
            if (day >= 1 && day <= 7)
                if (arraySemanas.get(0) < notification.minimumMoneyMonth)
                    return true;

            if (day >= 8 && day <= 14)
                if (arraySemanas.get(1) < notification.minimumMoneyMonth)
                    return true;

            if (day >= 15 && day <= 21)
                if (arraySemanas.get(2) < notification.minimumMoneyMonth)
                    return true;

            if (day >= 22 && day <= 31)
                if (arraySemanas.get(3) < notification.minimumMoneyMonth)
                    return true;
        }
            return false;
    }

    public boolean verifyReminderToBetToday(float bettedValue){
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        Date date = calendar.getTime();
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        int day = calendar.get(Calendar.DATE);
        float totalValueBettedToday = bettedValue;

        if(notification.isFlagReminderBetDay() == true) {
            for (Bet bet : betsHistory.getBets()) {
                if (bet.betRegisterDate.day == day && bet.betRegisterDate.month == month && bet.betRegisterDate.year == year) {
                    totalValueBettedToday += bet.totalValueBetted;
                }
            }

            if (totalValueBettedToday < notification.reminderBetDay)
                return true;
        }

        return false;
    }

    public boolean toggleResultsReminderNotification(){

        LocalDate dateCloseBet;

        if(notification.isFlagResultsReminder() == true) {
            for (Bet bet : betsHistory.getBets()) {
                dateCloseBet = LocalDate.of(bet.betCloseDate.getYear(),bet.betCloseDate.getMonth(),bet.betCloseDate.getDay());
                if ( dateCloseBet.compareTo(LocalDate.now()) < 0 && bet.getStatus() == EnumBetStatus.PENDENT) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Bet> bets = new ArrayList<>();
        BettingHistory betH = new BettingHistory();

        User a = new User("Pedro", "pdls", EnumGenders.MALE, 20, 0);

        //a.registerBet(2, 1, "29-09-2020", "30-09-2020", 19.9f, 100.99f, "primeiraBet");
        //a.registerBet(2, 1, "29-09-2020", "30-09-2020", 19.9f, 100.99f, "segundaBet");
       // a.changeBet(0, 13, 3, "29/09/2020", "29/03/2020", 20.0f, 200.0f, "Bet alterada", EnumBetStatus.WON);
        Time timeRegister = new Time(2020,12,3,22);
        Time timeClose = new Time(2020, 12,3, 24);
        timeClose.getCurrentDate();

        a.registerBet(2, 1, timeRegister, timeClose, 19.9f, 100.99f, "primeiraBet", EnumBetStatus.WON);
        a.registerBet(2, 1, timeRegister, timeClose, 19.9f, 100.99f, "segundaBet", EnumBetStatus.LOST);
        a.registerBet(1,3,timeRegister,timeClose,5.0f,500.0f,"praVitoria", EnumBetStatus.WON);
        //a.changeBet()
        //a.changeBet(0, 13, 3, timeRegister, timeClose, 20.0f, 200.0f, "Bet alterada");
        System.out.println("------------------------------------------------");
        a.getBets();
        System.out.println("------------------------------------------------");
        a.removeBet(0);
        a.getBets();
        System.out.println("------------------------------------------------");
        ArrayList<Float> LostMoney = a.getLostMoneyCurrentMonth();
        for(int i=0; i < 4; i++)
            System.out.println(LostMoney.get(i));
        //System.out.println("Username: " + a.getName());*/
    }

    public float getLimitMoneyBettedDay() {
        return notification.limitMoneyDay;
    }
}

