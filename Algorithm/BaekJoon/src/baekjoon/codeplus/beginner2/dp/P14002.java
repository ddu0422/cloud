package baekjoon.codeplus.beginner2.dp;

import java.util.Arrays;
import java.util.Scanner;

// 가장 긴 증가하는 부분 수열 4
// 1. 이전 값의 결과가 중요하지 않는 경우 (즉, 알 수 없는 경우)
// 2. Bottom - Up을 사용한다.

public class P14002 {
    private static int[] d;
    private static int[] a;
    private static int[] v;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        d = new int[n + 1];
        a = new int[n + 1];
        v = new int[n + 1];

        Arrays.fill(d, 1);
        Arrays.fill(v, -1);

        for (int i = 1; i <= n ; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (a[j] < a[i] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                    v[i] = j;
                }
            }
        }

        int max = 0;
        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (max < d[i]) {
                max = d[i];
                index = i;
            }
        }

        System.out.println(max);
        print(index);
    }

    private static void print(int n) {
        if (n == -1) return;

        print(v[n]);
        System.out.print(a[n] + " ");
    }
}
