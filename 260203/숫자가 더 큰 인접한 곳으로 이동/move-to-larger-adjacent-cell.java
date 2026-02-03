import java.util.Scanner;
public class Main {

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0o}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] grid = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(grid[r][c]).append(' ');
            int nr = r;
            int nc = c;
            for (int[] dir : dirs) {
                int dr = r + dir[0];
                int dc = c + dir[1];
                if (dr <= 0 || dc <= 0 || dr > n || dc > n) {
                    continue;
                }
                if (grid[r][c] < grid[dr][dc]) {
                    nr = dr;
                    nc = dc;
                }
            }
            if (nr == r && nc == c) {
                break;
            }
            r = nr;
            c = nc;
        }
        System.out.println(sb);
    }
}