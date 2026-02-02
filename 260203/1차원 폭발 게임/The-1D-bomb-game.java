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
            boolean explode = false;
            for (int i = 0; i < bombs.length; i++) {
                if (curr == bombs[i]) {
                    ++count;
                } else {
                    if (count >= m) {
                        markBombs(left, i);
                        explode = true;
                    }
                    curr = bombs[i];
                    count = 1;
                    left = i;
                }
            }
            if (count >= m) {
                markBombs(left, bombs.length);
                explode = true;
            }
            explosion();
            // 더 이상 터뜨릴 폭탄이 없음
            if (!explode) {
                break;
            }
        }

        System.out.println(bombs.length);
        for (int bomb : bombs) {
            System.out.println(bomb);
        }
    }

    static void markBombs(int start, int end) {
        for (int i = start; i < end; i++) {
            bombs[i] = 0;
        }
    }

    static void explosion() {
        List<Integer> tmp = new ArrayList<>();
        for (int bomb : bombs) {
            if (bomb != 0) {
                tmp.add(bomb);
            }
        }
        int[] result = new int[tmp.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = tmp.get(i);
        }
        bombs = result;
    }
}