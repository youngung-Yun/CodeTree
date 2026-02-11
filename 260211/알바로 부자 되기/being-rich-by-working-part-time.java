import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // [start, end, pay]
        int[][] partTime = new int[n][3];
        for (int i = 0; i < n; i++) {
            partTime[i][0] = sc.nextInt();
            partTime[i][1] = sc.nextInt();
            partTime[i][2] = sc.nextInt();
        }

        Arrays.sort(partTime, (p1, p2) -> Integer.compare(p1[0], p2[0]));

        int[] dp = new int[n];
        for (int now = 0; now < n; now++) {
            // 자신보다 빨리 시작하면서 종료 시간이 나의 시작 시간 이전인 알바들 중 최대 dp값 + 현재 알바 수익
            dp[now] = partTime[now][2];
            for (int prev = 0; prev < now; prev++) {
                if (partTime[prev][1] < partTime[now][0]) {
                    dp[now] = Integer.max(dp[now], dp[prev] + partTime[now][2]);
                }
            }
        }
        int ans = IntStream.of(dp).max().getAsInt();

        System.out.println(ans);
    }
}