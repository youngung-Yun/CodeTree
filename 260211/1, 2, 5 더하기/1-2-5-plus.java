import java.util.Arrays;
import java.util.Scanner;
public class Main {

    static int[] dp;
    final static int MOD = 10_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        int ans = computeDp(n);
        System.out.println(ans);
    }

    static int computeDp(int n) {
        if (n < 0) {
            return 0;
        }
        if (dp[n] == -1) {
            dp[n] = (((computeDp(n - 1) + computeDp(n - 2)) % MOD) + computeDp(n - 5)) % MOD;
        }
        return dp[n];
    }
}