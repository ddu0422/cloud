package baekjoon.codeplus.beginner1.s401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9095_TD {
    private static int[] d;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            d = new int[11];
            go(10);

            int count = Integer.parseInt(bufferedReader.readLine());

            while (count-- > 0) {
                System.out.println(d[Integer.parseInt(bufferedReader.readLine())]);
            }

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }

    private static int go(int n) {
        d[0] = d[1] = 1;
        d[2] = 2;
        if (d[n] > 0) return d[n];
        d[n] = go(n - 1) + go(n - 2) + go(n - 3);

        return d[n];
    }
}
