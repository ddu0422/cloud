package baekjoon.codeplus.beginner1.s301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 에라토스테네스의 체

public class P1929 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder stringBuilder = new StringBuilder();

            String[] inputText = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(inputText[0]);
            int b = Integer.parseInt(inputText[1]);

            boolean[] isPrime = new boolean[b + 1];
            Arrays.fill(isPrime, true);
            isPrime[0] = isPrime[1] = false;

            for (int i = 2; i * i <= b; i++) {
                if (isPrime[i]) {
                    for (int j = i * 2; j <= b; j += i) {
                        isPrime[j] = false;
                    }
                }
            }

            for (int i = a; i <= b; i ++) {
                if (isPrime[i]) {
                    stringBuilder.append(i).append("\n");
                }
            }

            System.out.println(stringBuilder.toString());

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
