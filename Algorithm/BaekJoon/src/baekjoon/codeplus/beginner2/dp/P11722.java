package baekjoon.codeplus.beginner2.dp;

import java.util.Scanner;

// 가장 긴 감소하는 부분 수열
// d[n] : 가장 긴 감소하는 부분 수열의 길이
// 1. d[i] = 1 -> 내림차순이 아니면 길이는 1
// 2. a[j] > a[i]
// 3. d[i] < d[j] + 1

public class P11722 {
    private static int[] d;
    private static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        d = new int[n + 1];
        a = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            d[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (a[j] > a[i] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }
        }

        int answer = d[1];

        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, d[i]);
        }

        System.out.println(answer);
    }
}
