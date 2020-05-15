package baekjoon.codeplus.beginner2.math1;

import java.util.Scanner;

// GCD의 합
// 1. 유클리드호제법을 이용해서 각 썽의 GCD 를 구한다.
// 2. 합을 구한다.

public class P9613 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            long[] numbers = new long[n];
            long sum = 0;

            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextInt();
            }

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    sum += gcd(numbers[i], numbers[j]);
                }
            }

            System.out.println(sum);
        }
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
