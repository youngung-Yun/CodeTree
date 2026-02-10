import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[1_001];
        dp[2] = dp[3] = 1;
        dp[4] = 2;
        for (int i = 5; i <= n; i++) {
            dp[i] = (dp[i-2] + dp[i-3]) % 10_007;
        }
        System.out.println(dp[n]);
    }
}