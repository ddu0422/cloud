package baekjoon.codeplus.beginner1.s503;

import java.util.Arrays;
import java.util.Scanner;

public class P10819 {
    private static int[] a = new int[8];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        Arrays.sort(a, 0, n);

        int answer = 0;

        do {
            answer = Math.max(answer, calculate(n));
        } while (nextPermutation(n));

        System.out.println(answer);
    }

    private static int calculate(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += Math.abs(a[i] - a[i - 1]);
        }
        return sum;
    }

    private static boolean nextPermutation(int n) {
        // 1번 : a[i - 1] < a[i] 를 만족하는 i중 가장 큰 값
        int i = n - 1;
        while (i > 0 && a[i - 1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) return false; // 마지막 순열 !!

        // 2번 a[i - 1] < a[j]를 만족하는 j중 가장 큰 값
        int j = n - 1;
        while (a[j] <= a[i - 1]) {
            j -= 1;
        }

        // 3번 자리 바꿈 (swap)
        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        // 4번 a[i] 뒤 쪽을 뒤집는다.
        j = n - 1;
        while (i < j) {
            int temp1 = a[i];
            a[i] = a[j];
            a[j] = temp1;
            i += 1;
            j -= 1;
        }

        return true;
    }
}
