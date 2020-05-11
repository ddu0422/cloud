package baekjoon.codeplus.beginner1.s402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P13398 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());
            String[] inputText = bufferedReader.readLine().split(" ");
            long[] a = new long[n + 1];
            long[] d1 = new long[n + 1];
            long[] d2 = new long[n + 1];

            for (int i = 1; i <= n; i++) {
                a[i] = Long.parseLong(inputText[i - 1]);
            }

            // ---> 방향으로 증가하면서 연속합
            for (int i = 1; i <= n; i++) {
                d1[i] = a[i];
                if (i == 1) continue;
                if (d1[i] < d1[i - 1] + a[i]) {
                    d1[i] = d1[i - 1] + a[i];
                }
            }

            // <--- 방향으로 증가하면서 연속합
            for (int i = n; i >= 1; i--) {
                d2[i] = a[i];
                if (i == n) continue;
                if (d2[i] < d2[i + 1] + a[i]) {
                    d2[i] = d2[i + 1] + a[i];
                }
            }

            long answer = d1[1];

            // 숫자를 빼지않고 연속합의 최대를 찾는다.
            for (int i = 1; i <= n; i++) {
                if (answer < d1[i]) {
                    answer = d1[i];
                }
            }

            // 숫자를 빼면서 연속합의 최대를 찾는다.
            for (int i = 1; i <= n - 1; i++) {
                if (answer < d1[i - 1] + d2[i + 1]) {
                    answer =  d1[i - 1] + d2[i + 1];
                }
            }

            System.out.println(answer);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
