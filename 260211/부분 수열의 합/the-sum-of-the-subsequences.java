import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[] dp = new boolean[m+1];
        dp[0] = true;
        for (int number : arr) {
            for (int sum = m; sum >= number; --sum) {
                if (dp[sum-number]) {
                    dp[sum] = true;
                }
            }
        }
        System.out.println(dp[m] ? "Yes" : "No");
    }
}