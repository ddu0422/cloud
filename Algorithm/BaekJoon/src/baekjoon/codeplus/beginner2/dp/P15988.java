package baekjoon.codeplus.beginner2.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1, 2, 3 더하기 3
// d[n] = d[n - 1] + d[n - 2] + d[n - 3]
// 1. d[n] = 1, 2, 3으로 n을 만들 수 있는 방법의 수
// 2. d[n - 1] = 마지막이 1이고 1, 2, 3으로 n을 만들 수 있는 방법의 수
// 3. d[n - 2] = 마지막이 2이고 1, 2, 3으로 n을 만들 수 있는 방법의 수
// 4. d[n - 3] = 마지막이 3이고 1, 2, 3으로 n을 만들 수 있는 방법의 수
// 5. d[1] = 1, d[2] = 2, d[3] = 4 이므로 d[0] = 1로 설정

public class P15988 {
    private static final int LIMIT = 1_000_000;
    private static final long MOD = 1_000_000_009;
    private static long[] d;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());

            d = new long[LIMIT + 1];

            d[0] = 1; d[1] = 1; d[2] = 2;

            for (int i = 3; i <= LIMIT; i++) {
                d[i] = (d[i - 1] + d[i - 2] + d[i - 3]) % MOD;
            }

            while (n-- > 0) {
                int t = Integer.parseInt(bufferedReader.readLine());
                System.out.println(d[t]);
            }

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
