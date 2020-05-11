package baekjoon.codeplus.beginner1.s402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1149 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());
            int[][] d = new int[n + 1][4];
            int[][] a = new int[n + 1][4];

            for (int i = 1; i <= n; i++) {
                String[] inputText = bufferedReader.readLine().split(" ");
                for (int j = 1; j <= 3; j++) {
                    a[i][j] = Integer.parseInt(inputText[j - 1]);
                }
            }

            for (int i = 1; i <= n; i++) {
                d[i][1] = Math.min(d[i - 1][2], d[i - 1][3]) + a[i][1];
                d[i][2] = Math.min(d[i - 1][1], d[i - 1][3]) + a[i][2];
                d[i][3] = Math.min(d[i - 1][1], d[i - 1][2]) + a[i][3];
            }

            System.out.println(Math.min(Math.min(d[n][1], d[n][2]), d[n][3]));

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }

    }
}
