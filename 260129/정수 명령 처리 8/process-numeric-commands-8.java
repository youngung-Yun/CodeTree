import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int e;
            String command = sc.next();
            // Please write your code here.
            switch (command) {
                case "push_front":
                    e = sc.nextInt();
                    list.addFirst(e);
                    break;
                case "push_back":
                    e = sc.nextInt();
                    list.addLast(e);
                    break;
                case "pop_front":
                    System.out.println(list.pollFirst());
                    break;
                case "pop_back":
                    System.out.println(list.pollLast());
                    break;
                case "size":
                    System.out.println(list.size());
                    break;
                case "empty":
                    System.out.println(list.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(list.peekFirst());
                    break;
                case "back":
                    System.out.println(list.peekLast());
                    break;
            }
        }
    }
}