import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX = 100 * 1_000;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        // dp[i][k] == i번째 수를 어떤 그룹에 포함시켰을 때 차이가 k인 수를 만들 수 있는지
        // dp[n-1][0]이 true면 만들 수 있음
        boolean[][] dp = new boolean[n][MAX+1];

        dp[0][arr[0]] = true;
        for (int i = 1; i < n; i++) {
            int number = arr[i];
            for (int k = 0; k <= MAX; k++) {
                if (k + number <= MAX && dp[i-1][k+number]) {
                    dp[i][k] = true;
                } else if (dp[i-1][Math.abs(k - number)]) {
                    dp[i][k] = true;
                }
            }
        }

        System.out.println(dp[n-1][0] ? "Yes" : "No");
    }
}