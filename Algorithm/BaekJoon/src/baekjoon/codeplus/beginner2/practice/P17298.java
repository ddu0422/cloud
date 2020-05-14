package baekjoon.codeplus.beginner2.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringJoiner;

// 오큰수
// 오큰수를 stack 에 넣는다.
// 1. 숫자가 stack 보다 작거나 같다면 다음 수를 찾기
// 2. 만약 해당 수보다 큰 수가 없다면 -1

public class P17298 {
    private static final String BLANK = " ";

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringJoiner stringJoiner = new StringJoiner(BLANK);

            int n = Integer.parseInt(bufferedReader.readLine());
            String[] inputText = bufferedReader.readLine().split(BLANK);
            int[] numbers = new int[n];
            int[] answers = new int[n];
            Stack<Integer> stacks = new Stack<>();

            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(inputText[i]);
            }

            for (int i = 0; i < numbers.length; i++) {
                while (!stacks.isEmpty() && numbers[stacks.peek()] < numbers[i]) {
                    answers[stacks.pop()] = numbers[i];
                }
                stacks.push(i);
            }

            while (!stacks.isEmpty()) {
                answers[stacks.pop()] = -1;
            }

            for (int answer : answers) {
                stringJoiner.add(String.valueOf(answer));
            }

            System.out.println(stringJoiner.toString());

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
