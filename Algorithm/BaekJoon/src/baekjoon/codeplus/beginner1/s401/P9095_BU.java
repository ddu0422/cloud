package baekjoon.codeplus.beginner1.s401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9095_BU {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int count = Integer.parseInt(bufferedReader.readLine());
            int[] d = new int[11];
            d[0] = d[1] = 1;
            d[2] = 2;

            for (int i = 3; i < d.length; i++) {
                d[i] = d[i - 1] + d[i - 2] + d[i - 3];
            }

            while (count-- > 0) {
                System.out.println(d[Integer.parseInt(bufferedReader.readLine())]);
            }

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
