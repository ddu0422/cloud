package baekjoon.codeplus.beginner2.math1;

import java.util.Scanner;

// 소수 찾기
// 1 ~ N^1/2까지만 조회

public class P1978 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int answer = 0;

        while (n-- > 0) {
            answer += prime(scanner.nextInt());
        }

        System.out.println(answer);
    }

    private static int prime(int number) {
        if (number < 2) return 0;

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return 0;
        }

        return 1;
    }
}
