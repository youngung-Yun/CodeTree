import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int min = 100 * 100 * 100;
        for (int i = 0; i < n; i++) {
            int distance = 0;
            for (int k = 0; k < n; k++) {
                distance += Math.abs(k - i) * a[k];
            }
            min = Integer.min(min, distance);
        }
        System.out.println(min);
    }
}