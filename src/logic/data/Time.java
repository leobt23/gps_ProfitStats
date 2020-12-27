package logic.data;
import java.time.LocalDateTime;

public class Time {
    int year, month, week, day, hour, minute, seconds;

  /*  public Time(int year, int month, int week, int day, int hour, int minute, int seconds) {
        setYear(year);
        setMonth(month);
        setWeek(week);
        setDay(day);
        setHour(hour);
        setMinute(minute);
        setSeconds(seconds);
    }*/

    public Time(int year, int monthValue, int week, int dayOfMonth) {
    }

    public String getCurrentDate(){
        this.setTimeToCurrentDate();
        return "Time{" +
                       + year    +
                "/"    + month   +
                "/"    + day     +
                " - "  + hour    +
                ":"    + minute  +
                ":"    + seconds +
                '}';
    }


    public void setTimeToCurrentDate(){
        LocalDateTime now = LocalDateTime.now();

        this.setYear(now.getYear());
        this.setMonth(now.getMonthValue());
        this.setDay(now.getDayOfMonth());
        this.setHour(now.getHour());
        this.setMinute(now.getMinute());
        this.setSeconds(now.getSecond());
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getWeek() {
        return week;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setYear(int year) {
        if(year > 0)
        this.year = year;
        else{
            System.out.println(" *** Ano Invalido ***");
            this.year = 2020;
        }
    }

    public void setMonth(int month) {
        if(month <= 12 && month > 0)
        this.month = month;
        else{
            System.out.println(" *** Mes Invalido ***");
            this.month = 01;
        }
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public void setDay(int day) {
        if(day > 0 && day < 30)
        this.day = day;
        else{
            System.out.println(" *** Dia Invalido ***");
            this.day = 01;
        }
    }

    public void setHour(int hour) {
        if(hour >= 0 && hour < 24)
        this.hour = hour;
        else{
            System.out.println(" *** Hora Invalido ***");
            this.hour = 00;
        }
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute < 60)
            this.minute = minute;
        else {
            System.out.println(" *** Minutos Invalidos ***");
            this.minute = 00;
        }
    }

    public void setSeconds(int seconds) {
        if (seconds >= 0 && seconds < 60)
            this.seconds = seconds;
        else {
            System.out.println(" *** Segundos Invalidos ***");
            this.seconds = 00;
        }
    }

    @Override
    public String toString() {
        return "Time{" +
                "year="      + year +
                ", month="   + month +
                ", week="    + week +
                ", day="     + day +
                ", hour="    + hour +
                ", minute="  + minute +
                ", seconds=" + seconds +
                '}';
    }

}
