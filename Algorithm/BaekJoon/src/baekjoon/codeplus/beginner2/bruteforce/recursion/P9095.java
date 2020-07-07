package baekjoon.codeplus.beginner2.bruteforce.recursion;

import java.util.Scanner;

// 1, 2, 3 더하기
// 1. 차례대로 재귀를 이용해서 해당 숫자가 나올때까지 더한다.
// 2. 해당 숫자를 넘을 경우 -> 구할 수 없음(+ 0)
// 3. 해당 숫자 일 경우 -> 구할 수 있음 (+ 1)

public class P9095 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            System.out.println(recursion(0, scanner.nextInt()));
        }
    }

    private static int recursion(int sum, int goal) {
        // 종료 조건
        if (sum > goal) {
            return 0;
        }

        // 정답을 찾는 경우
        if (sum == goal) {
            return 1;
        }

        int answer = 0;

        // 다음 경우
        for (int i = 1; i <= 3; i++) {
            answer += recursion(sum + i, goal);
        }

        return answer;
    }
}
