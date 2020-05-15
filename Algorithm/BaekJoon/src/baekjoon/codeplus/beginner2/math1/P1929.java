package baekjoon.codeplus.beginner2.math1;

import java.util.Scanner;

// 소수 구하기
// 소수를 직접 구하는 방법은 에라토스테네스의 체를 이용한다.
// n의 크기가 최대 1_000_000 이므로 i * 2를 사용한다.

public class P1929 {
    private static final String NEWLINE = "\n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        boolean[] isNotPrimes = new boolean[n + 1];

        isNotPrimes[0] = isNotPrimes[1] = true;

        for (int i = 2; i <= n; i++) {
            if (!isNotPrimes[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    isNotPrimes[j] = true;
                }
            }
        }

        for (int i = m; i <= n; i++) {
            if (!isNotPrimes[i]) {
                stringBuilder.append(i).append(NEWLINE);
            }
        }

        System.out.print(stringBuilder.toString());
    }
}
