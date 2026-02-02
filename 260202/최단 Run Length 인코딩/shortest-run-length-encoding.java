import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        int n = A.length();
        
        int ans = n * 2;
        char[] charArray = A.toCharArray();
        // N번 shift하며 문자열 구해 길이 비교
        for (int i = 0; i < n; i++) {
            shift(charArray, n);
            ans = Integer.min(ans, getLength(charArray, n));
        }
        System.out.println(ans);
    }

    static void shift(char[] charArray, int n) {
        char tmp = charArray[n-1];
        for (int i = n - 1; i >= 1; i--) {
            charArray[i] = charArray[i-1];
        }
        charArray[0] = tmp;
    }
    
    static int getLength(char[] charArray, int n) {
        char curr = charArray[0];
        int count = 0;
        int length = 0;
        for (int i = 0; i < n; i++) {
            if (curr == charArray[i]) {
                ++count;
            } else {
                length += (1 + String.valueOf(count).length());
                curr = charArray[i];
                count = 1;
            }
        }
        length += (1 + String.valueOf(count).length());
        return length;
    }
}