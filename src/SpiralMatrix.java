public class SpiralMatrix {
    public static void main(String[] args) {
        int n = 4;
        int[][] a = generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int count = 0;
        int num = (int) Math.ceil(n/2.0);
        for (int sum = 0; sum < num; sum++) {
            int i= sum;
            int j= sum;
            while (j < n+sum) {
                matrix[i][j++] = ++count;
            }
            j--;
            while (i < n+sum-1) {
                matrix[++i][j] = ++count;
            }
            while (j > sum) {
                matrix[i][--j] = ++count;
            }
            while (i > sum+1) {
                matrix[--i][j] = ++count;
            }
            n -= 2;

        }
        return matrix;
    }

}

