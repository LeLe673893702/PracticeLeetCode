package week;

public class DietPlanPerformance {
    public static void main(String[] args) {
        int[] calories = {6,5,0,0};
                int k = 2, lower = 1, upper = 5 ;
       System.out.println( dietPlanPerformance(calories, k, lower, upper));
    }
    public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int score = 0;
        for (int i = 0; i <= calories.length - k;  i++) {
            int sum = 0;
            for (int j = i; j < i+k; j++) {
                sum += calories[j];
            }
            if (sum > upper) {
                score += 1;
            } else if (sum < lower){
                score -= 1;
            }
        }
        return score;
    }
}
