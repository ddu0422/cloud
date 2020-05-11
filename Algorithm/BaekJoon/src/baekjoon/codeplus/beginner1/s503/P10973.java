package baekjoon.codeplus.beginner1.s503;

import java.util.Scanner;

// 이전 순열 -> 다음 순열의 부등호를 바꿔준다.

public class P10973 {
    private static int[] a = new int[10_000];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        if (prevPermutation(n)) {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }

    private static boolean prevPermutation(int n) {
        // 1번 a[i - 1] > a[i] 중 가장 큰 i를 찾는다.
        int i = n - 1;
        while (i > 0 && a[i - 1] <= a[i]) {
            i -= 1;
        }

        if (i <= 0) return false; // 마지막 순열 !!

        // 2번 a[i - 1] > a[j] 중 가장 큰 j를 찾는다.
        int j = n - 1;
        while (a[j] >= a[i - 1]) {
            j -= 1;
        }

        // 3번 둘이 바꾼다.
        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        // 4번 a[i] 뒤를 뒤집는다.
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
