import java.util.*;
public class Main {

    static int n;
    static int m;
    static int[] init;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        init = new int[n+1];
        m = sc.nextInt();
        int[][] ladders = new int[m][2];
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            // [height, a, b]
            ladders[i] = new int[] {b, a, a + 1};
        }

        Arrays.sort(ladders, (a1, a2) -> Integer.compare(a1[0], a2[0]));

        // 초기 결과
        playLadderGame(ladders);

        int ans = m;
        for (int bitset = 0; bitset < Math.pow(2, m); bitset++) {
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int mask = 1 << i;
                if ((bitset & mask) != 0) {
                    // [height, a, b]
                    list.add(ladders[i]);
                }
            }
            list.sort((a1, a2) -> Integer.compare(a1[0], a2[0]));
            int[] result = playLadderGame(list);
            if (isSame(result, n)) {
                ans = Integer.min(ans, Integer.bitCount(bitset));
            }
        }
        System.out.println(ans);
    }

    static int[] playLadderGame(List<int[]> ladders) {
        int[] result = new int[n+1];
        for (int p = 1; p <= n; p++) {
            int curr = p;
            for (int[] ladder : ladders) {
                if (curr == ladder[1]) {
                    curr = ladder[2];
                } else if (curr == ladder[2]) {
                    curr = ladder[1];
                }
            }
            result[curr] = p;
        }
        return result;
    }

    static void playLadderGame(int[][] ladders) {
        for (int p = 1; p <= n; p++) {
            int curr = p;
            for (int[] ladder : ladders) {
                if (curr == ladder[1]) {
                    curr = ladder[2];
                } else if (curr == ladder[2]) {
                    curr = ladder[1];
                }
            }
            init[curr] = p;
        }
    }

    static boolean isSame(int[] target, int n) {
        for (int i = 1; i <= n; i++) {
            if (init[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}