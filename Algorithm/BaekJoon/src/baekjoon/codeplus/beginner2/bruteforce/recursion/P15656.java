package baekjoon.codeplus.beginner2.bruteforce.recursion;

import java.util.Arrays;
import java.util.Scanner;

// N과 M (7)
// 1. 순서
// 2. 중복 o
// 3. 사전순 증가
// 4. 수를 입력 받음

public class P15656 {
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

        for (int i = 0; i < n; i++) {
            results[index] = numbers[i];
            go(index + 1, n, m);
        }
    }
}
