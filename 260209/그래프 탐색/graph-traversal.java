import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static boolean[][] adj;
    static int ans = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        adj = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            adj[a][b] = true;
            adj[b][a] = true;
        }

        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        dfs(visited, 1);
        System.out.println(ans);
    }

    static void dfs(boolean[] visited, int curr) {
        ++ans;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            if (adj[curr][i]) {
                visited[i] = true;
                dfs(visited, i);
            }
        }
    }
}