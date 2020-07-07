package baekjoon.codeplus.beginner2.bruteforce.combination;

import java.util.Arrays;
import java.util.Scanner;

// N과 M (11)
// 1. 중복 o
// 2. 사전 순 증가
// 3. 수열 중복 x

public class P15665 {
    private static StringBuilder stringBuilder = new StringBuilder();
    private static int[] numbers;
    private static int[] results;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        numbers = new int[n];
        results = new int[m];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        go(0, n, m);
        System.out.print(stringBuilder.toString());
    }

    private static void go(int index, int n, int m) {
        if (index == m) {
            for (int result : results) {
                stringBuilder.append(result).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        int previousNumber = -1;

        for (int i = 0; i < n; i++) {
            if (previousNumber == numbers[i]) {
                continue;
            }

            previousNumber = numbers[i];
            results[index] = numbers[i];
            go(index + 1, n, m);
        }
    }
}
