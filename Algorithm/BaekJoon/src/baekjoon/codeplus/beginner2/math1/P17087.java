package baekjoon.codeplus.beginner2.math1;

import java.util.Scanner;

// 숨바꼭질 6
// 1. 수빈이는 일정한 거리만큼 이동할 수 있다.
// 2. 수빈이는 동생들을 모두 찾아야한다.
// 3. 동생들과 수빈이의 거리를 구해서 최대로 이동할 수 있는 거리를 구한다.

public class P17087 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long s = scanner.nextLong();
        long[] numbers = new long[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Math.abs(scanner.nextLong() - s);
        }

        long answer = numbers[0];

        for (int i = 1; i < n; i++) {
            answer = gcd(answer, numbers[i]);
        }

        System.out.println(answer);
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
