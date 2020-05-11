package baekjoon.codeplus.beginner1.s401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11726_BU {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());
            int[] d = new int[n + 1];
            d[0] = 1;
            d[1] = 1;
//            d[2] = 2; // n이 1일경우 들어올 수 없다.

            for (int i = 3; i <= n; i++) {
                d[i] = d[i - 1] + d[i - 2];
                d[i] %= 10007;
            }

            System.out.println(d[n]);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
