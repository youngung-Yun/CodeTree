import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        // dp[i] = 노드가 i개인 트리의 가짓수
        // == 왼쪽이 0개, 오른쪽이 i - 1개인 트리의 가짓수 + 
        // 왼쪽이 1개, 오른쪽이 i - 2개인 트리의 가짓수 ...
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += (dp[j] * dp[i - 1 - j]);
            }
            dp[i] = sum;
        }

        System.out.println(dp[n]);
    }
}