import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[][] adj;
    static int ans = 10_000 * 10;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        adj = new int[n][n];

        for (int r = 0; r < n; r++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                adj[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        int[] arr = new int[n+1];
        dfs(new boolean[n+1], arr, 1);
        System.out.println(ans);

    }

    static void dfs(boolean[] visited, int[] arr, int depth) {
        if (depth == n) {
            int cost = 0;
            boolean canTravel = true;
            for (int i = 0; i < n; i++) {
                int curr = arr[i];
                int next = arr[i+1];
                if (adj[curr][next] == 0) {
                    canTravel = false;
                    break;
                }
                cost += adj[curr][next];
            }
            if (canTravel) {
                ans = Integer.min(ans, cost);
            }
            return;
        }

        for (int i = 1; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            arr[depth] = i;
            visited[i] = true;
            dfs(visited, arr, depth + 1);
            visited[i] = false;
        }
    }
}