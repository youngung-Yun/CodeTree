import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] dirs = { {0, -1}, {1, 0}, {0, 1}, {-1, 0} };
    static int[][] grid;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());

            grid = new int[n+1][n+1];

            for (int k = 0; k < m; k++) {
                token = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(token.nextToken());
                int y = Integer.parseInt(token.nextToken());
                // L = 1, D = 2, R = 3, U = 4
                int dir = mapDirection(token.nextToken());
                grid[x][y] = dir;
            }

            for (int k = 0; k < 10_000; k++) {
                moveMarbles();
            }
            int ans = getCountMarbles();
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static void moveMarbles() {
        int[][] newMarbles = new int[n+1][n+1];
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                if (grid[r][c] == 0) {
                    continue;
                }
                int[] dir = dirs[grid[r][c] - 1];
                int nx = r + dir[0];
                int ny = c + dir[1];
                // 이동
                if (isValid(nx, ny)) {
                    if (newMarbles[nx][ny] != 0) {
                        newMarbles[nx][ny] = -1;
                    } else {
                        newMarbles[nx][ny] = grid[r][c];
                    }
                } else {
                    // 방향만 변경
                    newMarbles[r][c] = changeDirection(grid[r][c]);
                }
            }
        }
        // 겹쳐진 구슬 제거
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                if (newMarbles[r][c] == -1) {
                    newMarbles[r][c] = 0;
                }
            }
        }
        grid = newMarbles;
    }

    static boolean isValid(int x, int y) {
        return x > 0 && y > 0 && x <= n && y <= n;
    }

    static int getCountMarbles() {

        int total = 0;
        for (int[] row : grid) {
            for (int col : row) {
                if (col > 0) {
                    ++total;
                }
            }
        }
        return total;
    }

    static int mapDirection(String dir) {
        if (dir.equals("L")) {
            return 1;
        } else if (dir.equals("R")) {
            return 3;
        } else if (dir.equals("D")) {
            return 2;
        } else {
            return 4;
        }
    }

    static void print() {
        for (int[] row : grid) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int changeDirection(int dir) {
        return (((dir - 1) + 2) % 4) + 1;
    }
}