import java.util.*;
public class Main {

    static int ans = Integer.MIN_VALUE;
    static String expression;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        expression = sc.next();

        dfs(new int[6], 0);

        System.out.println(ans);
    }

    static void dfs(int[] tmp, int depth) {
        if (depth == 6) {
            ans = Integer.max(ans, calculate(tmp));
            return;
        }

        for (int i = 1; i <= 4; i++) {
            tmp[depth] = i;
            dfs(tmp, depth + 1);
        }
    }

    static int calculate(int[] variables) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            map.put(((char) ('a' + i)), variables[i]);
        }

        int curr = map.get(expression.charAt(0));
        char operator = ' ';
        for (int i = 1; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isAlphabetic(ch)) {
                int number = map.get(ch);
                if (operator == '+') {
                    curr += number;
                } else if (operator == '-') {
                    curr -= number;
                } else {
                    curr *= number;
                }
            } else {
                operator = ch;
            }
        }
        return curr;
    }
}