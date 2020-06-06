package baekjoon.codeplus.beginner2.bruteforce;

import java.util.Scanner;

// 리모콘 문제
// 채널이 50만개가 있으므로 0 -> 50만으로 갈 수 있는 경우의 수와 마찬가지로 100만 -> 50만으로 갈 수 있는 경우의 수를 구해야한다.

public class P1107 {
    private static final int MAX_CHANNEL = 1_000_000;
    private static boolean[] broken;
    private static final int CURRENT_CHANNEL = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        broken = new boolean[10];

        for (int i = 0; i < m; i++) {
            broken[scanner.nextInt()] = true;
        }

        int answer = Math.abs(n - CURRENT_CHANNEL);

        for (int i = 0; i <= MAX_CHANNEL; i++) {
            int countOfTimesPressedWithNumber = countOfPossibleNumberPress(i);

            if (countOfTimesPressedWithNumber > 0) {
                int countOfTimesPressedWithSign = Math.abs(i - n);
                answer = Math.min(answer, countOfTimesPressedWithNumber + countOfTimesPressedWithSign);
            }
        }

        System.out.println(answer);
    }

    private static int countOfPossibleNumberPress(int c) {
        if (c == 0) {
            if (broken[c]) {
                return 0;
            } else {
                return 1;
            }
        }

        int length = 0;

        while (c > 0) {
            if (broken[c % 10]) {
                return 0;
            }

            length += 1;
            c /= 10;
        }

        return length;
    }
}
