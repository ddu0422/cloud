package baekjoon.codeplus.beginner1.s301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9612 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int count = Integer.parseInt(bufferedReader.readLine());

            while (count-- > 0) {
                String[] inputText = bufferedReader.readLine().split(" ");
                int[] numbers = new int[Integer.parseInt(inputText[0])];
                long answer = 0;

                for (int i = 0; i < inputText.length - 1; i++) {
                    numbers[i] = Integer.parseInt(inputText[i + 1]);
                }

                for (int i = 0; i < numbers.length - 1; i++) {
                    for (int j = i + 1; j < numbers.length; j++) {
                        answer += gcd(numbers[i], numbers[j]);
                    }
                }

                System.out.println(answer);
            }


        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }

    // 방법 1
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    // 방법 2
    public static int gcd1(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
