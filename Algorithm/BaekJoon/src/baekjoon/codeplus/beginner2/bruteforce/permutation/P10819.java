package baekjoon.codeplus.beginner2.bruteforce.permutation;

import java.util.Arrays;
import java.util.Scanner;

// 차이를 최대로
// 1. 길이가 8이 최대이므로 8 x 8!이다. 따라서 모든 순열을 구할 수 있다.
// 2. 식의 최대값을 구한다. |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|

public class P10819 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        Arrays.sort(a);

        int max = 0;

        do {
            max = Math.max(max, calculate(a));
        } while (nextPermutation(a));

        System.out.println(max);
    }

    private static int calculate(int[] a) {
        int sum = 0;

        for (int i = 1; i < a.length; i++) {
            sum += Math.abs(a[i - 1] - a[i]);
        }

        return sum;
    }

    private static boolean nextPermutation(int[] a) {
        int i = a.length - 1;
        int j = a.length - 1;

        while (i > 0 && a[i - 1] >= a[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        while (a[i - 1] >= a[j]) {
            j--;
        }

        swap(a, i - 1, j);

        j = a.length - 1;

        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }

        return true;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
