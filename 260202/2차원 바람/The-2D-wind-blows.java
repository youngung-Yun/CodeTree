import java.util.Scanner;
public class Main {

    static int[][] building;
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] around = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        building = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                building[i][j] = sc.nextInt();
        int[][] queries = new int[q][4];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 4; j++) {
                queries[i][j] = sc.nextInt();
            }
        }

        // 1. 직사각형 회전
        // 2. 평균 구하기
        for (int[] query : queries) {
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;
            rotate(x1, y1, x2, y2);
            findAverage(x1, y1, x2, y2, n, m);
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : building) {
            for (int col : row) {
                sb.append(col).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void rotate(int x1, int y1, int x2, int y2) {
        int cx = x1;
        int cy = y1;
        int now = building[cx][cy];
        for (int[] dir : dirs) {
            while (true) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                if (nx < x1 || ny < y1 || nx > x2 || ny > y2) {
                    break;
                }
                int tmp = building[nx][ny];
                building[nx][ny] = now;
                now = tmp;
                cx = nx;
                cy = ny;
            }

        }
    }

    static void findAverage(int x1, int y1, int x2, int y2, int n, int m) {
        int[][] average = new int[n][m];
        // 평균 계산
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                int sum = building[x][y];
                int count = 1;
                for (int[] delta : around) {
                    int nx = x + delta[0];
                    int ny = y + delta[1];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        continue;
                    }
                    sum += building[nx][ny];
                    ++count;
                }
                average[x][y] = (sum / count);
            }
        }
        // 평균 적용
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                building[x][y] = average[x][y];
            }
        }
    }
}