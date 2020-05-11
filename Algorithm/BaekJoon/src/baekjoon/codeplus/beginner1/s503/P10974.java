package baekjoon.codeplus.beginner1.s503;

import java.util.Scanner;

// 모든 순열 -> do-while을 사용한다.

public class P10974 {
    private static int[] a = new int[8];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }

        do {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        } while(nextPermutation(n));
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
