package logic;

import logic.data.Bet;
import logic.data.Time;

public class Main {
    public static void main(String[] args) {
        Bet bet = new Bet (2,2,"10/10/2020", "12/10/2020", 1, 5, "betnr1");

        //Bet bet2 = new Bet ("fff","fff",10/10/2020, 12/10/2020, "f", "f", 2222);

        Time t1 = new Time(2020,12,0,14,10,50,12);

        //Time t2 = new Time(0,13,0,100,0,0,111); //Input Invalido


        //System.out.println("a: "+ t1.toString());


        System.out.println("Bet 1: "+bet.toString());
        //System.out.println("Bet 2: "+bet2.toString());


        System.out.println("Tempo 1:" +t1.toString());
      //  System.out.println("Tempo 2:" +t2.toString());
    }
}