import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n*3+1];
        queue.offer(new int[] {n, 0});
        visited[n] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int number = curr[0];
            int count = curr[1];
            if (number == 1) {
                System.out.println(count);
                break;
            }
            if (!visited[number-1]) {
                visited[number-1] = true;
                queue.offer(new int[] {number - 1, count + 1});
            }
            if (!visited[number+1]) {
                visited[number+1] = true;
                queue.offer(new int[] {number + 1, count + 1});
            }
            if (number % 2 == 0 && !visited[number/2]) {
                visited[number/2] = true;
                queue.offer(new int[] {number / 2, count + 1});
            }
            if (number % 3 == 0 && !visited[number/3]) {
                visited[number/3] = true;
                queue.offer(new int[] {number / 3, count + 1});
            }
        }
    }
}