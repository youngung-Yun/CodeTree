import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (r == 0 && c == 0) {
                    dp[r][c] = matrix[r][c];
                } else if (r == 0) {
                    dp[r][c] = Integer.min(dp[r][c-1], matrix[r][c]);
                } else if (c == 0) {
                    dp[r][c] = Integer.min(dp[r-1][c], matrix[r][c]);
                } else {
                    dp[r][c] = Integer.min(matrix[r][c], Integer.max(dp[r-1][c], dp[r][c-1]));
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}