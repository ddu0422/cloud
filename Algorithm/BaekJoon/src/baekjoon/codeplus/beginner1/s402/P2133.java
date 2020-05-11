package baekjoon.codeplus.beginner1.s402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2133 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());
            int[] d = new int[n + 1];

            d[0] = 1;

            for (int i = 2; i <= n; i += 2) {
                d[i] = d[i - 2] * 3;
                for (int j = i - 4; j >= 0; j -= 2) {
                    d[i] += d[j] * 2;
                }
            }

            System.out.println(d[n]);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
