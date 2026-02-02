import java.util.Scanner;
public class Main {

    // 반시계 방향: 0 -> 1 -> 2 -> 3
    // 시게 방향:  3 -> 2 -> 1 -> 0
    static int[][] dirs = {{-1, 1}, {-1, -1}, {1, -1}, {1, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();
        int m4 = sc.nextInt();
        int dir = sc.nextInt();

        int[] distance = {m1, m2, m3, m4};

        int x = r - 1;
        int y = c - 1;
        int now = grid[x][y];
        for (int i = 0; i < 4; i++) {
            int idx = dir == 0 ? i : 3 - i;
            int[] d = dirs[idx];
            for (int j = 0; j < distance[idx]; j++) {
                int nx = x + (dir == 0 ? d[0] : -d[0]);
                int ny = y + (dir == 0 ? d[1] : -d[1]);
                int tmp = grid[nx][ny];
                grid[nx][ny] = now;
                now = tmp;
                x = nx;
                y = ny;
            }
        }

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