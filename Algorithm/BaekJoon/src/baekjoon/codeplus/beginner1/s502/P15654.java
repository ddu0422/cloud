package baekjoon.codeplus.beginner1.s502;

import java.util.Arrays;
import java.util.Scanner;

public class P15654 {
    private static int[] a = new int[10];
    private static int[] num = new int[10];
    private static boolean[] c = new boolean[10];
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Arrays.fill(num, 10001);

        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }

        Arrays.sort(num);

        go(0, n, m);

        System.out.print(stringBuilder.toString());
    }

    private static void go(int index, int n, int m) {
        if (index == m) {
            for (int i : a) {
                if (i != 0) stringBuilder.append(i).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (c[i]) continue;
            c[i] = true;
            a[index] = num[i];
            go(index + 1, n, m);
            c[i] = false;
        }
    }
}
