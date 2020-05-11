package baekjoon.codeplus.beginner1.s402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15988 {
    private static final long MOD = 1_000_000_009L;
    private static final int LIMIT = 1_000_000;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int count = Integer.parseInt(bufferedReader.readLine());
            long[] d = new long[LIMIT + 1];

            d[0] = d[1] = 1;
            d[2] = 2;

            for (int i = 3; i <= LIMIT; i++) {
                d[i] = d[i - 1] + d[i - 2] + d[i - 3];
                d[i] %= MOD;
            }

            while (count-- > 0) {
                System.out.println(d[Integer.parseInt(bufferedReader.readLine())]);
            }

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
