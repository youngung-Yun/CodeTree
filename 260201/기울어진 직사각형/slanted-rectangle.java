import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int answer = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (r - 2 < 0 || c - 1 < 0 || c + 1 >= n) {
                    continue;
                }

                for (int k = 1; k < n; k++) {
                    int sum = getSum(grid, r, c, k, n);
                    answer = Integer.max(answer, sum);
                }
            }
        }
        System.out.println(answer);
    }

    private static int getSum(int[][] grid, int x, int y, int k, int n) {
        final int[][] dirs = {{-1, 1}, {-1, -1}, {1, -1}, {1, 1}};
        int sum = 0;
        int cx = x;
        int cy = y;
        for (int[] dir : dirs) {
            for (int i = 0; i < k; i++) {
                if (cx == n - 1 && cy == n - 1) {
                    return 0;
                }
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    break;
                }
                sum += grid[nx][ny];

                if (nx == x && ny == y) {
                    break;
                }
                cx = nx;
                cy = ny;
            }
        }
        return sum;
    }
}