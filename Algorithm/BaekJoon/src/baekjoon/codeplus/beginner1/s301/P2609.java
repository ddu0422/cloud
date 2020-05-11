package baekjoon.codeplus.beginner1.s301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최대공약수 -> 유클리드호제법 gcd(a, b) = gcd(b, r)
// 최소공배수 -> a * b / gcd

public class P2609 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String[] inputText = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(inputText[0]);
            int b = Integer.parseInt(inputText[1]);
            int gcd = gcd(a, b);

            System.out.println(gcd);
            System.out.println(lcm(a, b, gcd));


        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }

    private static int lcm(int a, int b, int gcd) {
        return a * b / gcd;
    }

    // 최대공약수 방법 1
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // 최대공약수 방법2
    private static int gcd1(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
