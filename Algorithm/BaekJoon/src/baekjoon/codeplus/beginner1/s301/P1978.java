package baekjoon.codeplus.beginner1.s301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// prime 개수 구하기

public class P1978 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int count = Integer.parseInt(bufferedReader.readLine());
            String[] inputText = bufferedReader.readLine().split(" ");
            int[] numbers = new int[count];
            int answer = 0;

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(inputText[i]);
            }

            for (int number : numbers) {
                answer += prime(number);
            }

            System.out.println(answer);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }

    private static int prime(int number) {
        if (number < 2) {
            return 0;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return 0;
            }
        }

        return 1;
    }
}
