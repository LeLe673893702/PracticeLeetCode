/**
 * 开方
 */
public class SqrtX {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
        System.out.println(Math.sqrt(2147395599));
    }

    public static int mySqrt(int x) {
        if (x==0 || x==1) return x;
        int low = 1;
        int high = x;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (mid  <= x / mid &&  (mid+1) > x/(mid+1)) {
                return mid;
            } else if (  mid > x / mid) {
                high = mid-1;
            } else if (mid < x/mid) {
                low = mid+1;
            }
        }

        return x;
    }
}
