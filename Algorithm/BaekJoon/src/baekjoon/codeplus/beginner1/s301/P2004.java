package baekjoon.codeplus.beginner1.s301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 조합 0의 개수

public class P2004 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String[] inputText = bufferedReader.readLine().split(" ");
            long m = Long.parseLong(inputText[0]);
            long n = Long.parseLong(inputText[1]);
            long five = 0;
            long two = 0;

            for (long i = 5; i <= m; i *= 5) {
                five += m / i;
                five -= n / i;
                five -= (m - n) / i;
            }

            for (long i = 2; i <= m; i *= 2) {
                two += m / i;
                two -= n / i;
                two -= (m - n) / i;
            }

            System.out.println(Math.min(five, two));

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
