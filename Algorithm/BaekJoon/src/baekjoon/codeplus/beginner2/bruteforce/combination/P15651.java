package baekjoon.codeplus.beginner2.bruteforce.combination;

import java.util.Scanner;

// N과 M (3)
// 순열
// 중복가능

public class P15651 {
    private static StringBuilder stringBuilder = new StringBuilder();
    private static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        a = new int[m + 1];

        go(1, n, m);
        System.out.print(stringBuilder.toString());
    }

    private static void go(int index, int n, int m) {
        if (index == m + 1) {
            for (int i = 1; i <= m; i++) {
                stringBuilder.append(a[i]).append(" ");
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
