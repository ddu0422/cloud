package baekjoon.codeplus.beginner1.s402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2156 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());
            int[] a = new int[n + 1];
            int[][] d = new int[n + 1][3];

            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(bufferedReader.readLine());
            }

            d[1][1] = a[1];

            for (int i = 2; i <= n; i++) {
                d[i][0] = Math.max(d[i - 1][0], Math.max(d[i - 1][1], d[i - 1][2]));
                d[i][1] = d[i - 1][0] + a[i];
                d[i][2] = d[i - 1][1] + a[i];
            }

            System.out.println(Math.max(d[n][0], Math.max(d[n][1], d[n][2])));

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
