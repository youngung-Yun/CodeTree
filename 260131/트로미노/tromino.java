import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int answer = 0;
        final int[][][] trominos = {{{0, 0}, {0, 1}, {0, 2}},
                                     {{0, 0}, {1, 0}, {2, 0}},
                                     {{0, 0}, {1, 0}, {1, 1}},
                                     {{0, 0}, {1, 0}, {1, -1}},
                                     {{0, 0}, {0, 1}, {1, 0}},
                                     {{0, 0}, {0, -1}, {1, 0}}
                                     };
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                for (int[][] tromino : trominos) {
                    int sum = 0;
                    boolean isValid = true;
                    for (int[] dir : tromino) {
                        int nx = row + dir[0];
                        int ny = col + dir[1];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                            isValid = false;
                            break;
                        }
                        sum += grid[nx][ny];
                    }
                    if (isValid) {
                        answer = Integer.max(answer, sum);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}