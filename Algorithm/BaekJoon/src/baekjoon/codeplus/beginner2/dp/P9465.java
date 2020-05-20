package baekjoon.codeplus.beginner2.dp;

import java.util.Scanner;

// 스티커
// max(d[n][m])
// 1. d[n][m] : n 번째에서 m의 경우일 때 최대 점수
// 2. d[n][0] : n 번째에서 0의 경우일 때 최대 점수 (x, x)
// 3. d[n][1] : n 번째에서 1의 경우일 때 최대 점수 (x, o)
// 4. d[n][2] : n 번째에서 2의 경우일 때 최대 점수 (o, x)
// 5. d[n][0] = max(d[n - 1][1], d[n - 1][2])
// 6. d[n][1] = max(d[n - 1][0], d[n - 1][2]) + a[1]
// 7. d[n][2] = max(d[n - 1][0], d[n - 1][1]) + a[2]

public class P9465 {
    private static int[][] d;
    private static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();

            d = new int[n + 1][3];
            a = new int[n + 1][3];

            for (int i = 1; i <= 2; i++) {
                for (int j = 1; j <= n; j++) {
                    a[j][i] = scanner.nextInt();
                }
            }

            for (int i = 1; i <= n; i++) {
                d[i][0] = Math.max(d[i - 1][1], d[i - 1][2]) + a[i][0];
                d[i][1] = Math.max(d[i - 1][0], d[i - 1][2]) + a[i][1];
                d[i][2] = Math.max(d[i - 1][0], d[i - 1][1]) + a[i][2];
            }

            System.out.println(Math.max(d[n][0], Math.max(d[n][1], d[n][2])));
        }
    }
}
