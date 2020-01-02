package week;

import java.util.Calendar;

public class DayOfTheWeek {
    public static void main(String[] args) {
            System.out.println(dayOfTheWeek(21,12,1980));
    }
    public static String dayOfTheWeek(int day, int month, int year) {
        int runYear[] = {0,31, 29,31,30,31,30,31,31,30,31,30,31};
        int pingYear[] = {0,31, 28,31,30,31,30,31,31,30,31,30,31};
        String week[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        // 1971 1.1 周五
        int days = -1;
        for (int i = 1971; i < year; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || (i%400==0)) {
                days += 366;
            } else {
                days += 365;
            }
        }

        for (int i = 1; i < month; i++) {
            if ((year % 4 == 0 && year % 100 != 0) || (year%400==0)) {
                days += runYear[i];
            } else {
                days += pingYear[i];
            }
        }

        days += day;
        int weekOfdays = (days+5) % 7;
        return week[weekOfdays];
    }
}
