import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                for (int k = i + 1; k < str.length(); k++) {
                    if (str.charAt(k) == ')') {
                        ++count;
                    }
                }
            } else {
                for (int k = i - 1; k >= 0; k--) {
                    if (str.charAt(k) == '(') {
                        ++count;
                    }
                }
            }
        }
        System.out.println(count / 2);
    }
}