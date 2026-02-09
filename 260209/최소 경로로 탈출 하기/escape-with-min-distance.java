import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int[][] grid;

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

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] distance = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        queue.offer(new int[] {0, 0});
        distance[0][0] = 0;
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int x = curr[0];
            int y = curr[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (visited[nx][ny] || grid[nx][ny] == 0) {
                    continue;
                }

                visited[nx][ny] = true;
                distance[nx][ny] = distance[x][y] + 1;
                queue.offer(new int[] {nx, ny});
            }
        }
        return visited[n-1][m-1] ? distance[n-1][m-1] : -1;
    }
}