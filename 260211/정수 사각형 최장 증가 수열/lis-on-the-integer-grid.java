import java.util.Arrays;
import java.util.Scanner;

public class Main {

    final static int[] dr = {0, 1, 0, -1};
    final static int[] dc = {1, 0, -1, 0};
    static int[][] grid;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                ans = Integer.max(ans, getDp(r, c, n));
            }
        }
        System.out.println(ans);
    }

    static int getDp(int r, int c, int n) {
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        int maxCount = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                continue;
            }
            if (grid[nr][nc] < grid[r][c]) {
                maxCount = Integer.max(maxCount, getDp(nr, nc, n));
            }
        }
        dp[r][c] = maxCount + 1;
        return dp[r][c];
    }
}