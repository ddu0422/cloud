package baekjoon.codeplus.beginner2.dp;

// 오르막 수
// d[n][m] = sum(d[n - 1][0] ~ d[n - 1][m])
// 1. d[n][m] : 마지막 수가 m 일때 n자리 오르막 수
// 2. d[n - 1][m] : 마지막 수가 m일때 n - 1자리 오르막 수
// 3. 0 <= m <= 9
// 4. 숫자는 0으로 시작해도 된다.

import java.util.Scanner;

public class P11057 {
    private static final long MOD = 10_007;
    private static final int LIMIT = 10;
    private static long[][] d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        d = new long[n + 1][LIMIT];

        for (int i = 0; i < LIMIT; i++) {
            d[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < LIMIT; j++) {
                for (int k = 0; k <= j; k++) {
                    d[i][j] += d[i - 1][k];
                    d[i][j] %= MOD;
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < LIMIT; i++) {
            answer += d[n][i];
        }

        System.out.println(answer % MOD);
    }
}
