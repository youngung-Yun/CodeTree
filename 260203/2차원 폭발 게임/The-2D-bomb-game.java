import java.util.Scanner;

public class Main {

    static int[][] grid;
    static int n;
    static int m;

    static boolean hasExplode;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        /*
         * 1. k번동안 터짐 -> 중력 -> 회전 -> 중력
           2. k번 이후는 터질 폭탄이 없을 때까지 계속 터뜨림
        */
        for (int c = 0; c < k; c++) {
            explode();
            activateGravity();
            rotate();
            activateGravity();
        }

        hasExplode = true;
        while (hasExplode) {
            explode();
            activateGravity();
        }

        int ans = getRemainBombs();
        System.out.println(ans);
    }

    private static void explode() {
        hasExplode = false;
        for (int c = 0; c < n; c++) {
            int curr = grid[0][c];
            int start = 0;
            int count = 0;
            for (int r = 0; r < n; r++) {
                if (grid[r][c] == 0) {
                    curr = -1;
                    count = 0;
                }

                if (curr == grid[r][c]) {
                    ++count;
                } else {
                    if (count >= m) {
                        hasExplode = true;
                        for (int i = start; i < r; i++) {
                            grid[i][c] = 0;
                        }
                    }
                    curr = grid[r][c];
                    start = r;
                    count = 1;
                }
            }
            if (count >= m) {
                hasExplode = true;
                for (int i = start; i < n; i++) {
                    grid[i][c] = 0;
                }
            }
        }
    }

    private static void activateGravity() {
        for (int c = 0; c < n; c++) {
            int height = n - 1;
            for (int r = n - 1; r >= 0; r--) {
                int now = grid[r][c];
                if (now != 0) {
                    grid[r][c] = 0;
                    grid[height][c] = now;
                    --height;
                }
            }
        }
    }

    private static void rotate() {
        int[][] rotated = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                rotated[c][n-r-1] = grid[r][c];
            }
        }
        grid = rotated;
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : grid) {
            for (int col : row) {
                sb.append(col).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int getRemainBombs() {
        int count = 0;
        for (int[] row : grid) {
            for (int col : row) {
                count += col != 0 ? 1 : 0;
            }
        }
        return count;
    }
}