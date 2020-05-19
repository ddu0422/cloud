package baekjoon.codeplus.beginner2.dp;

// 가장 긴 증가하는 부분 수열
// 1. d[n] = n 번째일 때 가장 긴 부분 수열의 길이
// 2. 크기를 비교하므로 n을 맨 끝에서 부터 하나씩 줄인다.
// 3. 모든 d[n]을 구한 후 가장 큰 값을 찾는다.

import java.util.Arrays;
import java.util.Scanner;

public class P11053 {
    private static int[] d;
    private static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        d = new int[n + 1];
        a = new int[n + 1];

        Arrays.fill(d, 1);

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        int max = 0;

        for (int i = n; i > 0; i--) {
            max = Math.max(max, go(i));
        }

        System.out.println(max);
    }

    private static int go(int n) {
        if (d[n] > 1) return d[n];

        for (int i = 1; i < n; i++) {
            if (a[i] < a[n]) {
                d[n] = Math.max(d[n], go(i) + 1);
            }
        }

        return d[n];
    }
}
