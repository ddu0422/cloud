package baekjoon.codeplus.beginner2.dp;

import java.util.Scanner;

// 연속합 2
// max(d[1][0] ~ d[n][0], d[1][0] ~ d[n][0] + d[1][1] ~ d[n][0])
// 1. d[n][0] : n 번째일 때 해당 수를 제거하지 않은 연속 합 (왼쪽 -> 오른쪽)
// 2. d[n][1] : n 번째일 때 해당 수를 제거하지 않은 연속 합 (오른쪽 -> 왼쪽)
// 3. 수를 제거했을 때, 연속합이 최대일 수 있으므로 오르막, 내리막처럼 구해놓는다.
// ------------>
// O O O O O O O X O O O
//                 <----

public class P13398 {
    private static int[][] d;
    private static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        d = new int[n + 1][2];
        a = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            d[i][0] = Math.max(d[i - 1][0] + a[i], a[i]);
        }

        for (int i = n; i >= 1; i--) {
            d[i][1] = a[i];
            if (i == n) continue;
            d[i][1] = Math.max(d[i + 1][1] + a[i], a[i]);
        }

        int answer = d[1][0];

        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, d[i][0]);
        }

        for (int i = 1; i <= n - 1; i++) {
            answer = Math.max(answer, d[i - 1][0] + d[i + 1][1]);
        }

        System.out.println(answer);
    }
}
