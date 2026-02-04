import java.util.Scanner;
public class Main {

    static int[][] dirs = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int[][] marbles = new int[n][n];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            marbles[x][y] = 1;
        }
        for (int i = 0; i < t; i++) {
            moveMarbles(grid, marbles, n);
        }
        System.out.println(getCount(marbles));
    }

    static void moveMarbles(int[][] grid, int[][] marbles, int n) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (marbles[r][c] != 1) {
                    continue;
                }
                marbles[r][c] = 0;
                int max = 0;
                int x = r;
                int y = c;
                for (int[] dir : dirs) {
                    int nx = r + dir[0];
                    int ny = c + dir[1];
                    if (!isValid(nx, ny, n)) {
                        continue;
                    }
                    if (grid[nx][ny] > max) {
                        max = grid[nx][ny];
                        x = nx;
                        y = ny;
                    }
                }
                marbles[x][y] = 1;
            }
        }
    }

    static int getCount(int[][] matrix) {
        int total = 0;
        for (int[] row : matrix) {
            for (int col : row) {
                total += col;
            }
        }
        return total;
    }

    static boolean isValid(int x, int y, int n) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}