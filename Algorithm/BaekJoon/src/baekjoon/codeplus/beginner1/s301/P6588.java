package baekjoon.codeplus.beginner1.s301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 소수를 직접 찾는 것 [에라토스테네스 + 골드바흐]

public class P6588 {
    private static final int MAX = 1_000_000;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            List<Integer> primes = new ArrayList<>();

            boolean[] isPrime = new boolean[MAX + 1];
            Arrays.fill(isPrime, true);
            isPrime[0] = isPrime[1] = false;


            for (int i = 2; i * i <= MAX; i++) {
                if (isPrime[i]) {
                    // 소수를 구한다.
                    primes.add(i);
                    // 소수를 이용하여 소수가 아닌 숫자를 제거한다.
                    for (int j = i * 2; j <= MAX; j += i) {
                        isPrime[j] = false;
                    }
                }
            }

            while (true) {
                // 숫자를 입력받는다.
                int n = Integer.parseInt(bufferedReader.readLine());
                if (n == 0) break;

                // 소수 중 홀수여야하므로 i = 1부터 시작한다.
                for (int i = 1; i < primes.size(); i++) {
                    int p = primes.get(i);
                    if (isPrime[n - p]) {
                        System.out.println(n + " = " + p + " + " + (n - p));
                        break;
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }

    }
}
