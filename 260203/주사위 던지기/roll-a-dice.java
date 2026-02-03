import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        String[] directions = new String[m];
        for (int i = 0; i < m; i++) {
            directions[i] = sc.next();
        }

        int[][] grid = new int[n][n];
        grid[r][c] = 6;

        int left = 4;
        int right = 3;
        int down = 2;
        int up = 5;
        int under = 6;
        int above = 1;
        for (String d : directions) {
            int newLeft = 0;
            int newRight = 0;
            int newDown = 0;
            int newUp = 0;
            int newUnder = 0;
            int newAbove = 0;

            int nx = 0;
            int ny = 0;

            if (d.equals("L")) {
                nx = r;
                ny = c - 1;
                if (!isValid(nx, ny, n)) {
                    continue;
                }
                newLeft = above;
                newRight = under;
                newDown = down;
                newUp = up;
                newUnder = left;
                newAbove = right;

            } else if (d.equals("R")) {
                nx = r;
                ny = c + 1;
                if (!isValid(nx, ny, n)) {
                    continue;
                }
                newLeft = under;
                newRight = above;
                newDown = down;
                newUp = up;
                newUnder = right;
                newAbove = left;
            } else if (d.equals("U")) {
                nx = r - 1;
                ny = c;
                if (!isValid(nx, ny, n)) {
                    continue;
                }
                newLeft = left;
                newRight = right;
                newDown = under;
                newUp = above;
                newUnder = up;
                newAbove = down;
            } else if (d.equals("D")) {
                nx = r + 1;
                ny = c;
                if (!isValid(nx, ny, n)) {
                    continue;
                }
                newLeft = left;
                newRight = right;
                newDown = above;
                newUp = under;
                newUnder = down;
                newAbove = up;
            }

            left = newLeft;
            right = newRight;
            down = newDown;
            up = newUp;
            under = newUnder;
            above = newAbove;

            grid[nx][ny] = under;
            r = nx;
            c = ny;
        }

        int ans = 0;
        for (int[] row : grid) {
            for (int col : row) {
                ans += col;
            }
        }
        System.out.println(ans);
    }

    static boolean isValid(int x, int y, int n) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}