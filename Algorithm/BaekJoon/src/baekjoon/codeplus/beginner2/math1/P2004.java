package baekjoon.codeplus.beginner2.math1;

import java.util.Scanner;

// 조합 0 의 개수
// 1. 조합은 2와 5중 어느 것이 더 많이 오는지 모른다.
// 2. 따라서 둘 다 구해서 둘중에 작은 값을 찾는다.
// 3. nCm 이므로
// 4. n! 은 +
// 5. (n-m)! m! 은 -

public class P2004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long two = 0L;
        long five = 0L;

        // n - m, m 은 n보다 작으므로 i가 n-m 보다 커지면 0이 빼지므로 한번에 할 수 있다.
        for (long i = 2; i <= n; i *= 2) {
            two += n / i;
            two -= (n - m) / i;
            two -= m / i;
        }

        for (long i = 5; i <= n; i *= 5) {
            five += n / i;
            five -= (n - m) / i;
            five -= m / i;

        }

        System.out.println(Math.min(two, five));
    }
}
