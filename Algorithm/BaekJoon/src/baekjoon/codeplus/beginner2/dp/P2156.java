package baekjoon.codeplus.beginner2.dp;

import java.util.Scanner;

// 포도주 시식
// d[n][m] = n잔 중 m 상황일 때 최대의 양
// d[n][0] = n잔 중 0 상황일 때 최대의 양 (?, ?, x)
// d[n][1] = n잔 중 1 상황일 때 최대의 양 (?, x, o)
// d[n][2] = n잔 중 2 상황일 때 최대의 양 (x, o, o)
// d[n][0] = max(d[n - 1][0], d[n - 1][1], d[n - 1][2])
// d[n][1] = d[n - 1][0] + a[n]
// d[n][2] = d[n - 2][0] + a[n] + a[n - 1]

public class P2156 {
    private static int[][] d;
    private static int[] a;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        d = new int[n + 1][3];
        a = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        d[1][1] = a[1];

        for (int i = 2; i <= n; i++) {
            d[i][0] = Math.max(d[i - 1][0], Math.max(d[i - 1][1], d[i - 1][2]));
            d[i][1] = d[i - 1][0] + a[i];
            d[i][2] = d[i - 2][0] + a[i] + a[i - 1];
        }

        System.out.println(Math.max(d[n][0], Math.max(d[n][1], d[n][2])));
    }
}
