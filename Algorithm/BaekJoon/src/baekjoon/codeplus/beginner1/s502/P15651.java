package baekjoon.codeplus.beginner1.s502;

import java.util.Scanner;

public class P15651 {
    private static StringBuilder stringBuilder = new StringBuilder();
    private static int[] a = new int[10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        go(0, scanner.nextInt(), scanner.nextInt());
        System.out.println(stringBuilder.toString());
    }

    private static void go(int index, int n, int m) {
        if (index == m) {
            for (int i : a) {
                if (i != 0) stringBuilder.append(i).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            a[index] = i;
            go(index + 1, n, m);
        }
    }
}
