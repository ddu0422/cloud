package baekjoon.codeplus.beginner1.s203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10808 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder stringBuilder = new StringBuilder();

            int[] alpha = new int[26];
            String[] inputText = bufferedReader.readLine().split("");

            for (String text : inputText) {
                alpha[text.charAt(0) - 97] += 1;
            }

            for (int count : alpha) {
                stringBuilder.append(count).append(" ");
            }

            System.out.println(stringBuilder.toString());

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
