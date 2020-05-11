package baekjoon.codeplus.beginner1.s402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11057 {
    private static final int MOD = 10007;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());
            long[][] d = new long[n + 1][10];

            for (int i = 0; i <= 9; i++) d[1][i] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 0; j <= 9; j++) {
                    for (int k = 0; k <= j; k++) {
                        d[i][j] += d[i - 1][k];
                        d[i][j] %= MOD;
                    }
                }
            }

            long answer = 0;

            for (int i = 0; i < 10; i++) answer += d[n][i];

            System.out.println(answer % MOD);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
