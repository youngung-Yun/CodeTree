import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] maze = new int[n][m];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < m; c++) {
                maze[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        boolean canEscape = false;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int x = curr[0];
            int y = curr[1];
            if (x == n - 1 && y == m - 1) {
                canEscape = true;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (maze[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
            }
        }

        System.out.println(canEscape ? 1 : 0);
    }

}