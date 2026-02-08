import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[] dx = {1, 0, -1, 0};
    final static int[] dy = {0, 1, 0, -1};

    static int n;
    static int[][] grid;
    static int ans = 0;
    static int count;

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

        List<Integer> population = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    visited[r][c] = true;
                    ++ans;
                    count = 1;
                    dfs(visited, r, c);
                    population.add(count);
                }
            }
        }

        population.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        sb.append(ans).append('\n');
        for (int p : population) {
            sb.append(p).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(boolean[][] visited, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }
            if (grid[nx][ny] == 0 || visited[nx][ny]) {
                continue;
            }

            visited[nx][ny] = true;
            ++count;
            dfs(visited, nx, ny);
        }
    }
}