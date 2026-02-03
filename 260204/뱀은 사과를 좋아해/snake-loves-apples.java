import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static boolean[][] apples;
    static List<int[]> snake = new ArrayList<>();
    static Map<String, Integer> mapper;
    static int [][] dirs = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        apples = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            apples[x][y] = true;
        }

        mapper = new HashMap<>();
        mapper.put("U", 0);
        mapper.put("D", 1);
        mapper.put("R", 2);
        mapper.put("L", 3);

        int[][] moves = new int[k][2];
        for (int i = 0; i < k; i++) {
            token = new StringTokenizer(br.readLine());
            String dir = token.nextToken();
            int distance = Integer.parseInt(token.nextToken());
            moves[i] = new int[] { mapper.get(dir), distance };
        }

        snake.add(new int[] {1, 1});
        for (int[] move : moves) {
            int dir = move[0];
            int distance = move[1];
            if (!move(dir, distance)) {
                break;
            }
        }

        System.out.println(ans);
    }

    static boolean move(int dir, int distance) {
        while (distance-- > 0) {
            ++ans;

            int[] head = snake.get(0);

            int nx = head[0] + dirs[dir][0];
            int ny = head[1] + dirs[dir][1];

            // 격자 밖으로 이동했으면 종료
            if (!isValid(nx, ny)) {
                return false;
            }

            // 사과를 먹지 못했으면 꼬리 사라짐
            if (apples[nx][ny]) {
                apples[nx][ny] = false;
            } else {
                snake.remove(snake.size() - 1);
            }

            // 꼬였으면 종료
            if (isTwisted(nx, ny)) {
                return false;
            }

            // 새로운 머리 추가
            int[] newHead = {nx, ny};
            snake.add(0, newHead);
        }
        return true;
    }

    static boolean isTwisted(int x, int y) {
        for (int[] body : snake) {
            if (body[0] == x && body[1] == y) {
                return true;
            }
        }
        return false;
    }

    static boolean isValid(int x, int y) {
        return x > 0 && y > 0 && x <= n && y <= n;
    }
}