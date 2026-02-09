import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};
    static int n;
    static int k;
    static int u;
    static int d;
    static int[][] cities;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        u = Integer.parseInt(stk.nextToken());
        d = Integer.parseInt(stk.nextToken());

        cities = new int[n][n];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                cities[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        combination(new int[k], 0, 0);
        System.out.println(ans);
    }

    static void combination(int[] arr, int depth, int curr) {
        if (depth == k) {
            List<int[]> start = new ArrayList<>();
            for (int e : arr) {
                start.add(new int[] {e / n, e % n});
            }
            ans = Integer.max(ans, bfs(start));
            return;
        }

        for (int i = curr; i < n * n; i++) {
            arr[depth] = i;
            combination(arr, depth + 1, i + 1);
        }
    }

    private static int bfs(List<int[]> start) {
        int count = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        for (int[] s : start) {
            queue.offer(s);
            visited[s[0]][s[1]] = true;
            ++count;
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
                if (visited[nx][ny]) {
                    continue;
                }
                int diff = Math.abs(cities[x][y] - cities[nx][ny]);
                if (diff < u || diff > d) {
                    continue;
                }
                visited[nx][ny] = true;
                ++count;
                queue.offer(new int[] {nx, ny});
            }
        }
        return count;
    }
}