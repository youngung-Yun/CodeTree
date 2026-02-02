import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        // Please write your code here.
        for (int i = 0; i < t; i++) {
            int lTmp = l[n-1];
            int rTmp = r[n-1];
            int dTmp = d[n-1];
            for (int k = n - 1; k >= 1; k--) {
                l[k] = l[k-1];
                r[k] = r[k-1];
                d[k] = d[k-1];
            }
            r[0] = lTmp;
            d[0] = rTmp;
            l[0] = dTmp;
        }

        printArray(l);
        printArray(r);
        printArray(d);

    }

    static void printArray(int[] arr) {
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}