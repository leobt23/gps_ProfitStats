package logic.data;

import logic.EnumBetStatus;

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

    public String getBestMonth() {
        return bestMonth;
    }

    public float getTotalProfit() {
        for(int i=0; i < betsHistory.getBets().size(); i++){
            if(betsHistory.getBets().get(i).result == EnumBetStatus.WON)
                totalProfit += betsHistory.getBets().get(i).possibleWinnings;
            else
                if(betsHistory.getBets().get(i).result == EnumBetStatus.LOST)
                    totalProfit -= betsHistory.getBets().get(i).totalValueBetted;
        }

        return totalProfit;
    }

    public float getHighestWinValue() {
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
   /*     ArrayList<Bet> bets = new ArrayList<>();
        BettingHistory betH = new BettingHistory();

        User a = new User("Pedro", "pdls", EnumGenders.MALE, 20, 0);

        //a.registerBet(2, 1, "29-09-2020", "30-09-2020", 19.9f, 100.99f, "primeiraBet");
        //a.registerBet(2, 1, "29-09-2020", "30-09-2020", 19.9f, 100.99f, "segundaBet");
       // a.changeBet(0, 13, 3, "29/09/2020", "29/03/2020", 20.0f, 200.0f, "Bet alterada", EnumBetStatus.WON);
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
        //System.out.println("Username: " + a.getName());*/
    }
}

