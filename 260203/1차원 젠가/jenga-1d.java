import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        // Please write your code here.
        int n = Integer.parseInt(buffer.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(buffer.readLine());
        }
        
        for (int i = 0; i < 2; i++) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int s = Integer.parseInt(token.nextToken());
            int e = Integer.parseInt(token.nextToken());
            arr = removeBlock(arr, s - 1, e - 1);
        }
        
        System.out.println(arr.length);
        for (int e : arr) {
            System.out.println(e);
        }
    }

    static int[] removeBlock(int[] arr, int s, int e) {
        int[] tmp = new int[arr.length - (e - s + 1)];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < s || i > e) {
                tmp[idx] = arr[i];
                ++idx;
            }
        }
        return tmp;
    }
}