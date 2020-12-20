package logic;

import logic.data.Bet;
import logic.data.Time;

public class Main {
    public static void main(String[] args) {
        Bet bet = new Bet (2,2,"10/10/2020", "12/10/2020", 1, 5, "betnr1");
        //Bet bet2 = new Bet ("fff","fff",10/10/2020, 12/10/2020, "f", "f", 2222);

        Time t = new Time(1,1,1,1,1,1,1);


        System.out.println("a: "+ t.toString());


        System.out.println("Objeto 1: "+bet.toString());
        //System.out.println("Objeto 2: "+bet2.toString());
    }
}
