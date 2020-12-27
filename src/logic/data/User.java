package logic.data;

import logic.EnumBetStatus;

import java.util.ArrayList;

public class User {
    String name, email, bestMonth;
    EnumGenders gender;
    int age, totalBets;
    float totalProfit, highestWinValue, winningPercentage;
    BettingHistory betsHistory;

    public User(String name, String email, EnumGenders gender, int age, int totalBets) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.totalBets = totalBets;
        this.betsHistory = new BettingHistory();
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
        return totalBets;
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
                               float totalValueB, float possibleW, String nameBet) {

        Bet newBet = new Bet(ngames, nbets, betRDate, betCDate, totalValueB, possibleW, nameBet, EnumBetStatus.PENDENT);
        if (betsHistory.addBetToHistory(newBet))
            return true;
        else
            return false;
    }

    public boolean changeBet(int idBet, int ngames, int nbets, String betRDate, String betCDate,
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
        for (int i = 0; i < betsHistory.bets.size(); i++) {
            System.out.println("ID = " + betsHistory.bets.get(i).getBetId() + " Nome da aposta: " + betsHistory.bets.get(i).getBetName() + "");
        }
    }

    public String getBestMonth() {
        ArrayList<Float> arrayMeses = new ArrayList<>(12);
        float max = 0.0f;
        int pos = 0;

        for(int i=0; i < arrayMeses.size(); i++)
            arrayMeses.set(i,0.0f);

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
            bestMonth = "Outobro";
        if(pos == 11)
            bestMonth = "Novembro";
        if(pos == 12)
            bestMonth = "Dezembro";

        return bestMonth;
    }

    public ArrayList<Integer> numberOfBetsMonth(){
        ArrayList<Integer> arrayMeses = new ArrayList<>(12);

        for(int i=0; i < arrayMeses.size(); i++)
            arrayMeses.set(i,0);

        for(int i=0; i < betsHistory.bets.size(); i++){
            if(betsHistory.bets.get(i).betRegisterDate.month == 1)
                arrayMeses.set(1,arrayMeses.get(1) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 2)
                arrayMeses.set(2,arrayMeses.get(2) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 3)
                arrayMeses.set(3,arrayMeses.get(3) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 4)
                arrayMeses.set(4,arrayMeses.get(4) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 5)
                arrayMeses.set(5,arrayMeses.get(5) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 6)
                arrayMeses.set(6,arrayMeses.get(6) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 7)
                arrayMeses.set(7,arrayMeses.get(7) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 8)
                arrayMeses.set(8,arrayMeses.get(8) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 9)
                arrayMeses.set(9,arrayMeses.get(9) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 10)
                arrayMeses.set(10,arrayMeses.get(10) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 11)
                arrayMeses.set(11,arrayMeses.get(11) + 1);
            if(betsHistory.bets.get(i).betRegisterDate.month == 12)
                arrayMeses.set(12,arrayMeses.get(12) + 1);
        }

        return arrayMeses;
    }

    public float getTotalProfit() {
        for(int i=0; i < betsHistory.bets.size(); i++){
            if(betsHistory.bets.get(i).result == EnumBetStatus.WON)
                totalProfit += betsHistory.bets.get(i).possibleWinnings;
            else
                if(betsHistory.bets.get(i).result == EnumBetStatus.LOST)
                    totalProfit -= betsHistory.bets.get(i).totalValueBetted;
        }

        return totalProfit;
    }

    public float getHighestWinValue() {
        for(int i=0; i < betsHistory.bets.size(); i++){
            if(betsHistory.bets.get(i).result == EnumBetStatus.WON)
                if(betsHistory.bets.get(i).possibleWinnings > highestWinValue)
                    highestWinValue = betsHistory.bets.get(i).possibleWinnings;
        }

        return highestWinValue;
    }

    public void setBestMonth(String bestMonth) {
        this.bestMonth = bestMonth;
    }

    public void setTotalProfit(float totalProfit) {
        this.totalProfit = totalProfit;
    }

    public void setHighestWinValue(float highestWinValue) {
        this.highestWinValue = highestWinValue;
    }



    public static void main(String[] args) {
        ArrayList<Bet> bets = new ArrayList<>();
        BettingHistory betH = new BettingHistory();

        User a = new User("Pedro", "pdls", EnumGenders.MALE, 20, 0);

        //a.registerBet(2, 1, "29-09-2020", "30-09-2020", 19.9f, 100.99f, "primeiraBet");
        //a.registerBet(2, 1, "29-09-2020", "30-09-2020", 19.9f, 100.99f, "segundaBet");
        a.changeBet(0, 13, 3, "29-09-2020", "29-03-2020", 20.0f, 200.0f, "Bet alterada", EnumBetStatus.WON);
        Time timeRegister = new Time(2020, 10,1, 20, 11,30,27);
        Time timeClose = new Time(2020, 10,1, 20, 11,30,27);
        timeClose.getCurrentDate();

        a.registerBet(2, 1, timeRegister, timeClose, 19.9f, 100.99f, "primeiraBet");
        a.registerBet(2, 1, timeRegister, timeClose, 19.9f, 100.99f, "segundaBet");
        //a.changeBet(0, 13, 3, timeRegister, timeClose, 20.0f, 200.0f, "Bet alterada");
        System.out.println("------------------------------------------------");
        a.getBets();
        System.out.println("------------------------------------------------");
        a.removeBet(0);
        a.getBets();
        System.out.println("------------------------------------------------");
        //System.out.println("Username: " + a.getName());
    }
}

