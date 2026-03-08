import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        // Please write your code here.

        // i번째 계단까지 오면서 1계단 오르기를 j번 했을 때의 최대 동전 개수
        int[][] dp = new int[n][4];

        dp[0][0] = coins[0];
        dp[1][1] = coins[1];

        for (int stair = 2; stair < n; stair++) {
            dp[stair][0] = dp[stair-2][0] + coins[stair];
            for (int oneStep = 1; oneStep < 4; oneStep++) {
                dp[stair][oneStep] = Integer.max(dp[stair-2][oneStep] , dp[stair-1][oneStep-1]) + coins[stair];
            }
        }

        int ans = 0;
        for (int oneStep = 0; oneStep < 4; oneStep++) {
            ans = Integer.max(ans, dp[n-1][oneStep]);
        }

        System.out.println(ans);
    }
}