import java.util.Scanner;
public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        answer = new int[n];
        dfs(0, n, k);
        System.out.println(sb);
    }

    static void dfs(int depth, int n, int k) {
        if (depth == n) {
            for (int e : answer) {
                sb.append(e).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= k; i++) {
            if (depth >= 2 && answer[depth-1] == i && answer[depth-2] == i) {
                continue;
            }
            answer[depth] = i;
            dfs(depth + 1, n, k);
        }
    }
}