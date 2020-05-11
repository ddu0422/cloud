package baekjoon.codeplus.beginner1.s502;

import java.util.Arrays;
import java.util.Scanner;

public class P15655 {
    private static StringBuilder stringBuilder = new StringBuilder();
    private static boolean[] c = new boolean[10];
    private static int[] a = new int[10];
    private static int[] num = new int[10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Arrays.fill(num, 10_001);
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }
        Arrays.sort(num);

        go(0, 0, n, m);

        System.out.println(stringBuilder.toString());
    }

    private static void go(int index, int selected, int n, int m) {
        if (selected == m) {
            for (int i : a) {
                if (i != 0) stringBuilder.append(i).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        if (index > n - 1) return;

        a[selected] = num[index];
        go(index + 1, selected + 1, n, m);
        a[selected] = 0;
        go(index + 1, selected, n, m);
    }
}
