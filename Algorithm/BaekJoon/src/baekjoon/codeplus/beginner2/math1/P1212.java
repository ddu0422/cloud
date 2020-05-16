package baekjoon.codeplus.beginner2.math1;

import java.util.Scanner;

// 8진수 2진수
// 1. 각 숫자를 가지는 배열을 만든다.
// 2. 0이면 0을 출력한다.
// 3. 0이 아니면 처음으로 1이 나올때부터 출력한다.

public class P1212 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();

        String[] octal = {
                "000", "001", "010", "011",
                "100", "101", "110", "111"
        };

        for (char c : scanner.nextLine().toCharArray()) {
            stringBuilder.append(octal[c - '0']);
        }

        int one = stringBuilder.indexOf("1");

        if (one != -1) {
            System.out.println(stringBuilder.substring(one));
        } else {
            System.out.println("0");
        }
    }
}
