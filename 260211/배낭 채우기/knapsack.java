import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int INIT = -1;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        // dp[k] = 무게가 k 일때의 최대 가치
        int[] dp = new int[m+1];
        Arrays.fill(dp, INIT);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int weight = w[i];
            int value = v[i];
            for (int totalWeight = m; totalWeight >= weight; --totalWeight) {
                if (dp[totalWeight-weight] != INIT) {
                    dp[totalWeight] = Integer.max(dp[totalWeight], dp[totalWeight-weight] + value);
                }
            }
        }
        int ans = Arrays.stream(dp).max().getAsInt();
        System.out.println(ans);
    }
}