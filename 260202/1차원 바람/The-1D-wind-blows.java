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
            if (toRight) {
                moveRight(a[r]);
            } else {
                moveLeft(a[r]);
            }

            toRight = !toRight;
            for (int k = r - 1; k >= 0; k--) {
                if (!hasSameElement(a[k], a[k+1])) {
                    break;
                }
                if (toRight) {
                    moveRight(a[k]);
                } else {
                    moveLeft(a[k]);
                }
                toRight = !toRight;
            }

            toRight = !(d == 'L');
            for (int k = r + 1; k < n; k++) {
                if (!hasSameElement(a[k], a[k-1])) {
                    break;
                }
                if (toRight) {
                    moveRight(a[k]);
                } else {
                    moveLeft(a[k]);
                }
                toRight = !toRight;
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