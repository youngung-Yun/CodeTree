import java.util.Scanner;

public class Main {

    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        // Please write your code here.

        explode(r - 1, c - 1, n);
        grid = activateGravity(n);
        printMatrix();
    }

    static void explode(int x, int y, int n) {
        final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = grid[x][y];
        grid[x][y] = 0;
        for (int[] dir : dirs) {
            int nx = x;
            int ny = y;
            for (int i = 0; i < d; i++) {
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    break;
                }
                grid[nx][ny] = 0;
                nx += dir[0];
                ny += dir[1];
            }
        }
    }

    static int[][] activateGravity(int n) {
        int[][] tmp = new int[n][n];
        for (int c = 0; c < n; c++) {
            int idx = n - 1;
            for (int r = n - 1; r >= 0; r--) {
                if (grid[r][c] != 0) {
                    tmp[idx--][c] = grid[r][c];
                }
            }
        }
        return tmp;
    }

    static void printMatrix() {
        for (int[] row : grid) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}