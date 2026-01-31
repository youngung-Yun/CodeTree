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
                // 직사각형의 가로, 세로 길이별 완전탐색
                for (int w = 1; w < n; w++) {
                    for (int h = 1; h < n; h++) {
                        int sum = getSum(grid, r, c, w, h, n);
                        answer = Integer.max(answer, sum);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static int getSum(int[][] grid, int x, int y, int w, int h, int n) {
        final int[][] dirs = {{-1, 1}, {-1, -1}, {1, -1}, {1, 1}};
        int sum = 0;
        int cx = x;
        int cy = y;
        for (int i = 0; i < 4; i++) {
            int[] dir = dirs[i];
            int count = i % 2 == 0 ? w : h;
            for (int j = 0; j < count; j++) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                // 범위 벗어나는 경우엔 직사각형 만들 수 없음
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    return 0;
                }
                sum += grid[nx][ny];
                cx = nx;
                cy = ny;
            }
        }
        return sum;
    }
}