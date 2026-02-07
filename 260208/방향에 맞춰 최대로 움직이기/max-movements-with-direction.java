import java.io.*;
import java.util.*;

public class Main {

    final static int [][] dirs = { {}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1} };
    static int n;
    static int ans = 0;
    static int[][] grid;
    static int[][] dirGrid;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        grid = new int[n+1][n+1];
        for (int r = 1; r <= n; r++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            for (int c = 1; c <= n; c++) {
                int num = Integer.parseInt(token.nextToken());
                grid[r][c] = num;
            }
        }

        dirGrid = new int[n+1][n+1];
        for (int r = 1; r <= n; r++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            for (int c = 1; c <= n; c++) {
                int d = Integer.parseInt(token.nextToken());
                dirGrid[r][c] = d;
            }
        }

        StringTokenizer token = new StringTokenizer(bf.readLine());
        int x = Integer.parseInt(token.nextToken());
        int y = Integer.parseInt(token.nextToken());

        dfs(x, y, 0);
        System.out.println(ans);
    }

    static void dfs(int x, int y, int depth) {
        ans = Integer.max(ans, depth);

        int[] dir = dirs[dirGrid[x][y]];
        int nx = x + dir[0];
        int ny = y + dir[1];
        while (nx > 0 && ny > 0 && nx <= n && ny <= n) {
            if (grid[nx][ny] > grid[x][y]) {
                dfs(nx, ny, depth + 1);
            }
            nx += dir[0];
            ny += dir[1];
        }
    }
}