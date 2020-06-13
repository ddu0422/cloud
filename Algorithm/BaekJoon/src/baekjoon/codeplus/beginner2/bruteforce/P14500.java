package baekjoon.codeplus.beginner2.bruteforce;

import java.util.Scanner;

// 테트로미노
// 1. 각 도형마다 구한다.
// 2. 방향을 바꿔가면 최대값을 구핸다.
// 3. 그 중 최대를 찾는다.

public class P14500 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        int max = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                int sum = a[i][j] + a[i + 1][j] + a[i][j + 1] + a[i + 1][j + 1];
                max = Math.max(max, sum);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 3; j++) {
                int sum = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i][j + 3];
                max = Math.max(max, sum);
            }
        }

        for (int i = 0; i < n - 3; i++) {
            for (int j = 0; j < m; j++) {
                int sum = a[i][j] + a[i + 1][j] + a[i + 2][j] + a[i + 3][j];
                max = Math.max(max, sum);
            }
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                int sum1 = a[i][j] + a[i][j + 1] + a[i + 1][j + 1] + a[i + 2][j + 1];
                int sum2 = a[i][j] + a[i + 1][j] + a[i + 2][j] + a[i + 2][j + 1];
                int sum3 = a[i][j] + a[i + 1][j] + a[i + 1][j + 1] + a[i + 2][j + 1];
                int sum4 = a[i][j] + a[i + 1][j] + a[i + 2][j] + a[i + 1][j + 1];
                int sum5 = a[i + 1][j] + a[i][j + 1] + a[i + 1][j + 1] + a[i + 2][j + 1];
                int sum6 = a[i + 1][j] + a[i + 2][j] + a[i][j + 1] + a[i + 1][j + 1];
                int sum7 = a[i + 2][j] + a[i][j + 1] + a[i + 1][j + 1] + a[i + 2][j + 1];
                int sum8 = a[i][j] + a[i + 1][j] + a[i + 2][j] + a[i][j + 1];

                max = Math.max(max, Math.max(sum1, sum2));
                max = Math.max(max, Math.max(sum3, sum4));
                max = Math.max(max, Math.max(sum5, sum6));
                max = Math.max(max, Math.max(sum7, sum8));
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 2; j++) {
                int sum1 = a[i + 1][j] + a[i + 1][j + 1] + a[i + 1][j + 2] + a[i][j + 2];
                int sum2 = a[i][j] + a[i + 1][j] + a[i][j + 1] + a[i][j + 2];
                int sum3 = a[i + 1][j] + a[i][j + 1] + a[i + 1][j + 1] + a[i][j + 2];
                int sum4 = a[i + 1][j] + a[i][j + 1] + a[i + 1][j + 1] + a[i + 1][j + 2];
                int sum5 = a[i][j] + a[i][j + 1] + a[i + 1][j + 1] + a[i][j + 2];
                int sum6 = a[i][j] + a[i][j + 1] + a[i + 1][j + 1] + a[i + 1][j + 2];
                int sum7 = a[i][j] + a[i + 1][j] + a[i + 1][j + 1] + a[i + 1][j + 2];
                int sum8 = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i + 1][j + 2];

                max = Math.max(max, Math.max(sum1, sum2));
                max = Math.max(max, Math.max(sum3, sum4));
                max = Math.max(max, Math.max(sum5, sum6));
                max = Math.max(max, Math.max(sum7, sum8));
            }
        }

       System.out.println(max);
    }
}
