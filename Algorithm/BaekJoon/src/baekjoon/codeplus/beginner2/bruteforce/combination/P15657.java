package baekjoon.codeplus.beginner2.bruteforce.combination;

import java.util.Arrays;
import java.util.Scanner;

// N과 M (8)
// 1. 순서
// 2. 중복 O
// 3. 비내림차순
// 4. 수를 입력 받음

public class P15657 {
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
        go(0, 0, n, m);
        System.out.print(stringBuilder.toString());
    }

    private static void go(int index, int start, int n, int m) {
        if (index == m) {
            for (int result : results) {
                stringBuilder.append(result).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            results[index] = numbers[i];
            go(index + 1, i, n, m);
        }
    }
}
