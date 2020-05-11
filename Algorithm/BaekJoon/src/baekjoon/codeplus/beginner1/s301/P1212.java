package baekjoon.codeplus.beginner1.s301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1212 {
    //    public static void main(String[] args) {
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            StringBuilder stringBuilder = new StringBuilder();
//
//            char[] inputText = bufferedReader.readLine().toCharArray();
//
//            // 이진수로 변환한 숫자를 저장할 공간
//            long[] numbers = new long[inputText.length * 3];
//            int firstOne = 0;
//            int index = 1;
//
//            for (char c : inputText) {
//                long number = c - '0';
//
//                for (int j = 1; j <= 3; j++) {
//                    numbers[3 * index - j] = number % 2;
//                    number /= 2;
//                }
//                index++;
//            }
//
//            // 0을 없애야하므로 첫번째 1을 찾는다.
//            for (int i = 0; i < numbers.length; i++) {
//                if (numbers[i] == 1) {
//                    firstOne = i;
//                    break;
//                }
//            }
//
//            for (int i = firstOne; i < numbers.length; i++) {
//                stringBuilder.append(numbers[i]);
//            }
//
//            // 0이 입력으로 들어올 경우 확인
//            if (stringBuilder.toString().equals("000")) {
//                System.out.println("0");
//            } else {
//                System.out.println(stringBuilder.toString());
//            }
//
//        } catch (IOException e) {
//            System.err.println("Error : " + e);
//        }
//    }
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder stringBuilder = new StringBuilder();

            String[] binaries = {"000", "001", "010", "011", "100", "101", "110", "111"};

            for (char c : bufferedReader.readLine().toCharArray()) {
                stringBuilder.append(binaries[c - '0']);
            }

            String answer = stringBuilder.toString();
            int firstOne = answer.indexOf("1");

            if ("000".equals(answer)) {
                System.out.println("0");
            } else {
                System.out.println(answer.substring(firstOne));
            }

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
