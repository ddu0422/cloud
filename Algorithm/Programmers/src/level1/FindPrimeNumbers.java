package level1;

import java.util.Arrays;

// 에라토스테네스의 체가 최고다.
public class FindPrimeNumbers {
    private static final int LIMIT = 1_000_000;
    private static boolean[] isPrime = new boolean[LIMIT + 1];

    public static void main(String[] args) {
        int n = 12;

        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int answer = 0;

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= LIMIT; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j <= LIMIT; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (isPrime[i]) {
                answer++;
            }
        }

        return answer;
    }
}
