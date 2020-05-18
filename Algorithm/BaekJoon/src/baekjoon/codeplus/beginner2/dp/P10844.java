package baekjoon.codeplus.beginner2.dp;

import java.util.Scanner;

// 쉬운 계단 수
// d[n][m] = d[n - 1][m - 1] + d[n + 1][m + 1]
// 1. d[n][m] = 마지막 숫자가 m일 때 길이가 n인 계단 수
// 2. d[n - 1][m - 1] = 마지막 숫자가 m - 1일 때 길이가 n - 1인 계단 수
// 3. d[n - 1][m + 1] = 마지막 숫자가 m + 1일 때 길이가 n - 1인 계단 수
// 4. 예외 n = 0, 9
// 5. 0으로는 시작할 수 없다.
// 6. 9보다 클 수 없다.
// 7. 0보다 작을 수 없다.

public class P10844 {
    private static long MOD = 1_000_000_000;
    private static long[][] d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        d = new long[n + 1][10];
        long sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += go(n, i);
        }

        System.out.println(sum % MOD);
    }

    private static long go(int n, int m) {
        // d[1][0] = 0 이므로 예외처리 해야 한다.
        if (n == 1 && m == 0) return 0;
        if (n == 1) return 1;
        if (d[n][m] > 0) return d[n][m];

        if (m > 0) d[n][m] += go(n - 1, m - 1);
        if (m < 9) d[n][m] += go(n - 1, m + 1);

        return d[n][m] % MOD;
    }
}
