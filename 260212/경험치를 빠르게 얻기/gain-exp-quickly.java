import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX = 100 * 100;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] exp = new int[n+1];
        int[] time = new int[n+1];
        for (int i = 1; i <= n; i++) {
            exp[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }

        // dp[i][t] = i번째 퀘스트까지 고려했을 때 시간 t 안에 넣을 수 있는 최대 경험치
        int[][] dp = new int[n+1][MAX+1];

        for (int quest = 1; quest <= n; quest++) {
            for (int elapsed = 1; elapsed <= MAX; elapsed++) {
                if (elapsed - time[quest] < 0) {
                    dp[quest][elapsed] = dp[quest-1][elapsed];
                } else {
                    dp[quest][elapsed] = Integer.max(dp[quest-1][elapsed], dp[quest-1][elapsed-time[quest]] + exp[quest]);
                }
            }
        }

        int ans = -1;
        for (int elapsed = 1; elapsed <= MAX; elapsed++) {
            if (ans != -1) {
                break;
            }
            for (int quest = 1; quest <= n; quest++) {
                if (dp[quest][elapsed] >= m) {
                    ans = elapsed;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}