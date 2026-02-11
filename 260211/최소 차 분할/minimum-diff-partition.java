import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        final int MAX = 1_000 * 100;
        // dp[i][k] = i번째 수를 넣었을 때 최솟값 k를 만들 수 있는지
        // == 최솟값 k를 만들 수 있으려면 i-1에서 k + number 또는 Math.abs(k - number)가 true여야 함
        boolean[][] dp = new boolean[n][MAX + 1];
        dp[0][arr[0]] = true;
        for (int i = 1; i < n; i++) {
            int number = arr[i];
            for (int min = 0; min <= MAX; min++) {
                if (min + number < MAX && dp[i-1][min+number]) {
                    dp[i][min] = true;
                }
                if (dp[i-1][Math.abs(min - number)]) {
                    dp[i][min] = true;
                }
            }
        }

        int ans = 0;
        for (int min = 0; min <= MAX; min++) {
            if (dp[n-1][min]) {
                ans = min;
                break;
            }
        }
        System.out.println(ans);
    }
}