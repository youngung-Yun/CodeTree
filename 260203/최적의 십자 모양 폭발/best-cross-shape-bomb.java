import java.util.Scanner;

public class Main {

    static int[][] grid;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        // Please write your code here.

        int ans = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                ans = Integer.max(ans, findCount(r, c));
            }
        }
        System.out.println(ans);
    }

    
    static int findCount(int x, int y) {
        int k = grid[x][y];
        int[][] copy = copy(grid);
        explode(copy, x, y, k);
        activateGravity(copy);

        int count = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int curr = copy[r][c];
                if (curr == 0) {
                    continue;
                }
                if (r + 1 < n && curr == copy[r+1][c]) {
                    ++count;
                }
                if (c + 1 < n && curr == copy[r][c+1]) {
                    ++count;
                }
            }
        }
        return count;
    }

    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    static void explode(int[][] matrix, int x, int y, int k) {
        for (int[] dir : dirs) {
            int nx = x;
            int ny = y;
            for (int i = 0; i < k; i++) {
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    break;
                }
                matrix[nx][ny] = 0;
                nx += dir[0];
                ny += dir[1];
            }
        }
    }
    
    static void activateGravity(int[][] matrix) {
        for (int c = 0; c < n; c++) {
            int height = n - 1;
            for (int r = n - 1; r >= 0; r--) {
                int curr = matrix[r][c];
                if (curr != 0) {
                    matrix[r][c] = 0;
                    matrix[height][c] = curr;
                    --height;
                }
            }
        }
    }

    static int[][] copy(int[][] matrix) {
        int[][] tmp = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                tmp[r][c] = grid[r][c];
            }
        }
        return tmp;
    }

    static void print(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int col : row) {
                sb.append(col).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}