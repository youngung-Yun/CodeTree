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
        int k = Integer.parseInt(stk.nextToken());

        int[][] grid = new int[n][n];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                grid[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        int ans = 0;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            stk = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(stk.nextToken()) - 1;
            int y = Integer.parseInt(stk.nextToken()) - 1;
            queue.offer(new int[] {x, y});
            visited[x][y] = true;
            ++ans;
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int x = curr[0];
            int y = curr[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (grid[nx][ny] == 1 || visited[nx][ny]) {
                    continue;
                }
                ++ans;
                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
            }
        }

        System.out.println(ans);
    }

}