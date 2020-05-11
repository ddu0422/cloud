package baekjoon.codeplus.beginner1.s402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9465 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int count = Integer.parseInt(bufferedReader.readLine());

            while (count-- > 0) {
                int n = Integer.parseInt(bufferedReader.readLine());
                long[][] a = new long[n + 1][2];
                long[][] d = new long[n + 1][3];

                for (int i = 0; i < 2; i++) {
                    String[] inputText = bufferedReader.readLine().split(" ");
                    for (int j = 1; j <= n; j++) {
                        a[j][i] = Long.parseLong(inputText[j - 1]);
                    }
                }

                for (int i = 1; i <= n; i++) {
                    d[i][0] = Math.max(d[i - 1][0], Math.max(d[i - 1][1], d[i - 1][2]));
                    d[i][1] = Math.max(d[i - 1][0], d[i - 1][2]) + a[i][0];
                    d[i][2] = Math.max(d[i - 1][0], d[i - 1][1]) + a[i][1];
                }

                System.out.println(Math.max(d[n][0], Math.max(d[n][1], d[n][2])));
            }

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
