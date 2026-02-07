import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean canReach = false;
    static int ans;
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        ans = n;
        arr = new int[n];
        StringTokenizer token = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        dfs(0, 0);

        System.out.println(canReach ? ans : -1);
    }

    static void dfs(int current, int count) {
        if (current >= n) {
            return;
        } else if (current == n - 1) {
            canReach = true;
            ans = Integer.min(ans, count);
            return;
        }

        for (int jump = 1; jump <= arr[current]; ++jump) {
            dfs(current + jump, count + 1);
        }
    }
}