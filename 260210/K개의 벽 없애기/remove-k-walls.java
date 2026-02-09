import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};
    static int n;
    static int k;
    static int[][] grid;
    static int sx;
    static int sy;
    static int ex;
    static int ey;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        grid = new int[n][n];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                grid[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        stk = new StringTokenizer(bf.readLine());
        sx = Integer.parseInt(stk.nextToken()) - 1;
        sy = Integer.parseInt(stk.nextToken()) - 1;

        stk = new StringTokenizer(bf.readLine());
        ex = Integer.parseInt(stk.nextToken()) - 1;
        ey = Integer.parseInt(stk.nextToken()) - 1;

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][][] distance = new int[n][n][k+1];
        for (int[][] row : distance) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }

        queue.offer(new int[] {sx, sy, 0});
        distance[sx][sy][0] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int x = curr[0];
            int y = curr[1];
            int destroy = curr[2];

            if (x == ex && y == ey) {
                return distance[x][y][destroy];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                if (grid[nx][ny] == 0 && distance[nx][ny][destroy] == -1) {
                    distance[nx][ny][destroy] = distance[x][y][destroy] + 1;
                    queue.offer(new int[] {nx, ny, destroy});
                } else if (grid[nx][ny] == 1 && destroy < k && distance[nx][ny][destroy+1] == -1) {
                    distance[nx][ny][destroy + 1] = distance[x][y][destroy] + 1;
                    queue.offer(new int[] {nx, ny, destroy + 1});
                }
            }
        }
        return -1;
    }
}