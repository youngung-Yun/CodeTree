import java.util.*;

public class Main {

    static int n;
    static int ans = 0;
    static List<int[]> bombs = new ArrayList<>();
    static int[][][] dirs = {{{0, 0}, {-1, 0}, {-2, 0}, {1, 0}, {2, 0}},
                             {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}},
                             {{0, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int e = sc.nextInt();
                if (e == 1) {
                    bombs.add(new int[] {i, j});
                }
            }
        }
        int c = bombs.size();

        dfs(new int[c], 0, c);

        System.out.println(ans);
    }

    static void dfs(int[] arr, int depth, int l) {
        if (depth == l) {
            ans = Integer.max(ans, getExplodedAreaCount(arr, l));
            return;
        }

        for (int i = 0; i <= 2; i++) {
            arr[depth] = i;
            dfs(arr, depth + 1, l);
        }
    }

    static int getExplodedAreaCount(int[] arr, int l) {
        boolean[][] exploded = new boolean[n][n];
        for (int i = 0; i < l; i++) {
            int[] bomb = bombs.get(i);
            int x = bomb[0];
            int y = bomb[1];
            for (int[] dir : dirs[arr[i]]) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (isValid(nx, ny)) {
                    exploded[nx][ny] = true;
                }
            }
        }

        int count = 0;
        for (boolean[] row : exploded) {
            for (boolean col : row) {
                count += col ? 1 : 0;
            }
        }
        return count;
    }

    static boolean isValid(int x, int y) { 
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}