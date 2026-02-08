import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[] dx = {1, 0, -1, 0};
    final static int[] dy = {0, 1, 0, -1};

    static int n;
    static int m;
    static int[][] grid;
    static int maxSafeArea = 0;
    static int ans = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        grid = new int[n][m];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < m; c++) {
                grid[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        for (int k = 1; k <= 100; k++) {
            int safeAreaCount = 0;
            boolean[][] visited = new boolean[n][m];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (grid[r][c] > k && !visited[r][c]) {
                        ++safeAreaCount;
                        visited[r][c] = true;
                        dfs(visited, r, c, k);
                        if (safeAreaCount > maxSafeArea) {
                            maxSafeArea = safeAreaCount;
                            ans = k;
                        }
                    }
                }
            }
        }

        System.out.println(ans + " " + maxSafeArea);
    }

    static void dfs(boolean[][] visited, int x, int y, int k) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }
            if (grid[nx][ny] <= k || visited[nx][ny]) {
                continue;
            }

            visited[nx][ny] = true;
            dfs(visited, nx, ny, k);
        }
    }
}