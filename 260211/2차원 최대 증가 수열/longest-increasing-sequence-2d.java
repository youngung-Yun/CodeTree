import java.util.Scanner;
public class Main {

    final static int INIT = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n+1][m+1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        int[][] dp = new int[n+1][m+1];
        for (int row = 0; row <= n; ++row) {
            for (int col = 0; col <= n; ++col) {
                dp[row][col] = INIT;
            }
        }

        dp[1][1] = 1;
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= m; col++) {
                for (int prevRow = 0; prevRow < row; prevRow++) {
                    for (int prevCol = 0; prevCol < col; prevCol++) {
                        if (dp[prevRow][prevCol] != INIT && grid[prevRow][prevCol] < grid[row][col]) {
                            dp[row][col] = Integer.max(dp[row][col], dp[prevRow][prevCol] + 1);
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= m; col++) {
                ans = Integer.max(ans, dp[row][col]);
            }
        }
        System.out.println(ans);
    }
}