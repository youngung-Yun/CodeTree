import java.util.*;

public class Main {

    static int[][] grid;
    static int n, m;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                grid[r][c] = sc.nextInt();
            }
        }

        int ans = findMaxSum();
        System.out.println(ans);
    }

    static int findMaxSum() {
        int max = -1000 * 5 * 5 + 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = i; k < n; k++) {
                    for (int l = j; l < m; l++) {
                        max = Integer.max(max, findMaxSum(i, j, k, l));
                    }
                }
            }
        }
        return max;
    }

    static int findMaxSum(int x1, int y1, int x2, int y2) {
        int max = -1000 * 5 * 5 + 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = i; k < n; k++) {
                    for (int l = j; l < m; l++) {
                        if (!overlapped(x1, y1, x2, y2, i, j, k, l)) {
                            max = Integer.max(max,
                                    rectSum(x1, y1, x2, y2) + rectSum(i, j, k, l));
                        }
                    }
                }
            }
        }
        return max;
    }

    static boolean overlapped(int x1, int y1, int x2, int y2, int i, int j, int k, int l) {
        int[][] visit = new int[n][m];
        draw(visit, x1, y1, x2, y2);
        draw(visit, i, j, k, l);
        return checkDuplicate(visit);
    }

    static void draw(int[][] visit, int x1, int y1, int x2, int y2) {
        for (int r = x1; r <= x2; r++) {
            for (int c = y1; c <= y2; c++) {
                visit[r][c]++;
            }
        }
    }

    static boolean checkDuplicate(int[][] visit) {
        for (int[] row : visit) {
            for (int col : row) {
                if (col >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    static int rectSum(int x1, int y1, int x2, int y2) {
        int sum = 0;
        for (int r = x1; r <= x2; r++) {
            for (int c = y1; c <= y2; c++) {
                sum += grid[r][c];
            }
        }
        return sum;
    }
}