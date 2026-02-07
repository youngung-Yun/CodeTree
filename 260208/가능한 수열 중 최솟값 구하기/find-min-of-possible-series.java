import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int ans = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        dfs(new int[n], 0, n);
        System.out.println(ans);
    }

    static void dfs(int[] arr, int depth, int n) {
        if (ans != -1) {
            return;
        }
        if (!isPossibleSequence(arr, depth)) {
            return;
        }
        if (depth == n) {
            ans = arrayToInt(arr);
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

    static int arrayToInt(int[] arr) {
        int num = 0;
        for (int digit : arr) {
            num *= 10;
            num += digit;
        }
        return num;
    }
}