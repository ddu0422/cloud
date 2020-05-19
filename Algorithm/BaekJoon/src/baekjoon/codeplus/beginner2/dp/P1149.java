package baekjoon.codeplus.beginner2.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// RGB 거리
// min(d[n][0], d[n][1], d[n][2])
// 1. d[n][m] = m번째 색깔로 칠했을 때 n의 집을 칠하는 최소 비용
// 2. d[n][0] = 0번째 색깔로 칠했을 때 n의 집을 칠하는 최소 비용
// 3. d[n][1] = 1번째 색깔로 칠했을 때 n의 집을 칠하는 최소 비용
// 4. d[n][2] = 2번째 색깔로 칠했을 때 n의 집을 칠하는 최소 비용
// 5. d[n][0] = min(d[n - 1][1], d[n - 1][2]) + a[0]
// 6. d[n][1] = min(d[n - 1][0], d[n - 1][2]) + a[1]
// 7. d[n][2] = min(d[n - 1][0], d[n - 1][1]) + a[2]

public class P1149 {
    private static final String BLANK = " ";
    private static int[][] d;
    private static int[][] a;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());

            d = new int[n + 1][3];
            a = new int[n + 1][3];

            for (int i = 1; i <= n; i++) {
                String[] inputText = bufferedReader.readLine().split(BLANK);
                for (int j = 0; j < inputText.length; j++) {
                    a[i][j] = Integer.parseInt(inputText[j]);
                }
            }

            for (int i = 1; i <= n; i++) {
                d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + a[i][0];
                d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + a[i][1];
                d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + a[i][2];
            }

            System.out.println(Math.min(d[n][0], Math.min(d[n][1], d[n][2])));


        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
