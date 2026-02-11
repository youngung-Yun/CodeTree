import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] ascending = new int[n];
        for (int now = 0; now < n; now++) {
            ascending[now] = 1;
            for (int prev = 0; prev < now; prev++) {
                if (arr[now] > arr[prev]) {
                    ascending[now] = Integer.max(ascending[now], ascending[prev] + 1);
                }
            }
        }

        int[] descending = new int[n];
        for (int now = n - 1; now >= 0; now--) {
            descending[now] = 1;
            for (int next = n - 1; next > now; next--) {
                if (arr[now] > arr[next]) {
                    descending[now] = Integer.max(descending[now], descending[next] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Integer.max(ans, ascending[i] + descending[i] - 1);
        }
        System.out.println(ans);
    }
}