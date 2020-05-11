package baekjoon.codeplus.beginner1.s301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최대공약수 while문으로

public class P1934 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int count = Integer.parseInt(bufferedReader.readLine());

            while (count-- > 0) {
                String[] inputText = bufferedReader.readLine().split(" ");
                int a = Integer.parseInt(inputText[0]);
                int b = Integer.parseInt(inputText[1]);
                System.out.println(lcm(a, b, gcd(a, b)));
            }

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }

    private static int lcm(int a, int b, int gcd) {
        return a * b / gcd;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
