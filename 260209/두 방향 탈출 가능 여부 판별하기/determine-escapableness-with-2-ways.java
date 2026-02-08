import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[] dx = {1, 0};
    final static int[] dy = {0, 1};

    static int n;
    static int m;
    static int[][] grid;
    static int escape = 0;

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

        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        dfs(visited, 0, 0);

        System.out.println(escape);
    }

    static void dfs(boolean[][] visited, int x, int y) {
        // 탈출 가능 확인되었으면 종료
        if (escape == 1) {
            return;
        }
        if (x == n - 1 && y == m - 1) {
            escape = 1;
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }
            // 뱀
            if (grid[nx][ny] == 0) {
                continue;
            }
            if (visited[nx][ny]) {
                continue;
            }
            visited[nx][ny] = true;
            dfs(visited, nx, ny);
        }
    }
}