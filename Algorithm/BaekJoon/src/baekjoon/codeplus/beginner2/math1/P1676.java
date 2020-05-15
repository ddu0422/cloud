package baekjoon.codeplus.beginner2.math1;

import java.util.Scanner;

// 팩토리얼 0의 개수
// 숫자의 0의 개수를 구하는 문제이다.
// 1. 0을 만들려면 2와 5가 필요하다.
// 2. 팩토리얼은 5의 개수가 2의 개수보다 적으므로 5의 개수만 세면 된다.

public class P1676 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int answer = 0;

        for (int i = 5; i <= n; i *= 5) {
            answer += n / i;
        }

        System.out.println(answer);
    }
}
