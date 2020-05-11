package baekjoon.codeplus.beginner1.s401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2193_BU {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());
            long[][] d = new long[n + 1][2];
            long answer;

            d[1][0] = 0;
            d[1][1] = 1;

            for (int i = 2; i <= n; i++) {
                // 0으로 끝나는 경우는 앞에 0, 1이 올 수 있다.
                d[i][0] = d[i - 1][0] + d[i - 1][1];
                // 1로 끝나는 경우는 앞에 0만 올 수 있다.
                d[i][1] = d[i - 1][0];
            }

            answer = d[n][0] + d[n][1];

            System.out.println(answer);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
