package baekjoon.codeplus.beginner1.s402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1309 {
    private static final int MOD = 9901;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());
            int[][] d = new int[n + 1][3];

            d[1][0] = d[1][1] = d[1][2] = 1;

            for (int i = 2; i <= n; i++) {
                d[i][0] = (d[i - 1][0] + d[i - 1][1] + d[i - 1][2]) % MOD;
                d[i][1] = (d[i - 1][0] + d[i - 1][2]) % MOD;
                d[i][2] = (d[i - 1][0] + d[i - 1][1]) % MOD;
            }

            System.out.println((d[n][0] + d[n][1] + d[n][2]) % MOD);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
