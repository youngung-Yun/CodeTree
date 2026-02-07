import java.util.Scanner;

public class Main {

    static boolean isEnd = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        dfs(new int[n], 0, n);
    }

    static void dfs(int[] arr, int depth, int n) {
        if (isEnd) {
            return;
        }
        if (!isPossibleSequence(arr, depth)) {
            return;
        }
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (int e : arr) {
                sb.append(e);
            }
            System.out.println(sb);
            isEnd = true;
            return;
        }

        for (int i = 4; i <= 6; i++) {
            arr[depth] = i;
            dfs(arr, depth + 1, n);
        }
    }

    static boolean isPossibleSequence(int[] arr, int length) {
        for (int start = 0; start < length; start++) {
            for (int l = 1; (start + l + l) <= length; ++l) {
                boolean isSameAll = true;
                for (int i = 0; i < l; i++) {
                    if (arr[start+i] != arr[start+l+i]) {
                        isSameAll = false;
                        break;
                    }
                }
                if (isSameAll) {
                    return false;
                }
            }
        }
        return true;
    }

    static long arrayToInt(int[] arr) {
        long num = 0L;
        for (int digit : arr) {
            num *= 10L;
            num += digit;
        }
        return num;
    }
}