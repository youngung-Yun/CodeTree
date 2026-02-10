import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[][] grid = new int[n][n];
        int[][] ans = new int[n][n];

        List<int[]> rottedOranges = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                int object = Integer.parseInt(stk.nextToken());
                grid[r][c] = object;
                if (object == 0) {
                    ans[r][c] = -1;
                } else if (object == 2) {
                    rottedOranges.add(new int[] {r, c});
                    ans[r][c] = -2;
                } else {
                    ans[r][c] = -2;
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        for (int[] start : rottedOranges) {
            queue.offer(start);
            ans[start[0]][start[1]] = 0;
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
                // 빈칸이거나 방문함
                if (ans[nx][ny] > -2) {
                    continue;
                }
                queue.offer(new int[] {nx, ny});
                ans[nx][ny] = ans[x][y] + 1;
            }
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
}