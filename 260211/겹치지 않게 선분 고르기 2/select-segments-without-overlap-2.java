import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }

        Arrays.sort(segments, (s1, s2) -> Integer.compare(s1[0], s2[0]));

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int now = 0; now < n; now++) {
            for (int prev = 0; prev < n; prev++) {
                // 자신보다 먼저 시작인 선들에서 자신의 시작보다 끝이 빠른 선분들 중 최대 개수 + 1
                if (segments[prev][1] < segments[now][0]) {
                    dp[now] = Integer.max(dp[now], dp[prev] + 1);
                }
            }
        }

        int ans = Arrays.stream(dp).max().getAsInt();
        System.out.println(ans);
    }
}