import java.io.*;
import java.util.*;

public class Main {

    static int n, m, k;
    static int ans = 0;
    static int[] move;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        k = Integer.parseInt(token.nextToken());

        move = new int[n];
        token = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            move[i] = Integer.parseInt(token.nextToken());
        }

        int[] pos = new int[k];
        Arrays.fill(pos, 1);
        dfs(pos, 0);

        System.out.println(ans);
    }

    static void dfs(int[] curr, int depth) {
        if (depth == n) {
            int point = 0;
            for (int p : curr) {
                point += p >= m ? 1 : 0;
            }
            ans = Integer.max(ans, point);
            return;
        }

        for (int i = 0; i < k; i++) {
            curr[i] += move[depth];
            dfs(curr, depth + 1);
            curr[i] -= move[depth];
        }
    }
}