package baekjoon.codeplus.beginner1.s401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1463_BU {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());
            int[] d = new int[n + 1];

            for (int i = 2; i <= n; i++) {
                d[i] = d[i - 1] + 1;
                if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
                    d[i] = d[i / 2] + 1;
                }
                if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
                    d[i] = d[i / 3] + 1;
                }
            }

            System.out.println(d[n]);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
