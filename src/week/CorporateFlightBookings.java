package week;

import javax.xml.soap.Node;
import java.util.*;

/**
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *
 * 我们这儿有一份航班预订表，表中第 i 条预订记录 bookings[i] = [i, j, k] 意味着我们在从 i 到 j 的每个航班上预订了 k 个座位。
 *
 * 请你返回一个长度为 n 的数组 answer，按航班编号顺序返回每个航班上预订的座位数。
 *
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 1: 10
 * 2: 10 +20+25 = 55
 */
public class CorporateFlightBookings {
    public class node {
        public int leftBorder;
        public int rightBorder;
        public int seats;
        public List<Node> nodes = new ArrayList<>();
    }
    public static void main(String[] args) {
        CorporateFlightBookings corporateFlightBookings = new CorporateFlightBookings();

    }
    public int[] corpFlightBookings(int[][] bookings, int n) {
        Node[] subs = new Node[bookings.length];
        for (int i = 0; i < bookings.length; i++) {
            subs[i] = bookings[i][1] - bookings[i][0];
        }

        Arrays.sort(subs, (o1, o2) -> {
            if (o1 > o2) {
                return 1;
            } else if (o1 < o2) {
                return -1;
            } else {
                return 0;
            }
        });

        for ()
    }
}
