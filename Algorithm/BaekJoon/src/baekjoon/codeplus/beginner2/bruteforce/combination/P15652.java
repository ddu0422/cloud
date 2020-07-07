package baekjoon.codeplus.beginner2.bruteforce.combination;

// N과 M (4)
// 순서
// 중복 가능
// 비내림차순
// 시간복잡도 : N!

import java.util.Scanner;

public class P15652 {
    private static StringBuilder stringBuilder = new StringBuilder();
    private static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        a = new int[m + 1];

        go(1, 1, n, m);
        System.out.print(stringBuilder.toString());
    }

    private static void go(int index, int start, int n, int m) {
        if (index == m + 1) {
            for (int i = 1; i <= m; i++) {
                stringBuilder.append(a[i]).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            a[index] = i;
            go(index + 1, i, n, m);
        }
    }
}
