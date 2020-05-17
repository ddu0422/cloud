package baekjoon.codeplus.beginner2.dp;

import java.util.Scanner;

// 1, 2, 3 더하기 5
// 연속은 2개씩 나눌 수 있다. -> 이중 배열을 사용한다.
// d[n - 1][1] = d[n - 1][2] + d[n - 1][3]
// d[n - 2][2] = d[n - 2][1] + d[n - 2][3]
// d[n - 3][3] = d[n - 3][1] + d[n - 3][2]
// d[n][m] = d[n - 1][1] + d[n - 2][2] + d[n - 3][3]
// 1. d[n][m] = 마지막 수가 m인 경우 n을 1, 2, 3의 합으로 나타내는 방법의 수 (수를 연속으로 사용할 수 없다.)
// 2. d[n - 1][1] = 마지막 수가 1인 경우 n을 1, 2, 3의 합으로 나타내는 방법의 수 (수를 연속으로 사용할 수 없다.)
// 3. d[n - 2][2] = 마지막 수가 2인 경우 n을 1, 2, 3의 합으로 나타내는 방법의 수 (수를 연속으로 사용할 수 없다.)
// 4. d[n - 3][3] = 마지막 수가 3인 경우 n을 1, 2, 3의 합으로 나타내는 방법의 수 (수를 연속으로 사용할 수 없다.)
// 5. 예외) n = 1, 2, 3 구하기
// 6. d[1][1] = d[2][2] = d[3][3] = d[3][2] = d[3][1] = 1

public class P15990 {
    private static final long MOD = 1_000_000_009L;
    private static final int LIMIT = 100_000;
    private static long[][] d;
    private static int[] numbers = {2, 3, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        d = new long[LIMIT + 1][4];
        d[1][1] = d[2][2] = d[3][3] = d[3][2] = d[3][1] = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            System.out.println((go(n, 1) + go(n, 2) + go(n, 3)) % MOD);
        }
    }

    private static long go(int n, int m) {
        if (n < 3 || d[n][m] > 0) return d[n][m];

        d[n][m] = (go(n - m, numbers[(m - 1)]) + go(n - m, numbers[(m % 3)])) % MOD;

        return d[n][m];
    }
}
