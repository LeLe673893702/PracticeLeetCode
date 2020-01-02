package week;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;
/**
 * 一年中第几天 周赛149
 */
public class OrdinalOfDate {
    public static void main(String[] args) {
        OrdinalOfDate ordinalOfDate = new OrdinalOfDate();
        System.out.println(ordinalOfDate.ordinalOfDate("2004-03-01"));
    }

    public int ordinalOfDate(String date) {
        int[] run = {31,29,31,30,31,30,31,31,30,31,30,31};
        int[] ping = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] dates = date.split("-");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        if (year % 400 ==0 || (year % 4 == 0 && year % 100 != 0)) {
            return getDays(run, month, day);
        } else {
            return getDays(ping, month, day);
        }

    }

    public int getDays(int[] monthOfDays, int month, int day) {
        int days = day;
        for (int i = 0; i < month - 1; i ++) {
            days += monthOfDays[i];
        }
        return days;
    }
}
