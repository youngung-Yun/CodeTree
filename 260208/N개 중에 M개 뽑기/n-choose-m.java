import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        dfs(new int[m], 0, 1);
        System.out.println(sb);
    }

    static void dfs(int[] arr, int depth, int curr) {
        if (depth == m) {
            for (int e : arr) {
                sb.append(e).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int num = curr; num <= n; num++) {
            arr[depth] = num;
            dfs(arr, depth + 1, num + 1);
        }
    }
}