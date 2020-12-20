package tests;

import logic.data.Time;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


import java.text.SimpleDateFormat;
import java.util.Date;

class TimeTest {

    @Test
    void testGetCurrentDate() {
        Time time = new Time(2020, 12, 1, 14, 9, 50, 0);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String dateStr = formatter.format(date);
        Assert.assertEquals(dateStr,time.getCurrentDate());
    }

    @Test
    void getYear() {
    }

    @Test
    void getMonth() {
    }

    @Test
    void getWeek() {
    }

    @Test
    void getDay() {
    }

    @Test
    void getHour() {
    }

    @Test
    void getMinute() {
    }

    @Test
    void getSeconds() {
    }

    @Test
    void setYear() {
    }

    @Test
    void setMonth() {
    }

    @Test
    void setWeek() {
    }

    @Test
    void setDay() {
    }

    @Test
    void setHour() {
    }

    @Test
    void setMinute() {
    }

    @Test
    void setSeconds() {
    }

    @Test
    void testToString() {
    }
}