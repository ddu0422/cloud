package baekjoon.codeplus.beginner2.math1;

import java.util.Scanner;

// 골드바흐 파티션
// 2 ~ 1_000_000 중 짝수가 들어온다.
// 1. 두 소수의 합으로 구할 수 있는 경우의 수를 구한다.

public class P17103 {
    private static final int LIMIT = 1_000_000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        boolean[] isNotPrimes = new boolean[LIMIT + 1];

        isNotPrimes[0] = isNotPrimes[1] = true;

        for (int i = 2; i <= LIMIT; i++) {
            if (!isNotPrimes[i]) {
                for (int j = i * 2; j <= LIMIT; j += i) {
                    isNotPrimes[j] = true;
                }
            }
        }

        while (t-- > 0) {
            int n = scanner.nextInt();
            int answer = 0;

            for (int i = 2; i * 2 <= n; i++) {
                if (!isNotPrimes[i] && !isNotPrimes[n - i]) {
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }
}
