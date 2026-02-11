import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        // Please write your code here.

        // [max, min]
        int[][][] dp = new int[n][n][2];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (r == 0 && c == 0) {
                    dp[r][c][0] = dp[r][c][1] = matrix[r][c];
                } else if (r == 0) {
                    dp[r][c][0] = Integer.max(dp[r][c-1][0], matrix[r][c]);
                    dp[r][c][1] = Integer.min(dp[r][c-1][1], matrix[r][c]);
                } else if (c == 0) {
                    dp[r][c][0] = Integer.max(dp[r-1][c][0], matrix[r][c]);
                    dp[r][c][1] = Integer.min(dp[r-1][c][1], matrix[r][c]);
                } else {
                    int topMax = Integer.max(matrix[r][c], dp[r-1][c][0]);
                    int topMin = Integer.min(matrix[r][c], dp[r-1][c][1]);
                    int leftMax = Integer.max(matrix[r][c], dp[r][c-1][0]);
                    int leftMin = Integer.min(matrix[r][c], dp[r][c-1][1]);
                    if (topMax - topMin < leftMax - leftMin) {
                        dp[r][c][0] = topMax;
                        dp[r][c][1] = topMin;
                    } else {
                        dp[r][c][0] = leftMax;
                        dp[r][c][1] = leftMin;
                    }
                }
            }
        }
        System.out.println(dp[n-1][n-1][0] - dp[n-1][n-1][1]);
    }
}