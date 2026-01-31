import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        final int[][] offsets = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        int answer = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                boolean[][] visited = new boolean[n][n];
                int goldCount = 0;
                int income = 0;
                for (int k = 0; k < n * 2; k++) {
                    // (k - 1) 일때 계산을 계속 이용함
                    for (int dx = 0; dx <= k; dx++) {
                        int dy = k - dx;
                        for (int[] offset : offsets) {
                            int nx = r + (dx * offset[0]);
                            int ny = c + (dy * offset[1]);
                            income -= 1;
                            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                                continue;
                            }
                            // 들른 곳이면 비용 반환
                            if (visited[nx][ny]) {
                                income += 1;
                                continue;
                            }
                            visited[nx][ny] = true;
                            if (grid[nx][ny] == 1) {
                                income += m;
                                ++goldCount;
                            }
                        }
                    }
                    if (income > 0) {
                        answer = Integer.max(answer, goldCount);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}