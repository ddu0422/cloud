package baekjoon.codeplus.beginner2.bruteforce.permutation;

import java.util.Scanner;

// 이전 순열
// 1. 다음 순열과 반대로 푼다.
// 2. 이전 순열 구하는 방법
//   2-1. a[i - 1] > a[i]를 만족하는 가장 큰 i를 구한다.
//   2-2. i <= j, a[i - 1] > a[j]를 만족하는 가장 큰 j를 구한다.
//   2-3. a[i - 1]과 a[j]를 swap한다.
//   2-4. a[i]부터 순열을 뒤집는다.

public class P10973 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        if (previousPermutation(arr)) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }

    private static boolean previousPermutation(int[] arr) {
        int i = arr.length - 1;
        int j = arr.length - 1;

        while (i > 0 && arr[i - 1] <= arr[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        while (arr[i - 1] <= arr[j]) {
            j--;
        }

        swap(arr, i - 1, j);

        j = arr.length - 1;

        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }

        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
