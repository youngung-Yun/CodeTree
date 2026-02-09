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

        bfs();
    }

    private static void bfs() {
        // [x, y, time]
        Deque<int[]> pq = new ArrayDeque<>();
        int[][] distance = new int[n][m];
        for (int[] row : distance) {
            Arrays.fill(row, -1);
        }
        pq.offerLast(new int[] {0, 0});
        distance[0][0] = 0;

        int maxTime = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.removeFirst();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (distance[nx][ny] != -1) {
                    continue;
                }
                if (grid[nx][ny] == 0) {
                    distance[nx][ny] = distance[curr[0]][curr[1]];
                    pq.offerFirst(new int[] {nx, ny});
                } else if (grid[nx][ny] == 1) {
                    distance[nx][ny] = distance[curr[0]][curr[1]] + 1;
                    pq.offerLast(new int[] {nx, ny});
                }
            }
        }

        int[] result = findMax(distance);
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] findMax(int[][] distance) {
        int maxDistance = 0;
        int count = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 0) {
                    continue;
                }
                if (distance[r][c] > maxDistance) {
                    maxDistance = distance[r][c];
                    count = 1;
                } else if (distance[r][c] == maxDistance) {
                    ++count;
                }
            }
        }
        return new int[] {maxDistance, count};
    }
}