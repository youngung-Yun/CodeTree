import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        // Please write your code here.
        dfs(new int[n], k, 0, n);
        System.out.println(sb);
    }

    static void dfs(int[] arr, int k, int depth, int n) {
        if (depth == n) {
            for (int e : arr) {
                sb.append(e).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= k; i++) {
            arr[depth] = i;
            dfs(arr, k, depth + 1, n);
        }
    }
}