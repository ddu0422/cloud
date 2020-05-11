package baekjoon.codeplus.beginner1.s301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P17103 {
    private static final int MAX = 1_000_001;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            boolean[] isPrimes = new boolean[MAX];
            Arrays.fill(isPrimes, true);
            isPrimes[0] = isPrimes[1] = false;

            for (int i = 2; i * i < MAX; i++) {
                if (isPrimes[i]) {
                    for (int j = i * 2; j < MAX; j += i) {
                        isPrimes[j] = false;
                    }
                }
            }

            int count = Integer.parseInt(bufferedReader.readLine());
            int answer = 0;

            while (count-- > 0) {
                int number = Integer.parseInt(bufferedReader.readLine());

                for (int i = 2; i <= number / 2; i++) {
                    if (isPrimes[i] && isPrimes[number - i]) {
                        answer++;
                    }
                }

                System.out.println(answer);
                answer = 0;
            }

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
