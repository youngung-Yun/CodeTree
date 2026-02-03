import java.util.Scanner;
public class Main {

    static int[][] grid;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int[] bombCols = new int[m];
        for (int i = 0; i < m; i++)
            bombCols[i] = sc.nextInt() - 1;
        // Please write your code here.

        for (int col : bombCols) {
            int row = findBombRow(col);
            if (row == -1) {
                continue;
            }
            explode(row, col);
            activateGravity();
        }
        printMatrix();
    }

    static int findBombRow(int col) {
        for (int row = 0; row < n; row++) {
            if (grid[row][col] != 0) {
                return row;
            }
        }
        return -1;
    }

    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static void explode(int row, int col) {
        int range = grid[row][col];
        for (int[] dir : dirs) {
            int nx = row;
            int ny = col;
            for (int i = 0; i < range; i++) {
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    break;
                }
                grid[nx][ny] = 0;
                nx += dir[0];
                ny += dir[1];
            }
        }
    }

    static void activateGravity() {
        for (int c = 0; c < n; c++) {
            for (int r = n - 1; r >= 0; r--) {
                int now = grid[r][c];
                grid[r][c] = 0;

                int cr = r;
                int nr = cr + 1;
                while (nr < n && grid[nr][c] == 0) {
                    cr = nr;
                    nr += 1;
                }
                grid[cr][c] = now;
            }
        }
    }

    static void printMatrix() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : grid) {
            for (int col : row) {
                sb.append(col).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}