package baekjoon.codeplus.beginner2.bruteforce.recursion;

import java.util.Arrays;
import java.util.Scanner;

// N과 M (10)
// 1. 중복 x
// 2. 비내림차순
// 3. 순열 중복 x

public class P15664 {
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
    }

    private static void go(int index, int start, int n, int m) {
        if (index == m) {
            for (int result : results) {
                System.out.print(result + " ");
            }
            System.out.println();
            return;
        }

        int previousNumber = -1;

        for (int i = start; i < n; i++) {
            if (previousNumber == numbers[i]) {
                continue;
            }
            previousNumber = numbers[i];
            results[index] = numbers[i];
            go(index + 1, i + 1, n, m);
        }
    }
}
