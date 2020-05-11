package baekjoon.codeplus.beginner1.s301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2089 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder stringBuilder = new StringBuilder();
            long number = Integer.parseInt(bufferedReader.readLine());

            if (number == 0) {
                stringBuilder.append(0);
            } else {
                while (true) {
                    long temp = number;
                    number /= -2;

                    if (number > 0 && temp < -2) {
                        number++;
                    } else if (temp == 1) {
                        stringBuilder.append(1);
                        break;
                    } else if (temp == -1) {
                        stringBuilder.append(11);
                        break;
                    }

                    stringBuilder.append(temp - number * -2);
                }
            }

            System.out.println(stringBuilder.reverse().toString());

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
