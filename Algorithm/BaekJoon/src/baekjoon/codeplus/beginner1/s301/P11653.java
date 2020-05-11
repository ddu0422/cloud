package baekjoon.codeplus.beginner1.s301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11653 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int number = Integer.parseInt(bufferedReader.readLine());

            for (int i = 2; i * i <= number; i++) {
                while (number % i == 0) {
                    System.out.println(i);
                    number /= i;
                }
            }

            if (number > 1) {
                System.out.println(number);
            }

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
