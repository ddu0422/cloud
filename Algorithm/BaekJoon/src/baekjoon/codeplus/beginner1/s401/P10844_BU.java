package baekjoon.codeplus.beginner1.s401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10844_BU {
    private static long mod = 1_000_000_000;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());
            long answer = 0L;
            int[][] d = new int[101][10];

            // 길이가 1개짜리인 건 1개씩 존재
            for (int i = 1; i <= 9; i++) d[1][i] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 0; j <= 9; j++) {
                    // 0, 9를 제외시키기 위해
                    if (j - 1 >= 0) d[i][j] += d[i - 1][j - 1];
                    if (j + 1 <= 9) d[i][j] += d[i - 1][j + 1];
                    d[i][j] %= mod;
                }
            }

            for (int i = 0; i <= 9; i++) answer +=  d[n][i];

            System.out.println(answer % mod);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
