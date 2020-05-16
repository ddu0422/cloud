package baekjoon.codeplus.beginner2.math1;

import java.util.Scanner;

// 2진수 8진수
// 1. 8진수는 2진수를 뒤에서부터 세자리씩 끊어서 계산한다.
// 2. 각 끊어진 세자리를 붙여서 출력한다.

public class P1373 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();

        String inputText = scanner.nextLine();
        int[] binaries = {4, 2, 1};

        if (inputText.length() % 3 == 1) {
            inputText = "00" + inputText;
        } else if (inputText.length() % 3 == 2) {
            inputText = "0" + inputText;
        }

        char[] numbers = inputText.toCharArray();

        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += (numbers[i] - '0') * binaries[i % 3];

            if (i % 3 == 2) {
                stringBuilder.append(sum);
                sum = 0;
            }
        }

        System.out.println(stringBuilder.toString());
    }
}
