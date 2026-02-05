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

        int ans = 0;

        for (int bit = 1; bit < Math.pow(2, n); bit++) {
            int[] arr = new int[1_001];
            for (int i = 0; i < n; i++) {
                int mask = 1 << i;
                if ((bit & mask) != 0) {
                    for (int x = segments[i][0]; x <= segments[i][1]; x++) {
                        ++arr[x];
                    }
                }
            }
            boolean isOverlapped = false;
            for (int c : arr) {
                if (c > 1) {
                    isOverlapped = true;
                    break;
                }
            }
            if (!isOverlapped) {
                ans = Integer.max(ans, Integer.bitCount(bit));
            }
        }
        System.out.println(ans);
    }
}