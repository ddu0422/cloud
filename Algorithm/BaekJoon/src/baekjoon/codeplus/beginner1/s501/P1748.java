package baekjoon.codeplus.beginner1.s501;

import java.util.Scanner;

public class P1748 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long answer = 0;

        for (int start = 1, len = 1; start <= n; start *= 10, len++) {
            int end = start * 10 - 1;
            if (end > n) {
                end = n;
            }
            answer += (end - start + 1L) * len;
        }

        System.out.println(answer);
    }
}
