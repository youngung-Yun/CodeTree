import java.util.Scanner;
public class Main {

    static String[] numbers = {"1", "22", "333", "4444"};
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        dfs("", n);

        System.out.println(ans);
    }

    static void dfs(String str, int n) {
        if (str.length() > n) {
            return;
        } else if (str.length() == n) {
            ++ans;
            return;
        } else {
            for (String number : numbers) {
                dfs(str + number, n);
            }
        }
    }
}