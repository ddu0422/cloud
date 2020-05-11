package baekjoon.codeplus.beginner1.s203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10809 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder stringBuilder = new StringBuilder();

            char[] inputText = bufferedReader.readLine().toCharArray();
            int[] alpha = new int[26];
            Arrays.fill(alpha, -1);

            for (int i = 0; i < inputText.length; i++) {
                int text = inputText[i] - 97;
                if (alpha[text] == -1) {
                    alpha[text] = i;
                }
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
