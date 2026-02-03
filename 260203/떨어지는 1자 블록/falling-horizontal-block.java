import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt() - 1;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int height = 0;
        while (height < n) {
            boolean canDown = true;
            for (int c = k; c < k + m; c++) {
                if (grid[height][c] != 0) {
                    canDown = false;
                    break;
                }
            }
            if (!canDown) {
                break;
            }
            ++height;
        }

        for (int c = k; c < k + m; c++) {
            grid[height - 1][c] = 1;
        }

        for (int[] row : grid) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}