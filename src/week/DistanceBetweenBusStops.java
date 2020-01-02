package week;

public class DistanceBetweenBusStops {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(distanceBetweenBusStops(nums, 1, 0));
    }
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int cw = 0;
        int ccw = 0;
        if (start > destination) {
            int tmp = destination;
            destination = start;
            start = tmp;
        }
        for (int i = start; i < destination; i++) {
            cw += distance[i];
        }
        int sum = 0;
        for (int i =0; i < distance.length; i++) {
            sum += distance[i];
        }
        ccw = sum - cw;
        return Math.min(ccw, cw);
    }
}
