import java.util.Scanner;
public class Main {

    static int[][] grid;
    static int ans = 0;
    // R -> L -> U-> D
    static int[][] dirs = { {0, 1}, {0, -1}, {-1, 0}, {1, 0} };
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            pinball(i, n - 1, 0);
            pinball(i , 0, 1);
            pinball(n - 1, i, 2);
            pinball(0, i, 3);
        }

        System.out.println(ans);
    }

    private static void pinball(int startX, int startY, int dir) {
        int elapsed = 0;
        int x = startX;
        int y = startY;
        int nx = x;
        int ny = y;
        while (true) {
            ++elapsed;
            nx = x + dirs[dir][0];
            ny = y + dirs[dir][1];

            if (!isValid(nx, ny)) {
                ++elapsed;
                ans = Integer.max(ans, elapsed);
                return;
            }

            if (grid[nx][ny] == 1) {
                if (dir == 0) {
                    dir = 2;
                } else if (dir == 1) {
                    dir = 3;
                } else if (dir == 2) {
                    dir = 0;
                } else if (dir == 3) {
                    dir = 1;
                }
            } else if (grid[nx][ny] == 2) {
                if (dir == 0) {
                    dir = 3;
                } else if (dir == 1) {
                    dir = 2;
                } else if (dir == 2) {
                    dir = 1;
                } else if (dir == 3) {
                    dir = 0;
                }
            }
            x = nx;
            y = ny;
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}