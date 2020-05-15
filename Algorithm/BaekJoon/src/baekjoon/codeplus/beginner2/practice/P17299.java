package baekjoon.codeplus.beginner2.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringJoiner;

public class P17299 {
    private static final String BLANK = " ";
    private static final int LIMIT = 1_000_000;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringJoiner stringJoiner = new StringJoiner(BLANK);

            int n = Integer.parseInt(bufferedReader.readLine());
            String[] inputText = bufferedReader.readLine().split(BLANK);

            int[] arr = new int[LIMIT + 1];
            int[] answers = new int[n];
            int[] numbers = new int[n];
            Stack<Integer> stacks = new Stack<>();

            Arrays.fill(answers, -1);

            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(inputText[i]);
            }

            for (int i = 0; i < n; i++) {
                arr[numbers[i]] += 1;
            }

            for (int i = 0; i < n; i++) {
                while (!stacks.isEmpty() && arr[numbers[stacks.peek()]] < arr[numbers[i]]) {
                    answers[stacks.pop()] = numbers[i];
                }
                stacks.push(i);
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
