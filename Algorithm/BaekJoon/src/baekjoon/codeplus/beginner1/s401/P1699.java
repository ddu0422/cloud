package baekjoon.codeplus.beginner1.s401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1699 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] d = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                d[i] = i;
                for (int j = 1; j * j <= i; j++) {
                    int prev = d[i - j * j] + 1;

                    if (d[i] > prev) {
                        d[i] = prev;
                    }
                }
            }

            System.out.println(d[n]);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
