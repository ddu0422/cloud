package baekjoon.codeplus.beginner1.s301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2745 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String[] inputText = bufferedReader.readLine().split(" ");

            char[] number = inputText[0].toCharArray();
            int base = Integer.parseInt(inputText[1]);
            int answer = 0;

            int[] numbers = new int[36];

            for (int i = 0; i < 10; i++) {

            }



            for (int i = 0; i < number.length; i++) {
                answer += numbers[i] * base * Math.pow(10, number.length - 1 - i);
            }


        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
