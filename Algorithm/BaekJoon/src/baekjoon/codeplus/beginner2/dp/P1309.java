package baekjoon.codeplus.beginner2.dp;

import java.util.Scanner;

// 동물원
// d[n][m] = d[n][0] + d[n][1] + d[n][2]
// 1. d[n][m] = m번째 상황일 때 n에 놓을 수 있는 경우의 수
// 2. d[n][0] = (x, x) 상황일 때 n에 놓을 수 있는 경우의 수
// 3. d[n][1] = (x, o) 상황일 때 n에 놓을 수 있는 경우의 수
// 4. d[n][2] = (o, x) 상황일 때 n에 놓을 수 있는 경우의 수
// 5. d[n][0] = d[n - 1][0] + d[n - 1][1] + d[n - 1][2]
// 6. d[n][1] = d[n - 1][0] + d[n - 1][2]
// 7. d[n][2] = d[n - 1][0] + d[n - 1][1]

public class P1309 {
    private static long[][] d;
    private static final long MOD = 9901;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        d = new long[n + 1][3];

        d[1][0] = d[1][1] = d[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            d[i][0] = (d[i - 1][0] + d[i - 1][1] + d[i - 1][2]) % MOD;
            d[i][1] = (d[i - 1][0] + d[i - 1][2]) % MOD;
            d[i][2] = (d[i - 1][0] + d[i - 1][1]) % MOD;
        }

        System.out.println((d[n][0] + d[n][1] + d[n][2]) % MOD);
    }
}
