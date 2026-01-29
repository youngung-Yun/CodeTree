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
        // Please write your code here.
        int max = 0;
        for (int r = 0; r <= n - 3; r++) {
            for (int c = 0; c <= n - 3; c++) {
                int sum = grid[r][c] + grid[r][c+1] + grid[r][c+2] + 
                          grid[r+1][c] + grid[r+1][c+1] + grid[r+1][c+2] + 
                          grid[r+2][c] + grid[r+2][c+1] + grid[r+2][c+2];
                max = Integer.max(max, sum);
            }
        }
        System.out.println(max);
    }
}