package baekjoon.codeplus.beginner1.s301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 모든 최대공약수를 구할 필요가 없다.
// 하나의 최대공약수를 구하고 나머지 숫자와 비교하면된다.

public class P17087 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String[] firstInput = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(firstInput[0]);
            long s = Long.parseLong(firstInput[1]);

            String[] secondInput = bufferedReader.readLine().split(" ");

            long[] numbers = new long[n];

            for (int i = 0; i < n; i++) {
                numbers[i] = Math.abs(Long.parseLong(secondInput[i]) - s);
            }

            long answer = numbers[0];

            for (int i = 1; i < numbers.length; i++) {
                answer = gcd(answer, numbers[i]);
            }

            System.out.println(answer);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
