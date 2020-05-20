package baekjoon.codeplus.beginner2.dp;

import java.util.Scanner;

// 정수 삼각형
// d[n][m] = max(d[n - 1][m], d[n -1][m + 1])
// 1. d[n][m] = n 줄에서 m 번째 숫자일 때 숫자의 합 최대
// 2. d[n - 1][m - 1] = n - 1 줄에서 m - 1 번째 숫자일 때 숫자의 합 최대
// 3. d[n - 1][m] = n - 1 줄에서 m 번째 숫자일 때 숫자의 합 최대
// 0 <= m <= n
// m 일때, d[n - 1][m]은 존재하지 않음 -> 0으로 처리
// 1 일때, d[n - 1][0]은 존재하지 않음 -> 0으로 처리

public class P1932 {
    private static int[][] d;
    private static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        d = new int[n + 1][n + 1];
        a = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + a[i][j];
            }
        }

        int answer = d[n][1];

        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, d[n][i]);
        }

        System.out.println(answer);
    }
}
