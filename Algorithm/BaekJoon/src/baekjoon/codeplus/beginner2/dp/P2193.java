package baekjoon.codeplus.beginner2.dp;

import java.util.Scanner;

// 이친수
// d[n][0] = d[n - 1][0] + d[n - 1][1]
// d[n][1] = d[n - 1][0]
// 1. d[n][m] = 마지막이 m인 n 자리 수
// 2. d[n - 1][0] = 마지막이 0인 n - 1 자리 수
// 3. d[n - 1][1] = 마지막이 1인 n - 1 자리 수
// 예외 n = 1
// d[1][0] = 0, d[1][1] = 1

public class P2193 {
    private static long[][] d;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        d = new long[n + 1][2];
        long answer = 0;

        for (int i = 0; i < 2; i++) {
            answer += go(n, i);
        }

        System.out.println(answer);
    }

    private static long go(int n, int m) {
        if (n == 1 && m == 0) return 0;
        if (n == 1) return 1;
        if (d[n][m] > 0) return d[n][m];

        d[n][m] += go(n - 1, 0);

        if (m == 0) {
            d[n][m] += go(n - 1, 1);
        }

        return d[n][m];
    }
}
