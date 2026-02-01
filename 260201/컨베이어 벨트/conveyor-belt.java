import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] top = new int[n];
        int[] bottom = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bottom[i] = sc.nextInt();
        }

        // 둘 다 오른쪽으로 한 칸씩
        // 가장 오른쪽의 요소는 다음 배열로
        for (int i = 0; i < t; i++) {
            int topTemp = top[n-1];
            int bottomTemp = bottom[n-1];
            for (int k = n - 1; k >= 1; k--) {
                top[k] = top[k-1];
                bottom[k] = bottom[k-1];
            }
            top[0] = bottomTemp;
            bottom[0] = topTemp;
        }

        for (int e : top) {
            System.out.print(e + " ");
        }
        System.out.println();
        for (int e : bottom) {
            System.out.print(e + " ");
        }
    }
}