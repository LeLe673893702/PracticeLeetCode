package week;

public class NumPrimeArrangements {
    public static void main(String[] args) {
        System.out.println(numPrimeArrangements(3));
    }

    public static int numPrimeArrangements(int n) {
        int primeCount = 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        boolean flag = false;
        for (int i = 2; i <= n; i++) {
            flag = false;
            for(int j=2;j < i;j++) {
                if(i%j==0) {
                    flag=true;
                    break;
                }
            }
            if (!flag) {
                primeCount++;
            }
        }

        long a = 1, b = 1;
        for (int i = 1; i <= primeCount; i++) {
            a *=  i;
            a = a % 1000000007;
        }

        for (int i = 1; i <= (n-primeCount); i++) {
            b*=i;
            b = b % 1000000007;
        }

        return (int) (a*b % 1000000007);
    }
}
