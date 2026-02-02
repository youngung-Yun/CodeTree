import java.util.*;

public class Main {

    static int[] bombs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        bombs = new int[n];
        for (int i = 0; i < n; i++) {
            bombs[i] = sc.nextInt();
        }

        while (bombs.length >= m) {
            int curr = bombs[0];
            int count = 0;
            int left = 0;
            int right = bombs.length;
            for (int i = 0; i < bombs.length; i++) {
                if (curr == bombs[i]) {
                    ++count;
                } else {
                    if (count >= m) {
                        right = i;
                        break;
                    }
                    curr = bombs[i];
                    count = 1;
                    left = i;
                }
            }
            // m개 이상 반복된 폭탄이 있으면 터뜨림
            if (count >= m) {
                explosion(left, right);
                continue;
            }
            break;
        }

        System.out.println(bombs.length);
        for (int bomb : bombs) {
            System.out.println(bomb);
        }
    }

    static void explosion(int start, int end) {
        int[] tmp = new int[bombs.length - (end - start)];
        int idx = 0;
        for (int i = 0; i < bombs.length; i++) {
            if (idx >= tmp.length) {
                break;
            }
            if (i < start || i >= end) {
                tmp[idx++] = bombs[i];
            }
        }
        bombs = tmp;
    }
}