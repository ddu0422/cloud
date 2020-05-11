package baekjoon.codeplus.beginner1.s301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 팩토리얼 0의 개수
// 2보단 5가 적으므로 5의 개수만 센다

public class P1676 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int number = Integer.parseInt(bufferedReader.readLine());
            int answer = 0;

            for (int i = 5 ; i <= number; i *= 5) {
                answer += number / i;
            }

            System.out.println(answer);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
