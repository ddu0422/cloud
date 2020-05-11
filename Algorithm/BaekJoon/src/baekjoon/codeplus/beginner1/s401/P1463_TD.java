package baekjoon.codeplus.beginner1.s401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1463_TD {
    private static int[] d;
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());
            d = new int[n + 1];

            System.out.println(numbers(n));

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }

    private static int numbers(int n) {
        if (n == 1) return 0;
        if (d[n] > 0) return d[n];

        d[n] = numbers(n - 1) + 1;

        if (n % 2 == 0) {
            if (d[n] > d[n / 2] + 1) {
                d[n] = d[n / 2] + 1;
            }
        }

        if (n % 3 == 0) {
            if (d[n] > d[n / 3] + 1) {
                d[n] = d[n / 3] + 1;
            }
        }

        return d[n];
    }
}
