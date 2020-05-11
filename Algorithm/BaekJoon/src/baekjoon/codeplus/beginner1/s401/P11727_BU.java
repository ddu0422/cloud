package baekjoon.codeplus.beginner1.s401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11727_BU {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());
            int[] d = new int[n + 1];
            d[0] = d[1] = 1;

            for (int i = 2; i <= n; i++) {
                d[i] = d[i - 1] + 2 * d[i - 2];
                d[i] %= 10007;
            }

            System.out.println(d[n]);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
