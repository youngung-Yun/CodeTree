import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};
    static int n;
    static int[][] grid;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        grid = new int[n][n];
        int h = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        List<int[]> people = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                int v =  Integer.parseInt(stk.nextToken());
                grid[r][c] = v;
                if (v == 2) {
                    people.add(new int[] {r, c});
                }
            }
        }

        int[][] ans = new int[n][n];
        for (int[] person : people) {
            int x = person[0];
            int y = person[1];
            ans[x][y] = bfs(x, y);
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : ans) {
            for (int col : row) {
                sb.append(col).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] distance = new int[n][n];
        for (int[] row : distance) {
            Arrays.fill(row, -1);
        }

        queue.offer(new int[] {x, y});
        distance[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            if (grid[curr[0]][curr[1]] == 3) {
                return distance[curr[0]][curr[1]];
            }

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (distance[nx][ny] != -1 || grid[nx][ny] == 1) {
                    continue;
                }

                distance[nx][ny] = distance[curr[0]][curr[1]] + 1;
                queue.offer(new int[] {nx, ny});
            }
        }
        return -1;
    }
}