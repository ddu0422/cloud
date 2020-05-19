package baekjoon.codeplus.beginner2.dp;

// 연속합
// d[n] = max(d[n - 1] + a[n], a[n])
// 구하는 답은 max(d[n])
// 1. d[n] = 연속된 합 중 가장 큰 값
// 2. d[n - 1] = n - 1 번째까지 연속된 합 중 가장 큰 값
// 3. d[n - 1] > a[n]보다 d[n - 1] + a[n]
// 4. d[n - 1] < a[n]보다 작은 경우 a[n]

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1912 {
    private static final String BLANK = " ";
    private static int[] d;
    private static int[] a;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());
            String[] inputText = bufferedReader.readLine().split(BLANK);

            d = new int[n + 1];
            a = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(inputText[i - 1]);
            }

            for (int i = 1; i <= n; i++) {
                d[i] = Math.max(d[i - 1] + a[i], a[i]);
            }

            int answer = d[1];

            for (int i = 1; i <= n; i++) {
                answer = Math.max(answer, d[i]);
            }

            System.out.println(answer);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
