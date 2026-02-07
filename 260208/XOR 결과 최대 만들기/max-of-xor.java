import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] arr;

    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        arr = new int[n];
        token = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        dfs(0, 0, 0);
        System.out.println(ans);
    }

    static void dfs(int curr, int depth, int start) {
        if (depth == m) {
            ans = Integer.max(ans, Math.abs(curr));
            return;
        }

        for (int i = start; i < n; i++) {
            if (depth == 0) {
                dfs(arr[i], depth + 1, i + 1);
            } else {
                dfs(curr ^ arr[i], depth + 1, i + 1);
            }
        }
    }
}