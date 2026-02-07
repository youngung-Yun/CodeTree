import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[][] grid;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        grid = new int[n][n];

        for (int r = 0; r < n; r++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                grid[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        dfs(new boolean[n+1], 0, 10_000);
        System.out.println(ans);

    }

    static void dfs(boolean[] colVisited, int row, int min) {
        if (row == n) {
            ans = Integer.max(ans, min);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (colVisited[col]) {
                continue;
            }

            colVisited[col] = true;
            dfs(colVisited, row + 1, Integer.min(min, grid[row][col]));
            colVisited[col] = false;
        }
    }
}