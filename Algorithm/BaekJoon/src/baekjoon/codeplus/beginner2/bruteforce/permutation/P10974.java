package baekjoon.codeplus.beginner2.bruteforce.permutation;

import java.util.Scanner;

// 모든 순열
// 1. 다음 순열을 이용해서 출력한다.

public class P10974 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }

        do {
            printPermutation(arr);
        } while (nextPermutation(arr));
    }

    private static void printPermutation(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;
        int j = arr.length - 1;

        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        while (arr[i - 1] >= arr[j]) {
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
