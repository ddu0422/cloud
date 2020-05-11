package baekjoon.codeplus.beginner1.s402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1932 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());
            int[][] a = new int[n + 1][n + 1];
            int[][] d = new int[n + 1][n + 1];
            int answer = 0;

            // 삼각형 입력
            for (int i = 1; i <= n; i++) {
                String[] inputText = bufferedReader.readLine().split(" ");
                for (int j = 1; j <= inputText.length; j++) {
                    a[i][j] = Integer.parseInt(inputText[j - 1]);
                }
            }

            // 문제풀이
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + a[i][j];
                }
            }

            // 마지막 열중 가장 큰 값
            for (int i = 1; i <= n; i++) {
                if (answer < d[n][i]) {
                    answer = d[n][i];
                }
            }

            System.out.println(answer);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
