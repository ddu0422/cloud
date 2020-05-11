package baekjoon.codeplus.beginner1.s301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11005 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder stringBuilder = new StringBuilder();
            String[] inputText = bufferedReader.readLine().split(" ");

            char[] numbers = new char[36];

            for (int i = 0; i < 10; i++) {
                numbers[i] = (char) (i + '0');
            }

            for (int i = 10; i < numbers.length; i++) {
                numbers[i] = (char) (i - 10 + 'A');
            }

            int number = Integer.parseInt(inputText[0]);
            int base = Integer.parseInt(inputText[1]);

            while (number != 0) {
                stringBuilder.append(numbers[number % base]);
                number /= base;
            }

            System.out.println(stringBuilder.reverse().toString());

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }

    }
}
