import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int answer = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                for (int k = 1; k < n; k++) {
                    int sum = getSum(grid, r, c, k, n);
                    answer = Integer.max(answer, sum);
                }
            }
        }
        System.out.println(answer);
    }

    private static int getSum(int[][] grid, int x, int y, int k, int n) {
        final int[][] dirs = {{-1, 1}, {-1, -1}, {1, -1}, {1, 1}};
        boolean[] move = new boolean[4];
        int sum = 0;
        int cx = x;
        int cy = y;
        for (int i = 0; i < 4; i++) {
            int[] dir = dirs[i];
            for (int j = 0; j < k; j++) {
                if (cx == 0 && cy == n - 1) {
                    return 0;
                }
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    break;
                }
                sum += grid[nx][ny];
                move[i] = true;
                if (nx == x && ny == y) {
                    break;
                }
                cx = nx;
                cy = ny;
            }
        }
        // 안 움직인 방향이 있으면 직사각형 불가능
        if (move[0] && move[1] && move[2] && move[3]) {
            return sum;
        }
        return 0;
    }
}