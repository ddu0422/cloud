package baekjoon.codeplus.beginner2.dp;

import java.util.Scanner;

// 1, 2, 3 더하기
// d[n] = d[n - 1] + d[n - 2] + d[n - 3]
// 1. d[n] = 1, 2, 3의 합으로 나타내는 경우의 수
// 2. d[n - 1] = 마지막이 1인 경우 1, 2, 3의 합으로 나타내는 경우의 수
// 3. d[n - 2] = 마지막이 2인 경우 1, 2, 3의 합으로 나타내는 경우의 수
// 4. d[n - 3] = 마지막이 3인 경우 1, 2, 3의 합으로 나타내는 경우의 수
// 5. 예외 n = 0, 1, 2 구하기
// 6. d[1] = 1, d[2] = 2, d[3] = 4이므로, d[0] = 1으로 설정해야한다.

public class P9095 {
    private static final int LIMIT = 10;
    private static int[] d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        d = new int[LIMIT + 1];
        int t = scanner.nextInt();

        while (t-- > 0) {
            System.out.println(go(scanner.nextInt()));
        }
    }

    private static int go(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (d[n] > 0) return d[n];

        d[n] = go(n - 1) + go(n - 2) + go(n - 3);

        return d[n];
    }
}
