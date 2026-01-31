import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int row = 0;
            int col = 0;
            int rowCount = 0;
            int colCount = 0;
            boolean rowSequence = false;
            boolean colSequence = false;
            for (int k = 0; k < n; k++) {
                if (grid[i][k] == row) {
                    ++rowCount;
                } else {
                    row = grid[i][k];
                    rowCount = 1;
                }
                if (grid[k][i] == col) {
                    ++colCount;
                } else {
                    col = grid[k][i];
                    colCount = 1;
                }
                if (rowCount >= m) {
                    rowSequence = true;
                }
                if (colCount >= m) {
                    colSequence = true;
                }
            }
            if (rowSequence) {
                ++answer;
            }
            if (colSequence) {
                ++answer;
            }
        }
        System.out.println(answer);
    }
} 