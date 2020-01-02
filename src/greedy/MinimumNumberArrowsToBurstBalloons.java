package greedy;

import java.util.Arrays;
import java.util.Comparator;

class Pair {
    int end;
    int start;

    public Pair(int start, int end) {
        this.end = end;
        this.start = start;
    }
}
public class MinimumNumberArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Pair[] pairs = new Pair[points.length];
        for (int i = 0; i < pairs.length; i++) {
            Pair pair = new Pair(points[i][0], points[i][1]);
            pairs[i] = pair;
        }
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.start > o2.start) {
                    return 1;
                } else if (o1.start < o2.start){
                    return -1;
                } else {
                    if (o1.end > o2.end) {
                        return 1;
                    } else if (o1.end < o2.end) {
                        return -1;
                    }
                }
                return 0;
            }
        });
        int count = 1;
        Pair minPair = pairs[0];
        for (int i = 1; i < pairs.length; i++) {
            if (!(pairs[i].start < minPair.end)) {
                count++;
                minPair = new Pair(Math.min(pairs[i].start, minPair.start), Math.min(pairs[i].end, minPair.end));
            } else {
                minPair = new Pair(pairs[i].start, pairs[i].end);
            }
        }
        return count;
    }
}
