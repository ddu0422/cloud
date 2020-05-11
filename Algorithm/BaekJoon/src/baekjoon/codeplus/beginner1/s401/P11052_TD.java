package baekjoon.codeplus.beginner1.s401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11052_TD {
    private static int[] d;
    private static int[] p;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            String[] numbers = bufferedReader.readLine().split(" ");
            d = new int[n + 1];
            p = new int[n + 1];

            for (int i = 1; i < p.length; i++) {
                p[i] = Integer.parseInt(numbers[i - 1]);
            }

            System.out.println(cardPrice(n));

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }

    private static int cardPrice(int n) {
        if (n == 0) return 0; // 0은 제외
        if (d[n] > 0) return d[n]; // 값이 존재하는 경우 바로 return [성능 향상]

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int prev = cardPrice(n - i) + p[i];
                if (d[n] < prev) d[n] = prev;
            }
        }

        return d[n];
    }
}
