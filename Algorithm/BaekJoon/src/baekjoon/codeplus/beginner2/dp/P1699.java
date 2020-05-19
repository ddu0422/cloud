package baekjoon.codeplus.beginner2.dp;

import java.util.Scanner;

// 제곱수의 합
// d[n] = min(d[n - m^2] + 1)
// 1. d[n] : 숫자가 n일 때 제곱수의 항의 개수
// 2. d[n - m^2] : 마지막 숫자가 m일 때 n의 제곱수의 항의 개수
// 3. 각 항은 n개의 최대항의 개수는 n -> d[n] = n

public class P1699 {
    private static int[] d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        d = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            d[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                d[i] = Math.min(d[i], d[i - j * j] + 1);
            }
        }

        System.out.println(d[n]);
    }
}
