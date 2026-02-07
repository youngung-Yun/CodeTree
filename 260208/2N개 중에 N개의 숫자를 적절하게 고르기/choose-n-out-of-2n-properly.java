import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static int ans = 0;

    static boolean canReach = false;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        arr = new int[n*2];
        StringTokenizer token = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n * 2; i++) {
            int element = Integer.parseInt(token.nextToken());
            arr[i] = element;
            ans += element;
        }
        dfs(0, 0, 0, 0, 0);
        System.out.println(ans);
    }

    static void dfs(int groupA, int groupB, int groupACount, int groupBCount, int depth) {
        if (depth == n * 2) {
            if (groupACount != groupBCount) {
                return;
            }
            ans = Integer.min(ans, Math.abs(groupA - groupB));
            return;
        }

        int curr = arr[depth];
        dfs(groupA + curr, groupB, groupACount + 1, groupBCount, depth + 1);
        dfs(groupA, groupB + curr, groupACount, groupBCount + 1, depth + 1);
    }
}