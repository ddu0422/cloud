package baekjoon.codeplus.beginner2.dp;

import java.util.Scanner;

// 가장 큰 중가하는 부분 수열
// d[n] = n일 때 최대 합
// 1. d[i] = a[i]로 초기화 -> 증가하지 않으면 자기 자신이 제일 큰 수
// 2. d[i] = d[j] + a[i]
// 3. a[j] < a[i]
// 4. d[i] < d[j] + a[i] -> 4, 2, 100 인 경우도 있어서 a[j] < a[i] 로 만 가장 큰 값을 찾을 수 없다.

public class P11055 {
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
            d[i] = a[i];
            for (int j = 1; j <= i; j++) {
                if (a[j] < a[i] && d[i] < d[j] + a[i]) {
                    d[i] = d[j] + a[i];
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
