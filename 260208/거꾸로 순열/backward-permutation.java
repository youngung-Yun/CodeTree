import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        dfs(new ArrayList<>(), new boolean[n+1], 0);
        System.out.println(sb);
    }

    static void dfs(List<Integer> list, boolean[] visited, int depth) {
        if (depth == n) {
            for (int e : list) {
                sb.append(e).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = n; i >= 1; i--) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            list.add(i);
            dfs(list, visited, depth + 1);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}