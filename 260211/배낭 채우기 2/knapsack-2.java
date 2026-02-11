import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int INIT = -1;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        // dp[k] = 무게의 합이 k인 경우의 최대 가치
        int[] dp = new int[m+1];
        Arrays.fill(dp, INIT);
        dp[0] = 0;
        for (int totalWeight = 1; totalWeight <= m; totalWeight++) {
            for (int i = 0; i < n; i++) {
                int w = weight[i];
                int v = value[i];
                if (totalWeight - w < 0 || dp[totalWeight - w] == INIT) {
                    continue;
                }
                dp[totalWeight] = Integer.max(dp[totalWeight], dp[totalWeight - w] + v);
            }
        }

        int ans = Arrays.stream(dp).max().getAsInt();
        System.out.println(ans);
    }
}