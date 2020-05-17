package baekjoon.codeplus.beginner2.dp;

import java.util.Scanner;

// 카드 구매하기 2
// d[n] = min(d[n - i] + p[i]) (1 <= i <= n)
// 1. d[n] : 카드를 구매하기 위한 최소값
// 2. d[n - i] : 마지막 카드를 i개 짜리 구매했을 때 카드를 구매하기 위한 최소값
// 3. p[n] : 카드를 구매했을 때의 가격
// 4. 예외 n = 0, 1 구하기
// 5. d[1] = p[1]이므로 d[0] = 0

public class P16194 {
    private static int[] d;
    private static int[] p;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        d = new int[n + 1];
        p = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            p[i] = scanner.nextInt();
        }

        System.out.println(go(n));
    }

    private static int go(int n) {
        if (n == 0) return 0;
        if (d[n] > 0) return d[n];

        d[n] = p[n];

        for (int i = 1; i <= n; i++) {
            if (d[n] > d[n - i] + p[i]) {
                d[n] = go(n - i) + p[i];
            }
        }

        return d[n];
    }
}
