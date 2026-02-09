import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};
    static int[][] grid;
    static int cx;
    static int cy;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        grid = new int[n+1][n+1];
        for (int r = 1; r <= n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 1; c <= n; c++) {
                grid[r][c] = Integer.parseInt(stk.nextToken());
            }
        }
        stk = new StringTokenizer(bf.readLine());
        cx = Integer.parseInt(stk.nextToken());
        cy = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < k; i++) {
            int[] newPos = bfs(n);
            if (cx == newPos[0] && cy == newPos[1]) {
                break;
            }
            cx = newPos[0];
            cy = newPos[1];
        }
        System.out.println(cx + " " + cy);
    }

    private static int[] bfs(int n) {
        boolean[][] visited = new boolean[n+1][n+1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {cx, cy});
        visited[cx][cy] = true;

        int number = 0;
        int x = n;
        int y = n;

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            if (grid[curr[0]][curr[1]] < grid[cx][cy] && number < grid[curr[0]][curr[1]]) {
                number = grid[curr[0]][curr[1]];
                x = curr[0];
                y = curr[1];
            } else if (number == grid[curr[0]][curr[1]]) {
                if (x > curr[0]) {
                    x = curr[0];
                    y = curr[1];
                } else if (x == curr[0]) {
                    if (y > curr[1]) {
                        y = curr[1];
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                if (nx <= 0 || ny <= 0 || nx > n || ny > n) {
                    continue;
                }
                if (grid[nx][ny] >= grid[cx][cy]) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                queue.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
        return new int[] {x, y};
    }
}