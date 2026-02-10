import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n+1][n+1];
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                dp[r][c] = Integer.max(dp[r-1][c], dp[r][c-1]) + matrix[r][c];
            }
        }

        System.out.println(dp[n][n]);
    }
}