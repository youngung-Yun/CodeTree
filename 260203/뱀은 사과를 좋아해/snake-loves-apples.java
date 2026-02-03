import java.util.*;
public class Main { 

    // [x, y, dir]
    static List<int[]> snake = new ArrayList<>();
    final static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int[][] apples;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        apples = new int[m][2];
        int k = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            apples[i] = new int[] {x, y};
        }
        char[][] moves = new char[k][2];
        for (int i = 0; i < k; i++) {
            char d = sc.next().charAt(0);
            char p = sc.next().charAt(0);
            moves[i] = new char[] {d, p};
        }

        boolean gameover = false;
        snake.add(new int[] {0, 0, 0});
        int[] head = snake.get(0);
        int ans = 0;
        for (int i = 0; i < k; i++) {
            char d = moves[i][0];
            int p = Character.getNumericValue(moves[i][1]);

            if (gameover) {
                break;
            }
            int dir = 0;
            if (d == 'U') {
                dir = 0;
            } else if (d == 'D') {
                dir = 1;
            } else if (d == 'R') {
                dir = 2;
            } else if (d == 'L') {
                dir = 3;
            }
            head[2] = dir;

            for (int j = 0; j < p; j++) {
                if (gameover) {
                break;
                }
                ++ans;

                int nx = head[0] + dirs[head[2]][0];
                int ny = head[1] + dirs[head[2]][1];
                // 격자를 벗어남
                if (!isValid(nx, ny, n)) {
                    gameover = true;
                    continue;
                }

                int[] tmp = snake.get(snake.size() - 1);
                int[] tail = new int[3];
                tail[0] = tmp[0];
                tail[1] = tmp[1];
                tail[2] = tmp[2];

                moveBody();
                head[0] = nx;
                head[1] = ny;

                if (canEatApple(head[0], head[1])) {
                    int[] newTail = createNewTail(tail);
                    snake.add(newTail);
                }
                if (collideWithBody(head[0], head[1])) {
                    gameover = true;
                    continue;
                }
            }
        }
        System.out.println(ans);
    }

    static boolean isValid(int x, int y, int n) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    static void moveBody() {
        for (int l = snake.size() - 1; l >= 1; l--) {
            int[] curr = snake.get(l);
            int[] prev = snake.get(l-1);
            curr[0] = prev[0];
            curr[1] = prev[1];
            curr[2] = prev[2];
        }
    }

    static boolean canEatApple(int x, int y) {
        for (int i = 0; i < apples.length; i++) {
            if (apples[i][0] == x && apples[i][1] == y) {
                return true;
            }
        }
        return false;
    }

    static int[] createNewTail(int[] tail) {
        int[] newTail = new int[3];
        newTail[0] = tail[0];
        newTail[1] = tail[1];
        newTail[2] = tail[2];
        return newTail;
    }

    static boolean collideWithBody(int x, int y) {
        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(i)[0] == x && snake.get(i)[1] == y) {
                return true;
            }
        }
        return false;
    }
}