package baekjoon.codeplus.beginner1.s501;

import java.util.Scanner;

public class P6064 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        while (count-- > 0) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            boolean ok = false;

            for (int i = x; i < m * n; i += m) {
                if (i % n == y) {
                    System.out.println(i + 1);
                    ok = true;
                    break;
                }
            }

            if (!ok) System.out.println(-1);
        }
    }
}
