package week;

import java.util.LinkedList;

public class LongestWellPerformingInterval {
    public int longestWPI(int[] hours) {
        int goodTime = 0;
        int badTime = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                goodTime++;
            } else {
                badTime++;
            }
        }

        if (goodTime > badTime) return hours.length;

        goodTime = 0;
        badTime = 0;
        int index = 0;
        int count = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) goodTime++; else badTime++;
            if (goodTime == badTime) {
                index = 0;
                count = i-1;
            }


            linkedList.add(hours[i]);
        }

        int[] results
    }
}
