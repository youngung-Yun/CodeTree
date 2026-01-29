import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        sc.nextLine();
        
        LinkedList<Character> list = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            list.addLast(ch);
        }
        // 이터레이터 위치 맨 뒤로
        ListIterator<Character> iter = list.listIterator();
        while (iter.hasNext()) {
            iter.next();
        }

        for (int i = 0; i < m; i++) {
            String command = sc.nextLine();
            if (command.equals("L")) {
                if (iter.hasPrevious()) {
                    iter.previous();
                }
            } else if (command.equals("R")) {
                if (iter.hasNext()) {
                    iter.next();
                }
            } else if (command.equals("D")) {
                if (iter.hasNext()) {
                    iter.next();
                    iter.remove();
                }
            } else {
                String[] input = command.split(" ");
                char ch = input[1].charAt(0);
                iter.add(ch);
            }
        }
        for (char ch : list) {
            System.out.print(ch);
        }
    }
}