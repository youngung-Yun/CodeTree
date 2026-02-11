import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int INIT = 10_001;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++)
            coin[i] = sc.nextInt();
        // Please write your code here.

        int[] dp = new int[m+1];
        dp[0] = 0;
        for (int pay = 1; pay <= m; pay++) {
            dp[pay] = INIT;
            for (int c : coin) {
                if (pay - c < 0) {
                    continue;
                }
                dp[pay] = Integer.min(dp[pay], dp[pay - c] + 1);
            }
        }
        System.out.println(dp[m] == INIT ? -1 : dp[m]);
    }
}