import java.util.Scanner;
public class Main {

    static int n, m;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        int ans = findMaxSize();
        System.out.println(ans);
    }

    static int findMaxSize() {
        int max = 0;
        for (int x1 = 0; x1 < n; x1++) {
            for (int y1 = 0; y1 < m; y1++) {
                for (int x2 = x1; x2 < n; x2++) {
                    for (int y2 = y1; y2 < m; y2++) {
                        if (!hasNegative(x1, y1, x2, y2)) {
                            max = Integer.max(max, (x2 - x1 + 1) * (y2 - y1 + 1));
                        }
                    }
                }
            }
        }
        return max;
    }

    /**
     * (x1, y1) 에서 (x2, y2)까지의 직사각형이 음수를 포함하는지 확인
    */
    static boolean hasNegative(int x1, int y1, int x2, int y2) {
        for (int r = x1; r <= x2; r++) {
            for (int c = y1; c <= y2; c++) {
                if (grid[r][c] < 0) {
                    return true;
                }
            }
        }
        return false;
    }
}