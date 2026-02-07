import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int ans = 100 * 100 * 2;
    static int[][] points;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        points = new int[n][2];
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            points[i] = new int[] {x, y};
        }
        dfs(new ArrayList<>(), 0);
        System.out.println(ans);
    }

    static void dfs(List<int[]> selected, int curr) {
        if (selected.size() == m) {
            int farthest = 0;
            for (int i = 0; i < m; i++) {
                int[] a = selected.get(i);
                for (int j = i + 1; j < m; j++) {
                    int[] b = selected.get(j);
                    int dx = a[0] - b[0];
                    int dy = a[1] - b[1];
                    int distance = (dx * dx) + (dy * dy);
                    farthest = Integer.max(farthest, distance);
                }
            }
            ans = Integer.min(ans, farthest);
            return;
        }

        for (int i = curr; i < n; i++) {
            selected.add(points[i]);
            dfs(selected, i + 1);
            selected.remove(selected.size() - 1);
        }
    }
}