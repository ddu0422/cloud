package baekjoon.codeplus.beginner2.dp;

import java.util.Scanner;

// 1로 만들기
// D[i] = min(D[i - 1], D[i / 2], D[i / 3]) + 1

public class P1463 {
    private static int[] d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        d = new int[n + 1];

        System.out.println(go(n));
    }

    private static int go(int n) {
        if (n == 1) return 0;
        if (d[n] > 0) return d[n];

        d[n] = go(n - 1) + 1;

        if (n % 2 == 0) {
            if (d[n] > d[n / 2] + 1) {
                d[n] = go(n / 2) + 1;
            }
        }

        if (n % 3 == 0) {
            if (d[n] > d[n / 3] + 1) {
                d[n] = go(n / 3) + 1;
            }
        }

        return d[n];
    }
}
