import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[][] grid;
    static int[][] coins = new int[10][2];
    static int[] start;
    static int[] end;

    static int ans;

    static boolean canReach = false;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        ans = n * n * 10;
        grid = new int[n][n];

        boolean[] visited = new boolean[10];
        Arrays.fill(visited, true);
        for (int r = 0; r < n; r++) {
            String row = bf.readLine();
            for (int c = 0; c < n; c++) {
                char ch = row.charAt(c);
                if (ch == 'S') {
                    start = new int[] {r, c};
                } else if (ch == 'E') {
                    end = new int[] {r, c};
                } else if (Character.isDigit(ch)) {
                    coins[ch - '0'] = new int[] {r, c};
                    visited[ch - '0'] = false;
                }
            }
        }
        dfs(visited, 0, new int[3], 1);
        System.out.println(canReach ? ans : -1);
    }

    static void dfs(boolean[] visited, int depth, int[] arr, int next) {
        if (depth == 3) {
            int distance = 0;
            int[] curr = start;
            for (int e : arr) {
                int[] dest = coins[e];
                distance += getDistance(curr, dest);
                curr = dest;
            }
            distance += getDistance(curr, end);
            ans = Integer.min(ans, distance);
            canReach = true;
            return;
        }

        for (int i = next; i < 10; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            arr[depth] = i;
            dfs(visited, depth + 1, arr, i + 1);
            visited[i] = false;
        }
    }

    static int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}