package baekjoon.codeplus.beginner1.s402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11055 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());
            String[] inputText = bufferedReader.readLine().split(" ");
            int[] a = new int[n + 1];
            int[] d = new int[n + 1];
            int answer = 0 ;

            // 입력
            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(inputText[i - 1]);
            }

            // 문제풀이
            for (int i = 1; i <= n; i++) {
                d[i] = a[i];
                for (int j = 1; j < i; j++) {
                    if (a[j] < a[i] && d[i] < d[j] + a[i]) {
                        d[i] = d[j] + a[i];
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                if (answer < d[i]) {
                    answer = d[i];
                }
            }

            System.out.println(answer);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
