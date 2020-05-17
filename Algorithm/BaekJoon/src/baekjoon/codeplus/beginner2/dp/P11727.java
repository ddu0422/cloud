package baekjoon.codeplus.beginner2.dp;

import java.util.Scanner;

// 2 x N 타일링 2
// d[n] = d[n - 1] + 2 * d[n - 2]
// 1. d[n] = 2 x N을 만들 수 있는 경우의 수
// 2. d[n - 1] = 마지막이 2 x 1인 블록을 놓았을 때 2 x N을 만들 수 있는 경우의 수
// 3. d[n - 2] = 마지막이 1 x 2인 블록을 놓았을 때 2 x N을 만들 수 있는 경우의 수
// 4. d[n - 2] = 마지막이 2 x 2인 블록을 놓았을 때 2 x N을 만들 수 있는 경우의 수
// 5. 예외) n = 0, n = 1 구하기
// 6. d[1] = 1, d[2] = 3이므로 d[0] = 1로 설정해야한다.

public class P11727 {
    private static final int MOD = 10007;
    private static int[] d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        d = new int[n + 1];

        System.out.println(go(n));
    }

    private static int go(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (d[n] > 0) return d[n];

        d[n] = (go(n - 1) + 2 * go(n - 2)) % MOD;

        return d[n];
    }
}
