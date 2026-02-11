import java.util.Arrays;
import java.util.Scanner;
public class Main {

    final static int MAX = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        // 더해서 i가 되는 최소 수열 길이
        int[] dp = new int[m+1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int number : arr) {
            for (int sum = m; sum > 0; --sum) {
                if (sum - number < 0) {
                    continue;
                }
                dp[sum] = Integer.min(dp[sum], dp[sum-number] + 1);
            }
        }

        System.out.println(dp[m] == MAX ? -1 : dp[m]);
    }
}