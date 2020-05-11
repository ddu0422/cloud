package baekjoon.codeplus.beginner1.s401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15990_BU {
    private static final long MOD = 1_000_000_009L;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int count = Integer.parseInt(bufferedReader.readLine());
            long[][] d = new long[100001][4];

            d[1][1] = d[2][2] = d[3][1] = d[3][2] = d[3][3] = 1;

            while (count-- > 0) {
                int n = Integer.parseInt(bufferedReader.readLine());

                for (int i = 4; i <= n; i++) {
                    d[i][1] = (d[i - 1][2] + d[i - 1][3]) % MOD;
                    d[i][2] = (d[i - 2][3] + d[i - 2][1]) % MOD;
                    d[i][3] = (d[i - 3][1] + d[i - 3][2]) % MOD;
                }

                System.out.println((d[n][1] + d[n][2] + d[n][3]) % MOD);
            }

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
