import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int now = 0; now < n; now++) {
            for (int prev = 0; prev < now; prev++) {
                if (dp[prev] != -1 && prev + arr[prev] >= now) {
                    dp[now] = Integer.max(dp[now], dp[prev] + 1);
                }
            }
        }

        int ans = IntStream.of(dp).max().getAsInt();
        System.out.println(ans);
    }
}