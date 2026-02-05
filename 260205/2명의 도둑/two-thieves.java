import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int c;
    static int[][] weight;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer token = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());

        weight = new int[n][n];
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                weight[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int[][] maxValues = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxValues[i][j] = getMaxValue(i, j);
            }
        }

        int ans = 0;
        for (int x1 = 0; x1 < n; x1++) {
            for (int y1 = 0; y1 <= n - m; y1++) {
                for (int x2 = 0; x2 < n; x2++) {
                    for (int y2 = 0; y2 <= n - m; y2++) {
                        if (!isOverlapped(x1, y1, x2, y2)) {
                            ans = Integer.max(ans, maxValues[x1][y1] + maxValues[x2][y2]);
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static int getMaxValue(int x, int y) {
        int[] objects = new int[m];
        for (int i = 0; i < m; i++) {
            // 범위 밖 제외
            if (y + i >= n) {
                return 0;
            }
            objects[i] = weight[x][y+i];
        }

        int maxIncome = 0;
        for (int bitset = 0; bitset < Math.pow(2, m); bitset++) {
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < m; i++) {
                int mask = 0b1 << i;
                if ((bitset & mask) != 0) {
                    sum += objects[i];
                    list.add(objects[i]);
                }
            }
            if (sum > c) {
                continue;
            }
            int income = 0;
            for (int e : list) {
                income += e * e;
            }
            maxIncome = Integer.max(maxIncome, income);
        }
        return maxIncome;
    }

    static boolean isOverlapped(int x1, int y1, int x2, int y2) {
        if (x1 != x2) {
            return false;
        }
        int bit1 = 0;
        for (int x = x1; x < x1 + m; x++) {
            bit1 += (0b1 << x);
        }
        int bit2 = 0;
        for (int x = x2; x < x2 + m; x++) {
            bit2 += (0b1 << x);
        }
        return (bit1 & bit2) != 0;
    }
}
