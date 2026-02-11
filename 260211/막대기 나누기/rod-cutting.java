import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] profit = new int[n+1];
        for (int i = 1; i <= n; i++) {
            profit[i] = sc.nextInt();
        }

        // dp[k] = k인 막대기를 팔았을 때 최대 수익
        // max(dp[k-1]+profit[1], dp[k-2]+profit[2] + ... + dp[0]+profit[n])
        int[] dp = new int[n+1];
        for (int length = 1; length <= n; length++) {
            for (int part = 0; part <= length; part++) {
                dp[length] = Integer.max(dp[length], dp[length-part] + profit[part]);
            }
        }
        System.out.println(dp[n]);
    }
}