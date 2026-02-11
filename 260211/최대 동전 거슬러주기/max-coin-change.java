import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        final int INIT = -1;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        // dp[n] = max(dp-coins) + 1
        int[] dp = new int[m+1];
        Arrays.fill(dp, INIT);
        dp[0] = 0;

        for (int money = 1; money <= m; money++) {
            for (int c : coin) {
                if (money - c < 0) {
                    continue;
                }
                dp[money] = Integer.max(dp[money], dp[money-c] + 1);
            }
        }
        System.out.println(dp[m]);
    }
}