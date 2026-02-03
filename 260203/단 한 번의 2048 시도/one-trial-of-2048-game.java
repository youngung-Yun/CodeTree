import java.util.Scanner;

public class Main {

    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        grid = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        char dir = sc.next().charAt(0);

        move(dir);
        merge(dir);
        move(dir);
        printMatrix();
    }

    static void move(char dir) {
        switch (dir) {
            case 'L':
                moveLeft();
                break;
            case 'R':
                moveRight();
                break;
            case 'U':
                moveUp();
                break;
            case 'D':
                moveDown();
                break;
        }
    }

    static void moveLeft() {
        int deltaY = -1;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (grid[x][y] == 0) {
                    continue;
                }
                int now = grid[x][y];
                int cy = y;
                int ny = cy + deltaY;
                while (ny >= 0 && grid[x][ny] == 0) {
                    grid[x][cy] = 0;
                    grid[x][ny] = now;
                    cy = ny;
                    ny += deltaY;
                }
            }
        }
    }

    static void moveRight() {
        int deltaY = 1;
        for (int x = 0; x < 4; x++) {
            for (int y = 3; y >= 0; y--) {
                if (grid[x][y] == 0) {
                    continue;
                }
                int now = grid[x][y];
                int cy = y;
                int ny = cy + deltaY;
                while (ny < 4 && grid[x][ny] == 0) {
                    grid[x][cy] = 0;
                    grid[x][ny] = now;
                    cy = ny;
                    ny += deltaY;
                }
            }
        }
    }

    static void moveUp() {
        int deltaX = -1;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (grid[x][y] == 0) {
                    continue;
                }
                int now = grid[x][y];
                int cx = x;
                int nx = cx + deltaX;
                while (nx >= 0 && grid[nx][y] == 0) {
                    grid[cx][y] = 0;
                    grid[nx][y] = now;
                    cx = nx;
                    nx += deltaX;
                }
            }
        }
    }
    
    static void moveDown() {
        int deltaX = 1;
        for (int x = 3; x >= 0; x--) {
            for (int y = 0; y < 4; y++) {
                if (grid[x][y] == 0) {
                    continue;
                }
                int now = grid[x][y];
                int cx = x;
                int nx = cx + deltaX;
                while (nx < 4 && grid[nx][y] == 0) {
                    grid[cx][y] = 0;
                    grid[nx][y] = now;
                    cx = nx;
                    nx += deltaX;
                }
            }
        }
    }

    static void merge(char dir) {
        switch (dir) {
            case 'L':
                mergeLeft();
                break;
            case 'R':
                mergeRight();
                break;
            case 'U':
                mergeUp();
                break;
            case 'D':
                mergeDown();
                break;
        }
    }

    static void mergeLeft() {
        int deltaY = -1;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (grid[x][y] == 0) {
                    continue;
                }
                int ny = y + deltaY;
                if (ny < 0) {
                    continue;
                }
                if (grid[x][y] == grid[x][ny]) {
                    grid[x][ny] *= 2;
                    grid[x][y] = 0;
                }
            }
        }
    }

    static void mergeRight() {
        int deltaY = 1;
        for (int x = 0; x < 4; x++) {
            for (int y = 3; y >= 0; y--) {
                if (grid[x][y] == 0) {
                    continue;
                }
                int ny = y + deltaY;
                if (ny >= 4) {
                    continue;
                }
                if (grid[x][y] == grid[x][ny]) {
                    grid[x][ny] *= 2;
                    grid[x][y] = 0;
                }
            }
        }
    }
    
    static void mergeUp() {
       int deltaX = -1;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (grid[x][y] == 0) {
                    continue;
                }
                int nx = x + deltaX;
                if (nx < 0) {
                    continue;
                }
                if (grid[x][y] == grid[nx][y]) {
                    grid[nx][y] *= 2;
                    grid[x][y] = 0;
                }
            }
        }
    }

    static void mergeDown() {
        int deltaX = 1;
        for (int x = 3; x >= 0; x--) {
            for (int y = 0; y < 4; y++) {
                if (grid[x][y] == 0) {
                    continue;
                }
                int nx = x + deltaX;
                if (nx >= 4) {
                    continue;
                }
                if (grid[x][y] == grid[nx][y]) {
                    grid[nx][y] *= 2;
                    grid[x][y] = 0;
                }
            }
        }
    }

    static void printMatrix() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : grid) {
            for (int element : row) {
                sb.append(element).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}