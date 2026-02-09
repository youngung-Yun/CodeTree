import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int[][] grid;
    static List<int[]> starts = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        grid = new int[n][m];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                grid[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        findStarts();
        bfs();
    }

    private static void findStarts() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            starts.add(curr);

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (grid[nx][ny] == 1) {
                    continue;
                }
                queue.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
    }

    private static void bfs() {
        // [x, y, time]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> Integer.compare(a1[2], a2[2]));
        boolean[][] visited = new boolean[n][m];
        for (int[] start : starts) {
            pq.add(new int[] {start[0], start[1], 0});
            visited[start[0]][start[1]] = true;
        }

        int maxTime = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.remove();

            if (curr[2] > maxTime) {
                maxTime = curr[2];
                count = 1;
            } else if (curr[2] == maxTime) {
                ++count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (grid[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    pq.offer(new int[] {nx, ny, curr[2]});
                } else if (grid[nx][ny] == 1) {
                    pq.offer(new int[] {nx, ny, curr[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        System.out.println(maxTime + " " + count);
    }
}