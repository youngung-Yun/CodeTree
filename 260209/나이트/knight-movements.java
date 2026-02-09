import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[][] dirs = { {1, 2}, {-1, -2}, {-1, 2}, {1, -2}, {2, 1}, {-2, -1}, {-2, 1}, {2, -1} };
    static int n;
    static int sx;
    static int sy;
    static int ex;
    static int ey;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        sx = Integer.parseInt(stk.nextToken());
        sy = Integer.parseInt(stk.nextToken());
        ex = Integer.parseInt(stk.nextToken());
        ey = Integer.parseInt(stk.nextToken());

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] distance = new int[n+1][n+1];
        for (int[] row : distance) {
            Arrays.fill(row, -1);
        }
        queue.offer(new int[] {sx, sy});
        distance[sx][sy] = 0;

        while (!queue.isEmpty() && distance[ex][ey] == -1) {
            int[] curr = queue.remove();
            int x = curr[0];
            int y = curr[1];

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx <= 0 || ny <= 0 || nx > n || ny > n) {
                    continue;
                }
                if (distance[nx][ny] != -1) {
                    continue;
                }

                distance[nx][ny] = distance[x][y] + 1;
                queue.offer(new int[] {nx, ny});
            }
        }
        return distance[ex][ey];
    }
}