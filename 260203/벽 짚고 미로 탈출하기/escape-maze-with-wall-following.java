import java.util.Scanner;
public class Main {

    static int n;
    static char[][] maze;
    // 반시계방향: 우 - 상 - 좌 - 하
    static final int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    static boolean[][][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        maze = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                maze[i][j] = line.charAt(j);
            }
        }

        visited = new boolean[n][n][4];
        /*
        * 1. 바라보는 방향이 막혀있음 -> 반시계 방향으로 회전
        * 2. 이동했는데 격자 밖 -> 탈출
        * 3. 이동했는데 오른쪽에 벽이 있음 -> 종료
        * 4. 이동했는데 오른쪽에 벽이 없음 -> 한 칸 이동 후 시계 방향 으로 회전 -> 한 칸 이동
        */

        int d = 0;
        int answer = 0;
        int cx = x;
        int cy = y;
        visited[cx][cy][d] = true;
        while (isValid(cx, cy)) {
            int nx = cx + dirs[d][0];
            int ny = cy + dirs[d][1];
            
            // 막혀있으면 회전. 4번 회전했으면 탈출못함
            boolean canEscape = true;
            int rotateCount = 0;
            while (isValid(nx, ny) && maze[nx][ny] == '#') {
                d = (d + 1) % 4;
                nx = cx + dirs[d][0];
                ny = cy + dirs[d][1];
                ++rotateCount;
                if (rotateCount >= 4) {
                    canEscape = false;
                    break;
                }
            }
            if (!canEscape) {
                answer = -1;
                break;
            }

            // 앞으로 이동
            ++answer;
            cx = nx;
            cy = ny;
            if (!isValid(cx, cy)) {
                continue;
            }
            if (visited[cx][cy][d]) {
                answer = -1;
                break;
            }

            visited[cx][cy][d] = true;
            // 오른쪽에 벽 없음
            if (isValid(cx, cy) && !isBesideWall(cx, cy, d)) {
                // 시계 방향 회전
                d = (d + 3) % 4;
                nx = cx + dirs[d][0];
                ny = cy + dirs[d][1];

                if (visited[nx][ny][d]) {
                    answer = -1;
                break;
                }
                // 이동
                ++answer;
                cx = nx;
                cy = ny;
                if (visited[cx][cy][d]) {
                    answer = -1;
                    break;
                }
                visited[cx][cy][d] = true;
            }
        }

        System.out.println(answer);
    }

    static boolean isBesideWall(int x, int y, int dir) {
        int beside = (dir + 3) % 4;
        int nx = x + dirs[beside][0];
        int ny = y + dirs[beside][1];

        return isValid(nx, ny) && maze[nx][ny] == '#';
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}