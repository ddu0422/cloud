package baekjoon.codeplus.beginner1.s401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P16194_TD {
    private static int[] d;
    private static int[] p;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bufferedReader.readLine());
            String[] numbers = bufferedReader.readLine().split(" ");

            d = new int[n + 1];
            p = new int[n + 1];
            Arrays.fill(d, -1);
            d[0] = 0;

            for (int i = 1; i < p.length; i++) {
                p[i] = Integer.parseInt(numbers[i - 1]);
            }

            System.out.println(cardPrice(n));

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }

    private static int cardPrice(int n) {
        if (n == 0) return 0;
        if (d[n] > 0) return d[n];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int prev = d[i - j] + p[j];
                if (d[i] == -1 || d[i] > prev) {
                    d[i] = prev;
                }
            }
        }

        return d[n];
    }
}
