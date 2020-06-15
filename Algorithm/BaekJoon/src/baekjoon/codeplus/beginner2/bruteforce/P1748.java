package baekjoon.codeplus.beginner2.bruteforce;

import java.util.Scanner;

public class P1748 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long answer = 0L;

        for (long start = 1L, length = 1L; start <= n; start *= 10L, length++) {
            long end = Math.min(start * 10L - 1L, n);
            answer += (end - start + 1L) * length;
        }

        System.out.println(answer);
    }
}
