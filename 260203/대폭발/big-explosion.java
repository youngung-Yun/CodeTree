import java.util.*;

public class Main {

    static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        grid = new int[n][n];
        int m = sc.nextInt();

        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;

        List<int[]> bombList = new ArrayList<>();
        
        grid[r][c] = 1;
        bombList.add(new int[] {r, c});
        for (int i = 0; i < m; i++) {
            int range = (int) Math.pow(2, i);
            List<int[]> addBombList = new ArrayList<>();
            for (int[] bomb : bombList) {
                for (int[] dir : dirs) {
                    int nx = bomb[0] + (dir[0] * range);
                    int ny = bomb[1] + (dir[1] * range);
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                        continue;
                    }
                    if (grid[nx][ny] == 1) {
                        continue;
                    }
                    grid[nx][ny] = 1;
                    addBombList.add(new int[] {nx, ny});
                }
            }
            for (int[] bomb : addBombList) {
                bombList.add(bomb);
            }
        }
        int ans = 0;
        for (int[] row : grid) {
            for (int col : row) {
                ans += col == 1 ? 1 : 0;
            }
        }
        System.out.println(ans);
    }
}