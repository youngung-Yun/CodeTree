import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[][] around = { {0, 1}, {1, 0}, {0, -1}, {-1, 0},
                            {1, 1}, {-1, -1}, {-1, 1}, {1, -1} };
    static List<List<List<Integer>>> grid = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int[][] pos = new int[n*n+1][2];
        for (int i = 0; i <= n; i++) {
            grid.add(new ArrayList<>());
            for (int k = 0; k <= n; k++) {
                grid.get(i).add(new ArrayList<>());
            }
        }
        for (int r = 1; r <= n; r++) {
            token = new StringTokenizer(bf.readLine());
            for (int c = 1; c <= n; c++) {
                int number = Integer.parseInt(token.nextToken());
                pos[number] = new int[] {r, c};
                grid.get(r).get(c).add(number);
            }
        }
        token = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(token.nextToken());
            int[] curr = pos[number];
            int max = 0;
            int x = curr[0];
            int y = curr[1];
            // 근처의 가장 큰 수 찾음
            for (int[] dir : around) {
                int nx = curr[0] + dir[0];
                int ny = curr[1] + dir[1];
                if (!isValid(nx, ny, n)) {
                    continue;
                }
                if (grid.get(nx).get(ny).isEmpty()) {
                    continue;
                }
                List<Integer> list = grid.get(nx).get(ny);
                for (int e : list) {
                    if (max < e) {
                        max = e;
                        x = nx;
                        y = ny;
                    }
                }
            }
            // 위치 옮길 때 사용할 스택
            Deque<Integer> tmp = new ArrayDeque<>();
            List<Integer> list = grid.get(curr[0]).get(curr[1]);
            while (!list.isEmpty()) {
                int e = list.remove(list.size() - 1);
                tmp.push(e);
                if (tmp.peek() == number) {
                    break;
                }
            }
            while (!tmp.isEmpty()) {
                int e = tmp.pop();
                grid.get(x).get(y).add(e);
                pos[e] = new int[] {x, y};
            }
        }
        print(n);
        System.out.println(sb);
    }

    static boolean isValid(int x, int y, int n) {
        return x > 0 && y > 0 && x <= n && y <= n;
    }

    static void print(int n) {
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                List<Integer> curr = grid.get(r).get(c);
                if (curr.isEmpty()) {
                    sb.append("None").append('\n');
                } else {
                    for (int i = curr.size() - 1; i >= 0; i--) {
                        sb.append(curr.get(i)).append(' ');
                    }
                    sb.append('\n');
                }
            }
        }
        sb.append('\n');

    }
}