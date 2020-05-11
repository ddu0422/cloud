package baekjoon.codeplus.beginner1.s401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11052_BU {
    public static void main(String[] args) {
        try {
            // 입력
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bufferedReader.readLine());
            String[] numbers = bufferedReader.readLine().split(" ");

            // 문제풀이 전 세팅
            int[] d = new int[n + 1];
            int[] p = new int[n + 1];

            for (int i = 1; i < p.length; i++) {
                p[i] = Integer.parseInt(numbers[i - 1]);
            }

            // 문제풀이
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    int prev = d[i - j] + p[j];
                    if (d[i] < prev) {
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
