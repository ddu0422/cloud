package baekjoon.codeplus.beginner2.math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 골드바흐의 추측
// 1. 에라토스테네스의 체를 이용하여 소수를 구한다.
// 2. 수가 주어지면 해당 수를 만들 수 있는 두 소수의 합을 구한다.
// 3. 여러개 있을 경우 수의 차이가 가장 큰 값을 출력한다.

public class P6588 {
    private static final String NEWLINE = "\n";
    private static final int LIMIT = 1_000_000;
    private static boolean[] isNotPrimes = new boolean[LIMIT + 1];

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder stringBuilder = new StringBuilder();

            isNotPrimes[0] = isNotPrimes[1] = true;

            for (int i = 2; i <= LIMIT; i++) {
                if (!isNotPrimes[i]) {
                    for (int j = i * 2; j <= LIMIT; j += i) {
                        isNotPrimes[j] = true;
                    }
                }
            }

            while (true) {
                int n = Integer.parseInt(bufferedReader.readLine());

                if (n == 0) break;

                for (int i = 2; i * 2 <= n; i++) {
                    if (!isNotPrimes[i] && !isNotPrimes[n - i]) {
                        stringBuilder.append(n).append(" = ")
                                .append(i).append(" + ").append(n - i)
                                .append(NEWLINE);
                        break;
                    }
                }
            }

            System.out.print(stringBuilder.toString());

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
