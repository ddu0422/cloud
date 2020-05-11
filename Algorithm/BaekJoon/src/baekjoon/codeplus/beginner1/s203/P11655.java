package baekjoon.codeplus.beginner1.s203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11655 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder stringBuilder = new StringBuilder();

            char[] inputText = bufferedReader.readLine().toCharArray();

            for (char c : inputText) {
                if ('A' <= c && 'Z' >= c) {
                    stringBuilder.append((char) ((c % 65 + 13) % 26 + 65));
                } else if ('a' <= c && 'z' >= c){
                    stringBuilder.append((char) ((c % 97 + 13) % 26 + 97));
                } else {
                    stringBuilder.append(c);
                }
            }

            System.out.println(stringBuilder.toString());

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
