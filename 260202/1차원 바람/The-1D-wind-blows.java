import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int r = sc.nextInt();
            // 0-based
            r -= 1;
            char d = sc.next().charAt(0);
            boolean toRight = d == 'L';
            int[] curr = a[r];
            if (toRight) {
                moveRight(curr);
            } else {
                moveLeft(curr);
            }
            int top = r - 1;
            boolean direction = !toRight;
            while (top >= 0 && hasSameElement(curr, a[top])) {
                if (toRight) {
                    moveRight(a[top]);
                } else {
                    moveLeft(a[top]);
                }
                curr = a[top];
                top -= 1;
                direction = !direction;
            }
            curr = a[r];
            int bottom = r + 1;
            while (bottom < n && hasSameElement(curr, a[bottom])) {
                if (d == 'L') {
                    moveLeft(a[bottom]);
                } else {
                    moveRigh(a[bottom]);
                }
                curr = a[bottom];
                bottom += 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : a) {
            for (int col : row) {
                sb.append(col).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    // <-
    static void moveLeft(int[] arr) {
        int tmp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = tmp;
    }   

    // ->
    static void moveRight(int[] arr) {
        int tmp = arr[arr.length-1];
        for (int i = arr.length - 1; i >= 1; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = tmp; 
    }

    static boolean hasSameElement(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[i]) {
                return true;
            }
        }
        return false;
    }
}