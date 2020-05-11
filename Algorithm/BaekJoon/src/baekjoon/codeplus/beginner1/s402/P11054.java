package baekjoon.codeplus.beginner1.s402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11054 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bufferedReader.readLine());
            String[] inputText = bufferedReader.readLine().split(" ");

            int[] a = new int[n + 1];
            int[] d1 = new int[n + 1];
            int[] d2 = new int[n + 1];
            int answer = 0;

            // 입력
            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(inputText[i - 1]);
            }

            // 증가
            for (int i = 1; i <= n; i++) {
                d1[i] = 1;
                for (int j = 1; j < i; j++) {
                    if (a[i] > a[j] && d1[i] < d1[j] + 1) {
                        d1[i] = d1[j] + 1;
                    }
                }
            }

            // 감소
            for (int i = n; i >= 1; i--) {
                d2[i] = 1;
                for (int j = n; j >= i; j--) {
                    if (a[i] > a[j] && d2[i] < d2[j] + 1) {
                        d2[i] = d2[j] + 1;
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                if (answer < d1[i] + d2[i] - 1) {
                    answer = d1[i] + d2[i] - 1;
                }
            }

            System.out.println(answer);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
