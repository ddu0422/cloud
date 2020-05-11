package baekjoon.codeplus.beginner1.s301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1373 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder stringBuilder = new StringBuilder();

            String inputText = bufferedReader.readLine();
            int[] arr = {4, 2, 1};
            int sum = 0;

            switch (inputText.length() % 3) {
                case 1:
                    inputText = "00" + inputText;
                    break;
                case 2:
                    inputText = "0" + inputText;
                    break;
            }

            for (int i = 0; i < inputText.length(); i++) {
                sum += (inputText.charAt(i) - '0') * arr[i % 3];
                if (i % 3 == 2) {
                    stringBuilder.append(sum);
                    sum = 0;
                }
            }

            System.out.println(stringBuilder.toString());

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
