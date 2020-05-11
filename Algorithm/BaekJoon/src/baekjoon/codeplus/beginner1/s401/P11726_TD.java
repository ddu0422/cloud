package baekjoon.codeplus.beginner1.s401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11726_TD {
    private static int[] d;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bufferedReader.readLine());
            d = new int[n + 1];

            System.out.println(go(n));

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }

    private static int go(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (d[n] > 0) return d[n];
        d[n] = go(n - 1) + go(n - 2);
        d[n] %= 10007;

        return d[n];
    }
}
