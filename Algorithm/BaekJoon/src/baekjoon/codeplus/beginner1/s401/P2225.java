package baekjoon.codeplus.beginner1.s401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2225 {
    private static long MOD = 1_000_000_000L;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String[] inputText = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(inputText[0]);
            int k = Integer.parseInt(inputText[1]);
            long[][] d = new long[k + 1][n + 1];

            d[0][0] = 1;

            for (int i = 1; i <= k; i++) {
                for (int j = 0; j <= n; j++) {
                    for (int l = 0; l <= j; l++) {
                        d[i][j] += d[i - 1][j - l];
                        d[i][j] %= MOD;
                    }
                }
            }

            System.out.println(d[k][n]);


        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
