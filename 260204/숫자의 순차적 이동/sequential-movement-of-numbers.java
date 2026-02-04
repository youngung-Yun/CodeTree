import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] grid;
    static int n;
    static int[][] around = { {-1, -1}, {-1, 0}, {-1, 1}, {0, 1},
                                {1, 1}, {1, 0}, {1, -1}, {0, -1} };

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        grid = new int[n][n];
        for (int r = 0 ; r < n; r++) {
            token = new StringTokenizer(reader.readLine());
            for (int c = 0; c < n; c++) {
                grid[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            moveNumbers();
        }
        printGrid();
    }


    static void moveNumbers() {
        for (int i = 1; i <= n * n; i++) {
            int[] curr = findPosition(i);
            int max = 0;
            int x = curr[0];
            int y = curr[1];
            for (int[] delta : around) {
                int nx = curr[0] + delta[0];
                int ny = curr[1] + delta[1];
                if (!isValid(nx, ny)) {
                    continue;
                }
                if (max < grid[nx][ny]) {
                    max = grid[nx][ny];
                    x = nx;
                    y = ny;
                }
            }
            swap(curr[0], curr[1], x, y);
        }
    }

    static void swap(int x1, int y1, int x2, int y2) {
        int tmp = grid[x1][y1];
        grid[x1][y1] = grid[x2][y2];
        grid[x2][y2] = tmp;
    }

    static int[] findPosition(int number) {
        int[] result = new int[2];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == number) {
                    result = new int[] {r, c};
                    break;
                }
            }
        }
        return result;
    }

    static void printGrid() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : grid) {
            for (int col : row) {
                sb.append(col).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}