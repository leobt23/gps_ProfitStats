
package tests;

import logic.data.Time;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;


class TimeTest {


    @Test
    void getCurrentDate() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);

        LocalDateTime now = LocalDateTime.now();
        assertEquals("Time{"        +
                      + now.getYear()       +
                "/"   + now.getMonthValue() +
                "/"   + now.getDayOfMonth() +
                " - " + now.getHour()       +
                ":"   + now.getMinute()     +
                ":"   + now.getSecond()     +
                '}'  ,  tempo.getCurrentDate());
    }



    @Test
    void getYear() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        assertEquals(2020, tempo.getYear());
    }

    @Test
    void getMonth() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        assertEquals(10, tempo.getMonth());
    }

    @Test
    void getWeek() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        assertEquals(1, tempo.getWeek());
    }

    @Test
    void getDay() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        assertEquals(20, tempo.getDay());
    }

    @Test
    void getHour() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        assertEquals(11, tempo.getHour());
    }

    @Test
    void getMinute() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        assertEquals(30, tempo.getMinute());
    }

    @Test
    void getSeconds() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        assertEquals(27, tempo.getSeconds());
    }

    @Test
    void setYear() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        tempo.setYear(2021);
        assertEquals(2021, tempo.getYear());
    }

    @Test
    void setMonth() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        tempo.setMonth(2);
        assertEquals(2, tempo.getMonth());
    }

    @Test
    void setWeek() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        tempo.setWeek(7);
        assertEquals(7, tempo.getWeek());
    }

    @Test
    void setDay() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        tempo.setDay(21);
        assertEquals(21, tempo.getDay());
    }

    @Test
    void setHour() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        tempo.setYear(2021);
        assertEquals(2021, tempo.getYear());
    }

    @Test
    void setMinute() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        tempo.setMinute(17);
        assertEquals(17, tempo.getMinute());
    }

    @Test
    void setSeconds() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        tempo.setSeconds(13);
        assertEquals(13, tempo.getSeconds());
    }

    @Test
    void testToString() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        assertEquals("Time{" +
                "year="      + tempo.getYear()    +
                ", month="   + tempo.getMonth()   +
                ", week="    + tempo.getWeek()    +
                ", day="     + tempo.getDay()     +
                ", hour="    + tempo.getHour()    +
                ", minute="  + tempo.getMinute()  +
                ", seconds=" + tempo.getSeconds() +
                '}', tempo.toString());
    }


    @Test
    void setTimeToCurrentDate() {
        Time tempo = new Time(2020, 10,1, 20, 11,30,27);
        Time aux = new Time(200, 1,1, 2, 01,30,27);
        tempo.getCurrentDate();
        aux.getCurrentDate();

        assertEquals(tempo.toString(), aux.toString());

    }
}
