import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};
    static int[][] grid;
    static int n;
    static int k;
    static int m;
    static List<int[]> stones = new ArrayList<>();
    static List<int[]> starts = new ArrayList<>();
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        grid = new int[n+1][n+1];
        for (int r = 1; r <= n ; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 1; c <= n; c++) {
                int object = Integer.parseInt(stk.nextToken());
                grid[r][c] = object;
                if (object == 1) {
                    stones.add(new int[] {r, c});
                }
            }
        }
        for (int i = 0; i < k; i++) {
            stk = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            starts.add(new int[] {x, y});
        }

        findCombination(new ArrayList<>(), 0, 0);

        System.out.println(ans);
    }

    private static void findCombination(List<int[]> selectedStones, int depth, int idx) {
        if (depth == m) {
            for (int[] pos : selectedStones) {
                grid[pos[0]][pos[1]] = 0;
            }
            bfs();
            for (int[] pos : selectedStones) {
                grid[pos[0]][pos[1]] = 1;
            }
            return;
        }
        if (idx == stones.size()) {
            return;
        }

        findCombination(selectedStones, depth, idx + 1);

        selectedStones.add(stones.get(idx));
        findCombination(selectedStones, depth + 1, idx + 1);
        selectedStones.remove(selectedStones.size() - 1);
    }

    private static void bfs() {
        int count = 0;
        boolean[][] visited = new boolean[n+1][n+1];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int[] start : starts) {
            queue.offer(start);
            visited[start[0]][start[1]] = true;
            ++count;
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                if (nx <= 0 || ny <= 0 || nx > n || ny > n) {
                    continue;
                }
                if (visited[nx][ny] || grid[nx][ny] == 1) {
                    continue;
                }

                ++count;
                queue.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }

        ans = Integer.max(ans, count);
    }
}