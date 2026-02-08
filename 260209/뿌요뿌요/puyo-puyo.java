import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[] dx = {1, 0, -1, 0};
    final static int[] dy = {0, 1, 0, -1};

    static int n;
    static int[][] grid;
    static int size;
    static int ans = 0;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        grid = new int[n][n];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                grid[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        boolean[][] visited = new boolean[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (!visited[r][c]) {
                    size = 0;
                    visited[r][c] = true;
                    dfs(visited, r, c, grid[r][c]);
                    if (size >= 4) {
                        ++ans;
                    }
                    max = Integer.max(max, size);
                }
            }
        }
        System.out.println(ans + " " + max);
    }

    static void dfs(boolean[][] visited, int x, int y, int value) {
        ++size;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }
            if (grid[nx][ny] != value || visited[nx][ny]) {
                continue;
            }
            visited[nx][ny] = true;
            dfs(visited, nx, ny, value);
        }
    }
}