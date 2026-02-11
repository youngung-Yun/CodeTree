import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int[] dp = new int[n];
        for (int now = 0; now < n; now++) {
            dp[now] = 1;
            for (int prev = 0; prev < now; prev++) {
                if (arr[now] > arr[prev]) {
                    dp[now] = Integer.max(dp[now], dp[prev] + 1);
                }
            }
        }

        int ans = dp[0];
        for (int length : dp) {
            ans = Integer.max(ans, length);
        }
        System.out.println(ans);
    }
}